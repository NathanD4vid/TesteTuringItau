/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sptech.turingitau.Controller;

import com.sptech.turingitau.Dto.Req.TransferenciaPixDtoReq;
import com.sptech.turingitau.Dto.Req.TransferenciaTedDocDtoReq;
import com.sptech.turingitau.Dto.Req.UserLoginDtoReq;
import com.sptech.turingitau.Dto.Res.ComprovanteDtoRes;
import com.sptech.turingitau.Dto.Res.UserDtoRes;
import com.sptech.turingitau.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sptech.TuringItau.Entity.UserEntity;


import javax.validation.Valid;
import java.util.Optional;

/**
 *
 * @author Nathan David
 */
@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid UserEntity user) {

        repository.save(user);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity logarUsuario(@RequestBody @Valid UserLoginDtoReq usuario){

        Optional<UserEntity> user = repository.findByCpfAndSenha(usuario.getCpf(), usuario.getSenha());
//        List<UserEntity> listUser = repository.findAll();
//        Optional<UserEntity> user = listUser.stream()
//                .filter(usuario -> email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha()))
//                .findFirst();

        if (user.isPresent()) {
            UserEntity usuarioEntity = user.get();
            usuarioEntity.setAutenticado(true);
            repository.save(usuarioEntity);
            UserDtoRes usuarioRes = new UserDtoRes(usuarioEntity);
            return ResponseEntity.ok(usuarioRes);
        } else {
            return ResponseEntity.status(404).build();
        }

    }

    @PostMapping("/{idEmissor}/transferencias/pix")
    public ResponseEntity transferirPix(@RequestBody @Valid TransferenciaPixDtoReq transferencia, @PathVariable Integer idEmissor){

        Optional<UserEntity> userReceptor = repository.findByCpf(transferencia.getCpf());

        Optional<UserEntity> userEmissor = repository.findById(idEmissor);

        if (userReceptor.isPresent() && userEmissor.isPresent()) {
            if (transferencia.getCpf().equals(userEmissor.get().getCpf())) {
                    return ResponseEntity.status(400).build();
            }
            if (isAutenticado(idEmissor)) {
                UserEntity emissor = userEmissor.get();
                UserEntity receptor = userReceptor.get();

                if (transferencia.getQuantia() > 0 && transferencia.getQuantia() <= 5000) {

                    emissor.setSaldo(emissor.getSaldo() - transferencia.getQuantia());
                    receptor.setSaldo(receptor.getSaldo() + transferencia.getQuantia());

                    UserDtoRes emissorDto = new UserDtoRes(repository.save(emissor));
                    UserDtoRes receptorDto = new UserDtoRes(repository.save(receptor));
                    ComprovanteDtoRes comprovante = new ComprovanteDtoRes("pix",emissorDto, receptorDto);

                    return ResponseEntity.status(200).body(comprovante);
                } else {
                    return ResponseEntity.status(400).build();
                }
            } else {
                return ResponseEntity.status(401).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/{idEmissor}/transferencias/ted")
    public ResponseEntity transferirTed(@RequestBody @Valid TransferenciaTedDocDtoReq transferencia, @PathVariable Integer idEmissor){

        Optional<UserEntity> userEmissor = repository.findById(idEmissor);
        Optional<UserEntity> userReceptor = repository.findByAgenciaAndConta(transferencia.getAgencia(), transferencia.getConta());

        if (userReceptor.isPresent() && userEmissor.isPresent()) {
            if (transferencia.getConta().equals(userEmissor.get().getConta()) && transferencia.getAgencia().equals(userEmissor.get().getAgencia())) {
                return ResponseEntity.status(400).build();
            }
            if (isAutenticado(idEmissor)) {
                UserEntity emissor = userEmissor.get();
                UserEntity receptor = userReceptor.get();
                if (transferencia.getQuantia() > 5000 && transferencia.getQuantia() <= 10000) {

                    emissor.setSaldo(emissor.getSaldo() - transferencia.getQuantia());
                    receptor.setSaldo(receptor.getSaldo() + transferencia.getQuantia());

                    UserDtoRes emissorDto = new UserDtoRes(repository.save(emissor));
                    UserDtoRes receptorDto = new UserDtoRes(repository.save(receptor));
                    ComprovanteDtoRes comprovante = new ComprovanteDtoRes("Ted",emissorDto, receptorDto);

                    return ResponseEntity.status(200).body(comprovante);
                } else {
                    return ResponseEntity.status(400).build();
                }
            } else {
                return ResponseEntity.status(401).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/{idEmissor}/transferencias/doc")
    public ResponseEntity transferirDoc(@RequestBody @Valid TransferenciaTedDocDtoReq transferencia, @PathVariable Integer idEmissor){

        Optional<UserEntity> userEmissor = repository.findById(idEmissor);
        Optional<UserEntity> userReceptor = repository.findByAgenciaAndConta(transferencia.getAgencia(), transferencia.getConta());

        if (userReceptor.isPresent() && userEmissor.isPresent()) {
            if (transferencia.getConta().equals(userEmissor.get().getConta()) && transferencia.getAgencia().equals(userEmissor.get().getAgencia())) {
                return ResponseEntity.status(400).build();
            }
            if (isAutenticado(idEmissor)) {
                UserEntity emissor = userEmissor.get();
                UserEntity receptor = userReceptor.get();
                if (transferencia.getQuantia() > 10000) {

                    emissor.setSaldo(emissor.getSaldo() - transferencia.getQuantia());
                    receptor.setSaldo(receptor.getSaldo() + transferencia.getQuantia());

                    UserDtoRes emissorDto = new UserDtoRes(repository.save(emissor));
                    UserDtoRes receptorDto = new UserDtoRes(repository.save(receptor));
                    ComprovanteDtoRes comprovante = new ComprovanteDtoRes("Doc",emissorDto, receptorDto);

                    return ResponseEntity.status(200).body(comprovante);
                } else {
                    return ResponseEntity.status(400).build();
                }
            } else {
                return ResponseEntity.status(401).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/{idEmissor}/deslogar")
    public ResponseEntity deslogarUsuario(@PathVariable Integer idEmissor){

        Optional<UserEntity> user = repository.findById(idEmissor);

        if (user.isPresent()) {
            UserEntity usuarioEntity = user.get();
            usuarioEntity.setAutenticado(false);
            repository.save(usuarioEntity);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    private Boolean isAutenticado (Integer idUsuario) {

        Optional<UserEntity> user = repository.findById(idUsuario);

        if (user.isPresent())
            return user.get().isAutenticado();

        return false;
    }
}
