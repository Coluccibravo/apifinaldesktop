package com.example.teste.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cartao")
public class CartaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String numero;

    @Column
    private String cvv;

    @Column
    private String datavalidade;

    @Column
    private String nome;

    @Column
    private String tipo;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private ClienteModel cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(String datavalidade) {
        this.datavalidade = datavalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public CartaoModel(Long id, String numero, String cvv, String datavalidade, String nome, int debito, int credito, ClienteModel cliente) {
        this.id = id;
        this.numero = numero;
        this.cvv = cvv;
        this.datavalidade = datavalidade;
        this.nome = nome;
        this.cliente = cliente;
    }

    public CartaoModel() {
    }
}
