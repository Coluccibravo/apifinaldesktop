package com.example.teste.Repository;

import com.example.teste.Controller.FuncionarioController;
import com.example.teste.Model.FuncioanrioModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FuncionarioRepository extends JpaRepository<FuncioanrioModel, Long> {
    Optional<FuncioanrioModel> findByUsernameAndSenha(String username, String senha);
    Optional<FuncioanrioModel> findByUsername(String username);
    Optional<FuncioanrioModel> findByCpf(String cpf);
    Optional<FuncioanrioModel> findByEmail(String Email);
    @Transactional
    void deleteByUsername(String username);
}
