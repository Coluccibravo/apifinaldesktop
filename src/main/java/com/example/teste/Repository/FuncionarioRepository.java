package com.example.teste.Repository;

import com.example.teste.Controller.FuncionarioController;
import com.example.teste.Model.FuncioanrioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<FuncioanrioModel, Long> {
    Optional<FuncioanrioModel> findByUsernameAndSenha(String username, String senha);

}
