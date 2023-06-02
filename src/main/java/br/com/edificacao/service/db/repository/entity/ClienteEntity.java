package br.com.edificacao.service.db.repository.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name = "TB_CLIENTE")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteEntity {
    @Id
    @Column(name = "cliente_id")
    private String codigoCliente;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "tipo_pessoa")
    private String tipoPessoa;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;
}
