package com.example.teste.Controller;


import com.example.teste.Model.FuncioanrioModel;
import com.example.teste.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping("/buscarParaCadastroUsername/{username}")
    public Optional<FuncioanrioModel> buscarPorUsername(@PathVariable String username)
    {
        return fRepo.findByUsername(username);
    }


    @GetMapping("/buscarParaCadastroCpf/{cpf}")
    public Optional<FuncioanrioModel> buscarPorCpf(@PathVariable String cpf)
    {
        return fRepo.findByCpf(cpf);
    }


    @GetMapping("/buscarParaCadastroEmail/{email}")
    public Optional<FuncioanrioModel> buscarPorEmail(@PathVariable String email)
    {
        return fRepo.findByEmail(email);
    }

    @DeleteMapping("/deletarPorUsername/{username}")
    public void deletarPorUsername(@PathVariable String username) {
        fRepo.deleteByUsername(username);
    }

    @PutMapping("/atualizar")
    public void atualizar(@RequestBody FuncioanrioModel funcionario) {
        fRepo.save(funcionario);
    }
}
