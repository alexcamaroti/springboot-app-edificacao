package br.com.edificacao.service;

import br.com.edificacao.controller.model.ClienteResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaClienteService {
    public List<ClienteResponse> consultarPorTipoPessoa(String tipoPessoa) {
        return new ArrayList<>();
    }
}
