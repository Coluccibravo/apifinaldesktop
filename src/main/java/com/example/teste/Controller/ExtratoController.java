package com.example.teste.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.example.teste.Model.ClienteModel;
import com.example.teste.Model.ExtratoModel;
import com.example.teste.Repository.ClienteRepository;
import com.example.teste.Repository.ExtratoRepository;

@RestController
@RequestMapping("/apiExtrato")
public class ExtratoController {

    @Autowired
    private ExtratoRepository extratoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/todos")
    public List<ExtratoModel> buscaTodos() {
        return extratoRepository.findAll();
    }

    @PostMapping("/cadastrar")
    public ExtratoModel criarExtrato(@RequestBody Map<String, Object> json) {
        Double valor = Double.valueOf(json.get("valor").toString());
        String data = json.get("data").toString();
        Long idEnvio = Long.valueOf(json.get("idEnvio").toString());
        Long idRecebido = Long.valueOf(json.get("idRecebido").toString());

        ExtratoModel extrato = new ExtratoModel();
        extrato.setValor(valor);
        extrato.setData(data); // tipo String
        extrato.setClienteEnvio(clienteRepository.findById(idEnvio).orElseThrow());
        extrato.setClienteRecebido(clienteRepository.findById(idRecebido).orElseThrow());

        return extratoRepository.save(extrato);
    }

    @GetMapping("/clienteEnvio/{id}")
    public List<ExtratoModel> listarTransacoesPorCliente1(@PathVariable Long id) {
        return extratoRepository.findByClienteEnvioId(id);
    }

    @GetMapping("/clienteRecebido/{id}")
    public List<ExtratoModel> listarTransacoesPorCliente2(@PathVariable Long id) {
        return extratoRepository.findByClienteRecebidoId(id);
    }

    @GetMapping
    public List<ExtratoModel> listarExtratos() {
        return extratoRepository.findAll();
    }
}
