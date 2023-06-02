package br.com.edificacao.controller;

import br.com.edificacao.controller.model.ClienteRequest;
import br.com.edificacao.controller.model.ClienteResponse;
import br.com.edificacao.controller.model.EquipamentoRequest;
import br.com.edificacao.controller.model.EquipamentoResponse;
import br.com.edificacao.service.CadastroClienteService;
import br.com.edificacao.service.CadastroEquipamentoService;
import br.com.edificacao.service.ConsultaClienteService;
import br.com.edificacao.service.ConsultaEquipamentoService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("equipamentos")
public class EquipamentoController {

    @Autowired
    private CadastroEquipamentoService cadastroEquipamentoService;
    @Autowired
    private ConsultaEquipamentoService consultaEquipamentoService;

    @PostMapping
    public void cadastrar(@RequestBody EquipamentoRequest cliente){
        cadastroEquipamentoService.cadastrar(cliente);
    }

    @GetMapping
    public ResponseEntity<List<EquipamentoResponse>> consultarEquipamentos(){
        return ResponseEntity.ok(consultaEquipamentoService.consultar());
    }
}
