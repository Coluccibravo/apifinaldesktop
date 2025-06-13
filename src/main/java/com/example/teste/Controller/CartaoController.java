package com.example.teste.Controller;


import com.example.teste.Model.CartaoModel;
import com.example.teste.Model.ClienteModel;
import com.example.teste.Model.RendaInvestimentoModel;
import com.example.teste.Repository.CartaoRepository;
import com.example.teste.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiCartao")
@CrossOrigin(origins = "http://localhost:8080")
public class CartaoController {

    @Autowired
    private CartaoRepository crepo;

    @GetMapping("/todos")
    public List<CartaoModel> buscaTodos() {
        return crepo.findAll();
    }

    @GetMapping("/buscarPorClienteId/{clienteId}")
    public ResponseEntity<?> buscarCartoesPorClienteId(@PathVariable Long clienteId) {
        List<Optional<CartaoModel>> cartoes = crepo.findByClienteId(clienteId);

        if (cartoes == null || cartoes.isEmpty()) {
            return ResponseEntity.status(404).body("Nenhum cartão encontrado para o cliente com id: " + clienteId);
        }

        return ResponseEntity.ok(cartoes);
    }
}
