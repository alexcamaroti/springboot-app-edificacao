package br.com.edificacao.controller;

import br.com.edificacao.controller.model.ClienteRequest;
import br.com.edificacao.controller.model.ClienteResponse;
import br.com.edificacao.service.CadastroClienteService;
import br.com.edificacao.service.ConsultaClienteService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private CadastroClienteService cadastroClienteService;
    @Autowired
    private ConsultaClienteService consultaClienteService;

    @PostMapping
    public void cadastrar(@RequestBody ClienteRequest cliente){
        cadastroClienteService.cadastrar(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> consultarClientesPorTipoPessoa(@RequestParam String tipoPessoa){
        if (StringUtils.isBlank(tipoPessoa)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(consultaClienteService.consultarPorTipoPessoa(tipoPessoa));
    }
}
