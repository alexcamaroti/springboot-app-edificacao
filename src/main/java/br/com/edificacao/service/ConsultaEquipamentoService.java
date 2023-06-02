package br.com.edificacao.service;

import br.com.edificacao.controller.model.EquipamentoResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaEquipamentoService {
    public List<EquipamentoResponse> consultar() {
        return new ArrayList<>();
    }
}
