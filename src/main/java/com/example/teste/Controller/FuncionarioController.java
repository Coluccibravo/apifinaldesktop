package com.example.teste.Controller;

import com.example.teste.Model.FuncioanrioModel;
import com.example.teste.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiFuncionario")
@CrossOrigin(origins = "http://localhost:8080")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository fRepo;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody FuncioanrioModel funcionario){
        fRepo.save(funcionario);
    }

    @GetMapping("/todos")
    public List<FuncioanrioModel> buscaTodos(){
        return fRepo.findAll();
    }

    @GetMapping("/login/{username}/{senha}")
    public Optional<FuncioanrioModel> buscarPorNomeESenha(@PathVariable String username, @PathVariable String senha)
    {
        return fRepo.findByUsernameAndSenha(username,senha);
    }
}
