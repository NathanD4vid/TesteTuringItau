/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sptech.turingitau.Repository;

import com.sptech.TuringItau.Entity.UserEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sptech.TuringItau.Entity.UserEntity;
import com.sptech.TuringItau.Entity.UserEntity;

/**
 *
 * @author Nathan David
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional <UserEntity> findByCpfAndSenha(String cpf, String senha);

    Optional<UserEntity> findByCpf(String cpf);

    Optional<UserEntity> findByAgenciaAndConta(String agencia, String conta);

}
