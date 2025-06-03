package com.example.teste.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String niveldesuporte;

    @Column
    private String comorbidade;

    @Column
    private String mododecor;

    @Column
    private String nome;

    @Column
    private String sexo;

    @Column
    private String estadoCivil;

    @Column
    private String datanascimento1;

    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private String cor;

    @Column
    private String senha;

    @Column
    private String categoriainiciada;

    @Column
    private String categoriaatual;

    @Column
    private String meta;

    public ClienteModel() {
    }

    public ClienteModel(Long id, String nome, String sexo, String estadoCivil, String datanascimento1, String cpf, String rg, String senha, String cor, String nivelsiporte, String mododecor, String comorbidade, String categoriaatual, String categoriainiciada, String meta) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.datanascimento1 = datanascimento1;
        this.cpf = cpf;
        this.rg = rg;
        this.senha = senha;
        this.cor = cor;
        this.niveldesuporte = nivelsiporte;
        this.comorbidade = comorbidade;
        this.mododecor = mododecor;
        this.categoriaatual = categoriaatual;
        this.categoriainiciada = categoriainiciada;
        this.meta = meta;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNiveldesuporte() {
        return niveldesuporte;
    }

    public void setNiveldesuporte(String niveldesuporte) {
        this.niveldesuporte = niveldesuporte;
    }

    public String getComorbidade() {
        return comorbidade;
    }

    public void setComorbidade(String comorbidade) {
        this.comorbidade = comorbidade;
    }

    public String getMododecor() {
        return mododecor;
    }

    public void setMododecor(String mododecor) {
        this.mododecor = mododecor;
    }

    public String getCategoriainiciada() {
        return categoriainiciada;
    }

    public void setCategoriainiciada(String categoriainiciada) {
        this.categoriainiciada = categoriainiciada;
    }

    public String getCategoriaatual() {
        return categoriaatual;
    }

    public void setCategoriaatual(String categoriaatual) {
        this.categoriaatual = categoriaatual;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }
}
