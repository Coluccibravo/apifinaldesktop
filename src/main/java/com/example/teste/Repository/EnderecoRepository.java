package com.example.teste.Repository;

import com.example.teste.Model.EnderecoModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
    Optional<EnderecoModel> findByClienteId(Long clienteId);
}
