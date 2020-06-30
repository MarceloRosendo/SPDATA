package br.com.spdata.integracao.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spdata.integracao.entity.Assunto;
import br.com.spdata.integracao.model.AssuntoModel;
import br.com.spdata.integracao.repository.AssuntoRepository;


@Service
public class CadastroAssunto {
	
	@Autowired
	AssuntoRepository assuntoRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public String salvar(AssuntoModel assunto){
		
		Assunto assuntoN = modelMapper.map(assunto, Assunto.class);
		Assunto assuntoF = assuntoRepository.save(assuntoN);
		
		return "Assunto " + String.valueOf(assuntoF.getDescricao()) + " - " +  String.valueOf(assuntoF.getId()) + " registrado com sucesso";
		
		
	}

}
