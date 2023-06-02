package br.com.edificacao.service;

import br.com.edificacao.controller.model.ClienteRequest;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {

    public void cadastrar(ClienteRequest cliente) {
        System.out.println("Cadastrou");
    }
}
