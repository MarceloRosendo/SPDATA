package br.com.spdata.integracao.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.spdata.integracao.entity.Assunto;
import br.com.spdata.integracao.model.AssuntoModel;
import br.com.spdata.integracao.repository.AssuntoRepository;
import br.com.spdata.integracao.service.CadastroAssunto;

@RequestMapping ("/assunto")
public class AssuntoController {
	
	@Autowired
	AssuntoRepository assuntoRepository;
	
	@Autowired
	CadastroAssunto cadastroAssunto;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/listarTodos")
	public List<AssuntoModel>listarTodosAssuntos(){
		
		List<Assunto>listaAssuntos = assuntoRepository.findAll();
		List<AssuntoModel>listaAssuntosModel = new ArrayList<AssuntoModel>();
		
		for(int i = 0; i< listaAssuntos.size(); i++) {
			
			AssuntoModel assunto = modelMapper.map(listaAssuntos.get(i), AssuntoModel.class);					
			listaAssuntosModel.add(assunto);
			
			}	
			return listaAssuntosModel;
			
		}
	
	@PostMapping("/criarAssunto")
	@ResponseStatus(HttpStatus.CREATED)
	public String criarAssunto(@Valid @RequestBody AssuntoModel assunto){	
		
		return cadastroAssunto.salvar(assunto);		

	}
}
