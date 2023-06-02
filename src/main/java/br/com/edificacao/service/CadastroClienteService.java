package br.com.edificacao.service;

import br.com.edificacao.controller.model.ClienteRequest;
import br.com.edificacao.repository.ClienteRepository;
import br.com.edificacao.repository.EnderecoRepository;
import br.com.edificacao.repository.entity.ClienteEntity;
import br.com.edificacao.repository.entity.EnderecoEntity;
import br.com.edificacao.service.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CadastroClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;


    public void cadastrar(ClienteRequest cliente) {
        String tipoPessoa = cliente.getNumeroDocumento().length() == Constants.TAMANHO_DOC_CPF ? Constants.PESSOA_FISICA : Constants.PESSOA_JURIDICA;
        String clientId = UUID.randomUUID().toString();
        String enderecoId = UUID.randomUUID().toString();
        ClienteEntity clienteEntity = ClienteEntity.builder()
                .codigoCliente(clientId)
                .nomeCompleto(cliente.getNomeCompleto())
                .numeroDocumento(cliente.getNumeroDocumento())
                .tipoPessoa(tipoPessoa)
                .nomeFantasia(cliente.getNomeFantasia())
                .dataNascimento(cliente.getDataNascimento())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .build();

        EnderecoEntity enderecoEntity = EnderecoEntity.builder()
                .codigoCliente(clientId)
                .codigoEndereco(enderecoId)
                .cep(cliente.getEndereco().getCep())
                .estado(cliente.getEndereco().getEstado())
                .cidade(cliente.getEndereco().getCidade())
                .bairro(cliente.getEndereco().getBairro())
                .logradouro(cliente.getEndereco().getLogradouro())
                .numero(cliente.getEndereco().getNumero())
                .complemento(cliente.getEndereco().getComplemento())
                .build();

        clienteRepository.save(clienteEntity);
        enderecoRepository.save(enderecoEntity);

    }
}
