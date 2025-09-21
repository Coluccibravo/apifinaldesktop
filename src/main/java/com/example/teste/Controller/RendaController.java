package com.example.teste.Controller;

import java.util.List;
import java.util.Optional;

import com.example.teste.Model.ClienteModel;
import com.example.teste.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private ClienteRepository repositoryc;


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

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<RendaInvestimentoModel> atualizarRendaInvestimento(
            @PathVariable Long id,
            @RequestBody RendaInvestimentoModel rendaInvestimentoUpdated) {

        // Buscar o RendaInvestimento pelo ID
        Optional<RendaInvestimentoModel> existingRendaInvestimentoOpt = repository.findById(id);

        if (!existingRendaInvestimentoOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 se não encontrar o recurso
        }

        RendaInvestimentoModel existingRendaInvestimento = existingRendaInvestimentoOpt.get();

        // Atualizando os campos do modelo
        existingRendaInvestimento.setRendaMensal(rendaInvestimentoUpdated.getRendaMensal());
        existingRendaInvestimento.setPessoasDependentes(rendaInvestimentoUpdated.getPessoasDependentes());
        existingRendaInvestimento.setRendaTotalresidencial(rendaInvestimentoUpdated.getRendaTotalresidencial());
        existingRendaInvestimento.setRendaTotalInvestimentos(rendaInvestimentoUpdated.getRendaTotalInvestimentos());
        existingRendaInvestimento.setSaldo(rendaInvestimentoUpdated.getSaldo());
        existingRendaInvestimento.setPerfildoinvestidor(rendaInvestimentoUpdated.getPerfildoinvestidor());
        existingRendaInvestimento.setPersentualRendaInvestimentos(rendaInvestimentoUpdated.getPersentualRendaInvestimentos());
        existingRendaInvestimento.setPlano(rendaInvestimentoUpdated.getPlano());
        existingRendaInvestimento.setAgencia(rendaInvestimentoUpdated.getAgencia());
        existingRendaInvestimento.setTipo(rendaInvestimentoUpdated.getTipo());
        existingRendaInvestimento.setFundoimobiliario(rendaInvestimentoUpdated.getFundoimobiliario());
        existingRendaInvestimento.setAcoes(rendaInvestimentoUpdated.getAcoes());
        existingRendaInvestimento.setCriptomoedas(rendaInvestimentoUpdated.getCriptomoedas());
        existingRendaInvestimento.setPoupanca(rendaInvestimentoUpdated.getPoupanca());

        // Verifica se o cliente foi alterado
        if (rendaInvestimentoUpdated.getCliente() != null &&
                !rendaInvestimentoUpdated.getCliente().getId().equals(existingRendaInvestimento.getCliente().getId())) {

            // Atualiza o cliente se o ID do cliente for alterado
            Long clienteId = rendaInvestimentoUpdated.getCliente().getId();
            Optional<ClienteModel> clienteOpt = repositoryc.findById(clienteId);

            if (!clienteOpt.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Cliente não encontrado
            }

            // Atualiza o cliente relacionado
            existingRendaInvestimento.setCliente(clienteOpt.get());
        }

        // Salvando a entidade atualizada no banco de dados
        RendaInvestimentoModel updatedRendaInvestimento = repository.save(existingRendaInvestimento);

        return ResponseEntity.ok(updatedRendaInvestimento); // Retorna 200 com o objeto atualizado
    }
}
