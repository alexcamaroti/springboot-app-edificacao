package br.com.edificacao.service;

import br.com.edificacao.controller.model.ClienteResponse;
import br.com.edificacao.controller.model.EnderecoModel;
import br.com.edificacao.repository.ClienteRepository;
import br.com.edificacao.repository.EnderecoRepository;
import br.com.edificacao.repository.entity.ClienteEntity;
import br.com.edificacao.repository.entity.EnderecoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<ClienteResponse> consultarPorTipoPessoa(String tipoPessoa) {
        List<ClienteResponse> listaClientes = new ArrayList<>();
//        Consulta todos os clientes por tipo Pessoa
        List<ClienteEntity> entityList = clienteRepository.findByTipoPessoa(tipoPessoa);
//        Coleta todos os códigos para pesquisar pelos enderecos
        List<String> codigosCliente = new ArrayList<>();
        for (ClienteEntity item: entityList) {
            codigosCliente.add(item.getCodigoCliente());
        }
//        Realiza a pesquisa de endereços pelos codigos de cliente
        List<EnderecoEntity> listaEnderecos = enderecoRepository.findByCodigoClienteIn(codigosCliente);


        for (ClienteEntity clienteEntity: entityList) {
            processarEndereco(listaClientes, listaEnderecos, clienteEntity);
        }

        return listaClientes;
    }

    private void processarEndereco(List<ClienteResponse> listaClientes, List<EnderecoEntity> listaEnderecos, ClienteEntity clienteEntity) {
        for(EnderecoEntity enderecoEntity: listaEnderecos){
            if(enderecoEncontrado(clienteEntity, enderecoEntity)){
                EnderecoModel enderecoEncontrado = EnderecoModel.builder()
                        .cep(enderecoEntity.getCep())
                        .bairro(enderecoEntity.getBairro())
                        .cidade(enderecoEntity.getCidade())
                        .complemento(enderecoEntity.getComplemento())
                        .estado(enderecoEntity.getEstado())
                        .logradouro(enderecoEntity.getLogradouro())
                        .numero(enderecoEntity.getNumero())
                        .build();

                adicionarCliente(listaClientes, clienteEntity, enderecoEncontrado);
            }
        }
    }

    private boolean enderecoEncontrado(ClienteEntity cliente, EnderecoEntity endereco) {
        return endereco.getCodigoCliente().equals(cliente.getCodigoCliente());
    }

    private void adicionarCliente(List<ClienteResponse> listaClientes, ClienteEntity clienteEntity, EnderecoModel endereco) {
        listaClientes.add(ClienteResponse.builder()
                .codigoCliente(clienteEntity.getCodigoCliente())
                .nomeCompleto(clienteEntity.getNomeCompleto())
                .numeroDocumento(clienteEntity.getNumeroDocumento())
                .tipoPessoa(clienteEntity.getTipoPessoa())
                .nomeFantasia(clienteEntity.getNomeFantasia())
                .dataNascimento(clienteEntity.getDataNascimento())
                .email(clienteEntity.getEmail())
                .telefone(clienteEntity.getTelefone())
                .endereco(endereco)
                .build());
    }
}
