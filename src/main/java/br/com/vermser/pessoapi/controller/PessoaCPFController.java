package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.dto.pessoacpf.PessoaCPFDTO;
import br.com.vermser.pessoapi.service.PessoaCPFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pcfp")
public class PessoaCPFController {
    @Autowired
    private PessoaCPFService pessoaCPFService;

    @GetMapping
    public List<PessoaCPFDTO> getPeople(){
        return pessoaCPFService.list();
    }

    @GetMapping("/idpessoa/{idUser}")
    public PessoaCPFDTO getPeopleID(@PathVariable Integer idUser) throws Exception {
        return pessoaCPFService.getById(idUser);
    }

    @GetMapping("/cpf/{cpf}")
    public PessoaCPFDTO getPeopleCpf(@PathVariable String cpf) throws Exception {
        return pessoaCPFService.getByCpf(cpf);
    }

    @GetMapping("/delete/{idUser}")
    public void delete(@PathVariable Integer idUser) throws Exception {
        pessoaCPFService.delete(idUser);
    }

}
