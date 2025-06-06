package com.example.teste.Controller;

import com.example.teste.Model.ClienteModel;
import com.example.teste.Model.EnderecoModel;
import com.example.teste.Repository.ClienteRepository;
import com.example.teste.Repository.EnderecoRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiEndereco")
@CrossOrigin(origins = "http://localhost:8080")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarEndereco(@RequestBody EnderecoModel endereco) {
        if (endereco.getCliente() == null || endereco.getCliente().getId() == null) {
            return ResponseEntity.badRequest().body("Cliente não informado ou ID do cliente ausente.");
        }

        // Verifica se o cliente existe no banco
        Long clienteId = endereco.getCliente().getId();
        ClienteModel cliente = clienteRepository.findById(clienteId).orElse(null);

        if (cliente == null) {
            return ResponseEntity.badRequest().body("Cliente com ID " + clienteId + " não encontrado.");
        }

        // Associa o cliente ao endereço e salva
        endereco.setCliente(cliente);
        enderecoRepository.save(endereco);

        return ResponseEntity.ok("Endereço cadastrado com sucesso.");
    }

    @GetMapping("/buscarPorClienteId/{clienteId}")
    public ResponseEntity<?> buscarEnderecoPorClienteId(@PathVariable Long clienteId) {
        Optional<EnderecoModel> enderecoOpt = enderecoRepository.findByClienteId(clienteId);

        if (enderecoOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Endereço não encontrado para o cliente id: " + clienteId);
        }

        return ResponseEntity.ok(enderecoOpt.get());
    }
}
