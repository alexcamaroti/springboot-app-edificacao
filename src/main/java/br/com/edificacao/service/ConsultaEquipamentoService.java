package br.com.edificacao.service;

import br.com.edificacao.controller.model.EquipamentoResponse;
import br.com.edificacao.repository.EquipamentoRepository;
import br.com.edificacao.repository.entity.EquipamentoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaEquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    public List<EquipamentoResponse> consultar() {
        List<EquipamentoResponse> response = new ArrayList<>();
        List<EquipamentoEntity> equipamentosDB = repository.findAll();
        for (EquipamentoEntity item: equipamentosDB) {
            response.add(EquipamentoResponse.builder()
                            .codigo(item.getCodigo())
                            .descricao(item.getDescricao())
                            .tipo(item.getTipo())
                            .unidadeFornecimento(item.getUnidadeFornecimento())
                            .qtdEstoque(item.getQtdEstoque())
                    .build());
        }
        return response;
    }
}
