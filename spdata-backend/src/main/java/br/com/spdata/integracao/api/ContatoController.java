package br.com.spdata.integracao.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spdata.integracao.entity.Contato;
import br.com.spdata.integracao.repository.ContatoRepository;
import br.com.spdata.integracao.representationmodel.ContatoRepresentationModel;


@RestController
@RequestMapping("/contato")
public class ContatoController {
	
	@Autowired
	ContatoRepository contatoRepository;
	
	@GetMapping("/listarTodos")
	public List<ContatoRepresentationModel>listarTodosContatos(){
		
		List<Contato> listaContatos = contatoRepository.findAll();
		List<ContatoRepresentationModel>listaContatosRm = new ArrayList<ContatoRepresentationModel>();
		
		for(int i = 0; i< listaContatos.size(); i++) {
			
			ContatoRepresentationModel crm = new ContatoRepresentationModel();
			
			crm.setId(listaContatos.get(i).getId());
			crm.setNome(listaContatos.get(i).getNome());
			crm.setEmail(listaContatos.get(i).getEmail());
			crm.setTelefone(listaContatos.get(i).getTelefone());
			crm.setNomeEmpresa(listaContatos.get(i).getNomeEmpresa());
			crm.setCargo(listaContatos.get(i).getCargo());
			crm.setEndereco(listaContatos.get(i).getEndereco());
			crm.setEstado(listaContatos.get(i).getEstado());
			crm.setDatahora(listaContatos.get(i).getDatahora());
			crm.setMensagem(listaContatos.get(i).getMensagem());
			
			listaContatosRm.add(crm);
			
		}
				
		return listaContatosRm;		
	}

}
