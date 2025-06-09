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
    private float persentualRendaInvestimentos;


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


}
