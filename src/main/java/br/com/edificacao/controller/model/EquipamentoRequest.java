package br.com.edificacao.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipamentoRequest {

    private String descricao;
    private String tipo;
    private String unidadeFornecimento;
    private Long qtdEstoque;
}
