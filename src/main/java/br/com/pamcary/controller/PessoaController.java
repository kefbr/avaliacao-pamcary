package br.com.pamcary.controller;

import br.com.pamcary.model.Pessoa;
import br.com.pamcary.payload.PessoaRequest;
import br.com.pamcary.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public Pessoa criarPessoa(@Valid @RequestBody PessoaRequest pessoa){
        return pessoaService.criarPessoa(pessoa);
    }
    @GetMapping
    public List<Pessoa> listarPessoas(){
        return pessoaService.listarPessoas();
    }
    @GetMapping("/{id}")
    public Pessoa pessoa(@PathVariable("id") Long pessoaId){
        return pessoaService.getPessoa(pessoaId);
    }
    @GetMapping("/cpf/{cpf}")
    public Pessoa cpf(@PathVariable("cpf") String cpf){
        return pessoaService.getPessoaByCpf(cpf);
    }
    @PutMapping("/{id}")
    public Pessoa atualizarPessoa(@RequestBody PessoaRequest pessoa,
                                  @PathVariable("id") Long pessoaId){
        return pessoaService.atualziarPessoa(pessoa,pessoaId);
    }

    @DeleteMapping("/{id}")
    public String deletarPessoa(@PathVariable("id") Long pessoaId){
        return pessoaService.deletarPessoa(pessoaId);
    }
}
