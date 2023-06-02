package br.com.edificacao.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipamentoResponse {

    private String codigo;
    private String descricao;
    private String tipo;
    private String unidadeFornecimento;
    private Long qtdEstoque;
}
