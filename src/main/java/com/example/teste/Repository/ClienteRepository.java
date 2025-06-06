package com.example.teste.Repository;

import com.example.teste.Model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    Optional<ClienteModel> findByNomeAndCpf(String nome, String cpf);
    Optional<ClienteModel> findByCpf(String cpf);
    @Query("SELECT c FROM ClienteModel c JOIN FETCH c.endereco WHERE c.cpf = :cpf")
Optional<ClienteModel> buscarComEnderecoPorCpf(@Param("cpf") String cpf);

}
