package com.example.teste.Model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "extrato")
public class ExtratoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double valor;

    @Column
    private String data;

    @ManyToOne
    @JoinColumn(name = "cliente_envio_id")
    @JsonIgnoreProperties({"extratoModel", "extratoModelEnvio", "extratoModelRecebido", "cartaoModel"})
    private ClienteModel clienteEnvio;

    @ManyToOne
    @JoinColumn(name = "cliente_recebido_id")
    @JsonIgnoreProperties({"extratoModel", "extratoModelEnvio", "extratoModelRecebido", "cartaoModel"})
    private ClienteModel clienteRecebido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ClienteModel getClienteEnvio() {
        return clienteEnvio;
    }
    public void setClienteEnvio(ClienteModel clienteEnvio) {
        this.clienteEnvio = clienteEnvio;
    }

    public ClienteModel getClienteRecebido() {
        return clienteRecebido;
    }

    public void setClienteRecebido(ClienteModel clienteRecebido) {
        this.clienteRecebido = clienteRecebido;

        }



}
