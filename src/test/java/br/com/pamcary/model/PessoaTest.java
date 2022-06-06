package br.com.pamcary.model;

import br.com.pamcary.payload.PessoaRequest;
import org.junit.Test;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;

public class PessoaTest {
    @Test
    public void deveCriarPessoa(){
        Pessoa pessoa = Pessoa.builder()
                .codigo(1L)
                .nome("Silvio Toledo")
                .cpf("12345678910")
                .dataNascimento(LocalDateTime.now())
                .build();
        assertThat(pessoa.getCodigo()).isEqualTo(1L);
        assertThat(pessoa.getNome()).isEqualTo("Silvio Toledo");
        assertThat(pessoa.getCpf()).isEqualTo("12345678910");
        assertThat(pessoa.getDataNascimento()).usingComparator(withinMinute).isEqualTo(LocalDateTime.now());
    }
    @Test
    public void deveCriarPessoaPorPessoaRequest(){
        Pessoa pessoa = new Pessoa(new PessoaRequest("Silvio Toledo","12345678910",LocalDateTime.now()));
        assertThat(pessoa.getCodigo()).isNull();
        assertThat(pessoa.getNome()).isEqualTo("Silvio Toledo");
        assertThat(pessoa.getCpf()).isEqualTo("12345678910");
        assertThat(pessoa.getDataNascimento()).usingComparator(withinMinute).isEqualTo(LocalDateTime.now());
    }
    private final Comparator<LocalDateTime> withinMinute = (o1, o2) -> {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null || o2 == null) {
            return -1;
        }
        if (abs(Duration.between(o1, o2).toMinutes()) <= 1) {
            return 0;
        }
        return o1.compareTo(o2);
    };
}
