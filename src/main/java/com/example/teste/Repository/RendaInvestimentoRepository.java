package com.example.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste.Model.EnderecoModel;
import com.example.teste.Model.FuncioanrioModel;
import com.example.teste.Model.RendaInvestimentoModel;

import java.util.Optional;
@Repository
public interface RendaInvestimentoRepository extends JpaRepository<RendaInvestimentoModel, Long> {
    Optional<RendaInvestimentoModel> findByClienteId(Long clienteId);
}
