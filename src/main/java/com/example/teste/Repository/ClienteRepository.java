package com.example.teste.Repository;

import com.example.teste.Model.ClienteModel;
import com.example.teste.Model.FuncioanrioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    Optional<ClienteModel> findByNomeAndCpf(String nome, String cpf);

}
