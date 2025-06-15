package com.example.teste.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste.Model.EnderecoModel;
import com.example.teste.Model.PixModel;

@Repository
public interface PixRepository extends JpaRepository<PixModel, Long> {
    Optional<PixModel> findByClienteId(Long clienteId);
}
