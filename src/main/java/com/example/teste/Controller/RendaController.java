package com.example.teste.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.Model.EnderecoModel;
import com.example.teste.Model.RendaInvestimentoModel;
import com.example.teste.Repository.RendaInvestimentoRepository;

@RestController
@RequestMapping("apiRenda")
@CrossOrigin(origins = "http://localhost:8080")
public class RendaController {
    

    @Autowired
    private RendaInvestimentoRepository repository;


    @GetMapping("/todos")
     public List<RendaInvestimentoModel> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/buscarPorClienteId/{clienteId}")
     public ResponseEntity<?> buscarEnderecoPorClienteId(@PathVariable Long clienteId) {
        Optional<RendaInvestimentoModel> enderecoOpt = repository.findByClienteId(clienteId);
        if (enderecoOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Endereço não encontrado para o cliente id: " + clienteId);
        }

        return ResponseEntity.ok(enderecoOpt.get());
    }

   @PatchMapping
public ResponseEntity<RendaInvestimentoModel> atualizarRenda(@RequestBody RendaInvestimentoModel renda) {
    if (renda.getCliente() == null || renda.getCliente().getId() == null) {
        return ResponseEntity.badRequest().build();
    }

    Optional<RendaInvestimentoModel> existenteOpt = repository.findByClienteId(renda.getCliente().getId());
    if (existenteOpt.isEmpty()) {
        return ResponseEntity.notFound().build();
    }

    RendaInvestimentoModel existente = existenteOpt.get();

    // Atualiza apenas os campos que vieram preenchidos
    if (renda.getRendaMensal() != null) {
        existente.setRendaMensal(renda.getRendaMensal());
    }
    if (renda.getPessoasDependentes() != null) {
        existente.setPessoasDependentes(renda.getPessoasDependentes());
    }
    if (renda.getRendaTotalresidencial() != null) {
        existente.setRendaTotalresidencial(renda.getRendaTotalresidencial());
    }

    RendaInvestimentoModel atualizado = repository.save(existente);
    return ResponseEntity.ok(atualizado);
}
}
