package br.com.pamcary.service;

import br.com.pamcary.model.Pessoa;
import br.com.pamcary.payload.PessoaRequest;
import br.com.pamcary.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;

//    public PessoaService(PessoaRepository pessoaRepository) {
//        this.pessoaRepository = pessoaRepository;
//    }

    public Pessoa criarPessoa(PessoaRequest pessoaRequest) {
        Pessoa pessoa = new Pessoa(pessoaRequest);
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa getPessoa(Long pessoaId) {
        return pessoaRepository.findById(pessoaId)
                .orElseThrow(() ->new NoSuchElementException("Não foi encontrada a pessoa com o id " + pessoaId));
    }

    public Pessoa getPessoaByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf)
                .orElseThrow(() ->new NoSuchElementException("Não foi encontrada a pessoa com o cpf " + cpf));
    }

    public Pessoa atualziarPessoa(PessoaRequest pessoa, Long pessoaId){
        return pessoaRepository.findById(pessoaId).map(record ->{
            record.setCpf(pessoa.getCpf());
            record.setNome(pessoa.getNome());
            record.setDataNascimento(pessoa.getDataNascimento());
            return pessoaRepository.save(record);
        }).orElseThrow(() ->new NoSuchElementException("Não foi encontrada a pessoa com o id " + pessoaId));
    }

    public String deletarPessoa(Long pessoaId) {
        return pessoaRepository.findById(pessoaId).map(pessoa -> {
            pessoaRepository.deleteById(pessoaId);
            return "Deletado com sucesso.";
        }).orElseThrow(() ->new NoSuchElementException("Não foi encontrada a pessoa com o id " + pessoaId));
    }
}
