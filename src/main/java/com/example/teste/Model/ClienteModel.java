package com.example.teste.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String sexo;

    @Column
    private String telefone;

    @Column 
    private String celular;

    @Column
    private String email;

    @Column
    private String estadoCivil;

    @Column
    private String datanascimento1;

    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private String senha;

    
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private EnderecoModel endereco;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private RendaInvestimentoModel rendaInvestimento;   

    public ClienteModel() {
    }

    public ClienteModel(Long id, String nome, String sexo, String telefone, String celular, String email, String estadoCivil, String datanascimento1, String cpf, String rg, String senha) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.datanascimento1 = datanascimento1;
        this.cpf = cpf;
        this.rg = rg;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDatanascimento1() {
        return datanascimento1;
    }

    public void setDatanascimento1(String datanascimento1) {
        this.datanascimento1 = datanascimento1;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void getCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(EnderecoModel endereco2) {
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
