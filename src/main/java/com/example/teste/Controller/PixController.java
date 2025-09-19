package com.example.teste.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.teste.Model.PixModel;

import com.example.teste.Repository.PixRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("apiPix")
@CrossOrigin(origins = "http://localhost:8080")
public class PixController {

    @Autowired
    private PixRepository pixRepository;

    @GetMapping("/todos")
    public Iterable<PixModel> listarTodos() {
        return pixRepository.findAll();
    }
    
    @GetMapping("/buscarPorClienteId/{clienteId}")
    public Optional<PixModel> buscarPorClienteId(@PathVariable Long clienteId) {
        return pixRepository.findByClienteId(clienteId);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PixModel> atualizarPix(@PathVariable Long id, @RequestBody PixModel pix) {
        // Procura o PixModel pelo ID
        Optional<PixModel> existenteOpt = pixRepository.findById(id);

        // Se o PixModel não for encontrado, retorna um 404 Not Found
        if (existenteOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PixModel existente = existenteOpt.get();

        // Atualiza os campos que foram fornecidos no request body
        if (pix.getChave() != null) existente.setChave(pix.getChave());
        if (pix.getTipo() != null) existente.setTipo(pix.getTipo());
        if (pix.getCliente() != null) existente.setCliente(pix.getCliente());

        // Salva o PixModel atualizado
        PixModel atualizado = pixRepository.save(existente);

        // Retorna o PixModel atualizado com o status 200 OK
        return ResponseEntity.ok(atualizado);
    }




}
