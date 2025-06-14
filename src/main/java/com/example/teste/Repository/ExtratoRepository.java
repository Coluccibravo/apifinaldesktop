package com.example.teste.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste.Model.ExtratoModel;

public interface ExtratoRepository extends JpaRepository<ExtratoModel, Long> {
    List<ExtratoModel> findByClienteEnvioId(Long envioId);
    List<ExtratoModel> findByClienteRecebidoId(Long recebidoId);
}


