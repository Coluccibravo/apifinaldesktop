package com.example.teste.Controller;

import com.example.teste.Model.FuncioanrioModel;
import com.example.teste.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
