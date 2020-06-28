package br.com.spdata.integracao.api;

import java.time.OffsetDateTime;
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
import org.springframework.web.bind.annotation.RestController;

import br.com.spdata.integracao.entity.Contato;
import br.com.spdata.integracao.model.ContatoModel;
import br.com.spdata.integracao.repository.ContatoRepository;
import br.com.spdata.integracao.service.CadastroCliente;


@RestController
@RequestMapping("/contato")
public class ContatoController {
	
	@Autowired
	ContatoRepository contatoRepository;
	
	@Autowired
	CadastroCliente cadastroCliente;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/listarTodos")
	public List<ContatoModel>listarTodosContatos(){
		
		List<Contato> listaContatos = contatoRepository.findAll();
		List<ContatoModel>listaContatosRm = new ArrayList<ContatoModel>();
		
		for(int i = 0; i< listaContatos.size(); i++) {
			
			ContatoModel crm = modelMapper.map(listaContatos.get(i), ContatoModel.class);					
			listaContatosRm.add(crm);
			
		}
				
		return listaContatosRm;		
	}
	
	
	@PostMapping("/criarContato")
	@ResponseStatus(HttpStatus.CREATED)
	public String criarContato(@Valid @RequestBody ContatoModel contato){	
		
	   contato.setDatahora(OffsetDateTime.now());
	   return cadastroCliente.salvar(contato);		
				
	}

}
