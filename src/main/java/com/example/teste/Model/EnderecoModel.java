package com.example.teste.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String rua;
    @Column
    private String estado;
    @Column
    private String numero;
    @Column
    private String cidade;
    @Column
    private String bairro;
    @Column
    private String cep;
    @Column
    private String complemento;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private ClienteModel cliente;

    public EnderecoModel() {
    }
    
    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public String getEstado() {
        return estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }

}
