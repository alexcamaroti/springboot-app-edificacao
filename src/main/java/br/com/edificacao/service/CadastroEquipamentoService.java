package br.com.edificacao.service;

import br.com.edificacao.controller.model.EquipamentoRequest;
import br.com.edificacao.repository.EquipamentoRepository;
import br.com.edificacao.repository.entity.EquipamentoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CadastroEquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public void cadastrar(EquipamentoRequest equipamento) {
        String codigoEquipamento = UUID.randomUUID().toString();
        EquipamentoEntity entity = EquipamentoEntity.builder()
                .codigo(codigoEquipamento)
                .descricao(equipamento.getDescricao())
                .tipo(equipamento.getTipo())
                .unidadeFornecimento(equipamento.getUnidadeFornecimento())
                .qtdEstoque(equipamento.getQtdEstoque())
                .build();
        equipamentoRepository.save(entity);

    }
}
