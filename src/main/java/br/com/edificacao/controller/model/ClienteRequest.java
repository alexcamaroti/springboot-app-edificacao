package br.com.edificacao.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    private String nomeCompleto;
    private String numeroDocumento;
    private String tipoPessoa;
    private String nomeFantasia;
    private String dataNascimento;
    private String email;
    private String telefone;

}
