package br.com.pamcary.model;

import br.com.pamcary.payload.PessoaRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "PESSO_FISICA")
@SequenceGenerator(name= "sequence_pessoa_fisica", sequenceName = "sequence_pessoa_fisica", allocationSize = 1)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_pessoa_fisica")
    private Long codigo;
    private String nome;
    private String cpf;
    private LocalDateTime dataNascimento;

    public Pessoa (PessoaRequest pessoaRequest){
        this.nome = pessoaRequest.getNome();
        this.cpf = pessoaRequest.getCpf();
        this.dataNascimento = pessoaRequest.getDataNascimento();
    }
}
