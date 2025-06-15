package com.example.teste.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "renda_investimento")
public class RendaInvestimentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column 
    private Float rendaMensal;

    @Column
    private Integer PessoasDependentes;

    @Column
    private Float rendaTotalresidencial;

    @Column
    private Float rendaTotalInvestimentos;

    @Column
    private Float saldo;

    @Column
    private String perfildoinvestidor;

    @Column
    private Float persentualRendaInvestimentos;

    @Column
    private String plano;

    @Column
    private String agencia;

    @Column
    private String tipo;

    @Column
    private Integer fundoimobiliario;

    @Column 
    private Integer acoes;

    @Column
    private Integer Criptomoedas;

    @Column
    private Integer poupanca;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private ClienteModel cliente;

    public RendaInvestimentoModel() {
    }

    public RendaInvestimentoModel(Float rendaMensal, Integer pessoasDependentes, Float rendaTotalresidencial, Float rendaTotalInvestimentos, Float persentualRendaInvestimentos) {
        this.rendaMensal = rendaMensal;
        this.PessoasDependentes = pessoasDependentes;
        this.rendaTotalresidencial = rendaTotalresidencial;
        this.rendaTotalInvestimentos = rendaTotalInvestimentos;
        this.persentualRendaInvestimentos = persentualRendaInvestimentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(Float rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public Integer getPessoasDependentes() {
        return PessoasDependentes;
    }

    public void setPessoasDependentes(Integer pessoasDependentes) {
        PessoasDependentes = pessoasDependentes;
    }

    public Float getRendaTotalresidencial() {
        return rendaTotalresidencial;
    }

    public void setRendaTotalresidencial(Float rendaTotalresidencial) {
        this.rendaTotalresidencial = rendaTotalresidencial;
    }

    public Float getRendaTotalInvestimentos() {
        return rendaTotalInvestimentos;
    }

    public void setRendaTotalInvestimentos(Float rendaTotalInvestimentos) {
        this.rendaTotalInvestimentos = rendaTotalInvestimentos;
    }

    public Float getPersentualRendaInvestimentos() {
        return persentualRendaInvestimentos;
    }

    public void setPersentualRendaInvestimentos(Float persentualRendaInvestimentos) {
        this.persentualRendaInvestimentos = persentualRendaInvestimentos;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
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

    public Integer getFundoimobiliario() {
        return fundoimobiliario;
    }

    public void setFundoimobiliario(Integer fundoimobiliario) {
        this.fundoimobiliario = fundoimobiliario;
    }

    public Integer getAcoes() {
        return acoes;
    }

    public void setAcoes(Integer acoes) {
        this.acoes = acoes;
    }

    public Integer getCriptomoedas() {
        return Criptomoedas;
    }

    public void setCriptomoedas(Integer criptomoedas) {
        Criptomoedas = criptomoedas;
    }

    public Integer getPoupanca() {
        return poupanca;
    }

    public void setPoupanca(Integer poupanca) {
        this.poupanca = poupanca;
    }
}