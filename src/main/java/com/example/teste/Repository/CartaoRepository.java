package com.example.teste.Repository;


import com.example.teste.Model.CartaoModel;
import com.example.teste.Model.ClienteModel;
import com.example.teste.Model.RendaInvestimentoModel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoModel, Long> {
    List<Optional<CartaoModel>> findByClienteId(Long clienteId);
}
