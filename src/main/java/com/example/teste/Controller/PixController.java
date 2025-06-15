package com.example.teste.Controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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





}
