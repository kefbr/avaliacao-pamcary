package br.com.pamcary.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Jacksonized
public class PessoaRequest {

    private String nome;
    private String cpf;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a")
    private LocalDateTime dataNascimento;
}
