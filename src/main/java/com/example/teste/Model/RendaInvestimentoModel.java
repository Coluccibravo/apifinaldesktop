package com.example.teste.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "renda_investimento")
public class RendaInvestimentoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column 
    private float rendaMensal;

    @Column
    private int PessoasDependentes;

    @Column
    private float rendaTotalresidencial;

    @Column
    private float rendaTotalInvestimentos;

    @Column
    private Float saldo;

    @Column
    private String perfildoinvestidor;

    @Column
    private float persentualRendaInvestimentos;

    @Column
    private String plano;

    @Column
    private String agencia;

    @Column
    private String tipo;

    @Column
    private int fundoimobiliario;

    @Column 
    private int acoes;

    @Column
    private int Criptomoedas;

    @Column
    private int poupanca;


    @OneToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private ClienteModel cliente;

    public RendaInvestimentoModel() {
    }

    public RendaInvestimentoModel(float rendaMensal, int pessoasDependentes, float rendaTotalresidencial, float rendaTotalInvestimentos, float persentualRendaInvestimentos) {
        this.rendaMensal = rendaMensal;
        this.PessoasDependentes = pessoasDependentes;
        this.rendaTotalresidencial = rendaTotalresidencial;
        this.rendaTotalInvestimentos = rendaTotalInvestimentos;
        this.persentualRendaInvestimentos = persentualRendaInvestimentos;
    }
    public Long getId() {
        return id;
    }

    public float getRendaMensal() {
        return rendaMensal;
    }

    public int getPessoasDependentes() {
        return PessoasDependentes;
    }

    public float getRendaTotalresidencial() {
        return rendaTotalresidencial;
    }

    public float getRendaTotalInvestimentos() {
        return rendaTotalInvestimentos;
    }

    public float getPersentualRendaInvestimentos() {
        return persentualRendaInvestimentos;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRendaMensal(float rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public void setPessoasDependentes(int pessoasDependentes) {
        PessoasDependentes = pessoasDependentes;
    }

    public void setRendaTotalresidencial(float rendaTotalresidencial) {
        this.rendaTotalresidencial = rendaTotalresidencial;
    }

    public void setRendaTotalInvestimentos(float rendaTotalInvestimentos) {
        this.rendaTotalInvestimentos = rendaTotalInvestimentos;
    }

    public void setPersentualRendaInvestimentos(float persentualRendaInvestimentos) {
        this.persentualRendaInvestimentos = persentualRendaInvestimentos;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente; 
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getPerfildoinvestidor() {
        return perfildoinvestidor;
    }

    public void setPerfildoinvestidor(String perfildoinvestidor) {
        this.perfildoinvestidor = perfildoinvestidor;
    }

    public String getPlano() {
        return plano;
    }   
public void setPlano(String plano) {
        this.plano = plano;
    }
    public String getAgencia() {
        return agencia;
    }
public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public String getTipo() {
        return tipo;
    }
public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getFundoimobiliario() {
        return fundoimobiliario;
    }
public void setFundoimobiliario(int fundoimobiliario) {
        this.fundoimobiliario = fundoimobiliario;
    }
    public int getAcoes() {
        return acoes;
    }
public void setAcoes(int acoes) {
        this.acoes = acoes;
    }
    public int getCriptomoedas() {
        return Criptomoedas;
    }
public void setCriptomoedas(int criptomoedas) {
        Criptomoedas = criptomoedas;
    }
    public int getPoupanca() {
        return poupanca;
    }
public void setPoupanca(int poupanca) {
        this.poupanca = poupanca;
    }
    
}
