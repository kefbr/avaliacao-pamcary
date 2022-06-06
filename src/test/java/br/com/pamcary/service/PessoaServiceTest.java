package br.com.pamcary.service;

import br.com.pamcary.model.Pessoa;
import br.com.pamcary.payload.PessoaRequest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.NoSuchElementException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PessoaServiceTest {
    @Autowired
    private PessoaService pessoaService;

    @Test
    @Rollback(value = false)
    public void deveTestar1CriacaoPessoa(){
        assertThat(pessoaService.criarPessoa(new PessoaRequest("Silvio Toledo","12345678910", LocalDateTime.now()))).isNotNull();
    }
    @Test
    public void deveTestar2ListarPessoas(){
        System.out.println(pessoaService.listarPessoas().toString());
        assertThat(pessoaService.listarPessoas()).isNotNull();
    }
    @Test
    public void deveTestar3PegarUmaPessoa(){
        assertThat(pessoaService.getPessoa(2L)).extracting(
                Pessoa::getNome,
                Pessoa::getCpf,
                Pessoa::getDataNascimento
        ).containsExactly(
                "Fernando Cardoso",
                "12354469875",
                LocalDateTime.of(2018,
                        Month.DECEMBER, 28, 2, 0, 21)
        );
    }

    @Test
    @Rollback(value = false)
    public void deveTestar4AtualizarPessoa(){
        assertThat(
                pessoaService.atualziarPessoa(new PessoaRequest("Silvio Reginaldo de Toledo","12345678910",LocalDateTime.of(1996,
                        Month.MARCH, 12, 2, 20, 0)),6L)).isNotNull();
        assertThat(pessoaService.getPessoaByCpf("12345678910")).extracting(
                Pessoa::getNome,
                Pessoa::getCpf,
                Pessoa::getDataNascimento
        ).containsExactly(
                "Silvio Reginaldo de Toledo",
                "12345678910",
                LocalDateTime.of(1996,
                        Month.MARCH, 12, 2, 20, 0)
        );
    }

    @Test
    public void deveTestar5PegarUmaPessoaPorCpf(){
        assertThat(pessoaService.getPessoaByCpf("12345678910")).extracting(
                Pessoa::getNome,
                Pessoa::getCpf,
                Pessoa::getDataNascimento
        ).containsExactly(
                "Silvio Reginaldo de Toledo",
                "12345678910",
                LocalDateTime.of(1996,
                        Month.MARCH, 12, 2, 20, 0)
        );
    }

    @Test
    @Rollback(value = false)
    public void deveTestar6DeletarPessoa(){
        assertThat(pessoaService.deletarPessoa(1L)).isEqualTo("Deletado com sucesso.");
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy( () -> pessoaService.getPessoa(1L)).withMessage("Não foi encontrada a pessoa com o id 1");
    }
}
