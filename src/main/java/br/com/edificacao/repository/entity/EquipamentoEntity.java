package br.com.edificacao.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_EQUIPAMENTO")
public class EquipamentoEntity {

    @Id
    @Column(name = "equipamento_id")
    private String codigo;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "unidade_fornecimento")
    private String unidadeFornecimento;
    @Column(name = "qtd_estoque")
    private Long qtdEstoque;
}
