package com.example.teste.Controller;

import com.example.teste.Model.ClienteModel;
import com.example.teste.Model.EnderecoModel;
import com.example.teste.Repository.ClienteRepository;
import com.example.teste.Repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiCliente")
@CrossOrigin(origins = "http://localhost:8080")
public class ClienteController {

    @Autowired
    private ClienteRepository fRepo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody ClienteModel cliente) {
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
    public List<ClienteModel> buscaTodos() {
        return fRepo.findAll();
    }

    @GetMapping("/buscarsisdev2/{nome}/{cpf}")
    public Optional<ClienteModel> acharpornome(@PathVariable String nome, @PathVariable String cpf) {
        return fRepo.findByNomeAndCpf(nome.trim(), cpf.trim());
    }

    @GetMapping("/buscarporcpf/{cpf}")
    public Optional<ClienteModel> findByCpf(@PathVariable String cpf) {
        return fRepo.findByCpf(cpf);
    }

    @PatchMapping
public ResponseEntity<ClienteModel> atualizarCliente(@RequestBody ClienteModel cliente) {
    if (cliente.getId() == null) {
        return ResponseEntity.badRequest().build();
    }

    Optional<ClienteModel> existenteOpt = fRepo.findById(cliente.getId());
    if (existenteOpt.isEmpty()) {
        return ResponseEntity.notFound().build();
    }

    ClienteModel existente = existenteOpt.get();

    // Apenas atualiza campos que vieram no JSON (evita sobrescrever com null)
    if (cliente.getNome() != null) existente.setNome(cliente.getNome());
    if (cliente.getCpf() != null) existente.setCpf(cliente.getCpf());
    if (cliente.getRg() != null) existente.setRg(cliente.getRg());
    if (cliente.getEstadoCivil() != null) existente.setEstadoCivil(cliente.getEstadoCivil());
    if (cliente.getDatanascimento1() != null) existente.setDatanascimento1(cliente.getDatanascimento1());
    if (cliente.getSexo() != null) existente.setSexo(cliente.getSexo());
    if (cliente.getEmail() != null) existente.setEmail(cliente.getEmail());
    if (cliente.getTelefone() != null) existente.setTelefone(cliente.getTelefone());
    if (cliente.getCelular() != null) existente.setCelular(cliente.getCelular());

    ClienteModel atualizado = fRepo.save(existente);
    return ResponseEntity.ok(atualizado);
}
}

