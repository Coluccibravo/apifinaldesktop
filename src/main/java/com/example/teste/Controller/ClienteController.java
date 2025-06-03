package com.example.teste.Controller;

import com.example.teste.Model.ClienteModel;
import com.example.teste.Model.FuncioanrioModel;
import com.example.teste.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiCliente")
@CrossOrigin(origins = "http://localhost:8080")
public class ClienteController {

    @Autowired
    private ClienteRepository fRepo;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody ClienteModel cliente){
        fRepo.save(cliente);
    }

    @PostMapping("/cadastrarVarios")
    public ResponseEntity<?> cadastrar(@RequestBody List<ClienteModel> clientes) {
        for (ClienteModel cliente : clientes) {
            fRepo.save(cliente);
        }
        return ResponseEntity.ok("Clientes cadastrados com sucesso");
    }

    @GetMapping("/todos")
    public List<ClienteModel> buscaTodos(){
        return fRepo.findAll();
    }

    @GetMapping("/buscarsisdev2/{nome}/{cpf}")
    public Optional<ClienteModel> findByNomeAndCpf(@PathVariable String nome, @PathVariable String cpf) {
        return fRepo.findByNomeAndCpf(nome, cpf);
    }

    @GetMapping("/buscarcpf/{cpf}")
    public Optional<ClienteModel> findbyCpf(@PathVariable String cpf){
        return fRepo.findByCpf(cpf);
    }

    @PutMapping("/atualizar")
    public void atualizar(@RequestBody ClienteModel cliente) {
        fRepo.save(cliente);
    }
}
