/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sptech.TuringItau.Entity;

import com.sptech.turingitau.Dto.Req.TransferenciaPixDtoReq;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Nathan David
 */

@Entity
public class TransferenciaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer idEmissor;
    
    private Integer idReceptor;
    
    private Double quantia;
    
    private String tipoTransferencia;

    public TransferenciaEntity(TransferenciaPixDtoReq transferencia, Integer idEmissor) {
        this.id = 0;
        this.idEmissor = idEmissor;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the idEmissor
     */
    public Integer getIdEmissor() {
        return idEmissor;
    }

    /**
     * @param idEmissor the idEmissor to set
     */
    public void setIdEmissor(Integer idEmissor) {
        this.idEmissor = idEmissor;
    }

    /**
     * @return the idReceptor
     */
    public Integer getIdReceptor() {
        return idReceptor;
    }

    /**
     * @param idReceptor the idReceptor to set
     */
    public void setIdReceptor(Integer idReceptor) {
        this.idReceptor = idReceptor;
    }

    /**
     * @return the quantia
     */
    public Double getQuantia() {
        return quantia;
    }

    /**
     * @param quantia the quantia to set
     */
    public void setQuantia(Double quantia) {
        this.quantia = quantia;
    }

    /**
     * @return the tipoTransferencia
     */
    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    /**
     * @param tipoTransferencia the tipoTransferencia to set
     */
    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }
    
    
}
