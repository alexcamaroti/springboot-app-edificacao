package br.com.edificacao.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteResponse {
    private String nomeCompleto;
    private String numeroDocumento;
    private String tipoPessoa;
    private String nomeFantasia;
    private String dataNascimento;
    private String email;
    private String telefone;
    private EnderecoModel endereco;
}
