package com.example.teste.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
public class FuncioanrioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String username;

    @Column
    private String dataNascimento1;

    @Column
    private String senha;

    @Column
    private String cargo;

    @Column
    private String email;

    public String getDataNascimento1() {
        return dataNascimento1;
    }

    public void setDataNascimento1(String dataNascimento1) {
        this.dataNascimento1 = dataNascimento1;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
