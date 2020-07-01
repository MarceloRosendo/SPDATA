package br.com.spdata.integracao.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spdata.integracao.entity.Contato;
import br.com.spdata.integracao.model.ContatoModel;
import br.com.spdata.integracao.repository.ContatoRepository;

@Service
public class CadastroCliente {

	@Autowired
	ContatoRepository contatoRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public String salvar(ContatoModel contato) {
				
		Contato cont = modelMapper.map(contato, Contato.class);		
		contatoRepository.save(cont);

		return "O código do cliente cadastrado é : " + String.valueOf(cont.getId()) ;
		
	}
	
	
	public String deletar(ContatoModel contato) {
		
		Contato cont = modelMapper.map(contato, Contato.class);
		contatoRepository.delete(cont);
		
		return "O contato de Id número: "+String.valueOf(cont.getId())+" foi removido!";
	}
	
	
	public String atualizar(ContatoModel contato) {
		
		Contato cont = modelMapper.map(contato, Contato.class);		
		contatoRepository.save(cont);

		return "O código do cliente atualizado é : " + String.valueOf(cont.getId()) ;
		
	}
		
	
	
}
