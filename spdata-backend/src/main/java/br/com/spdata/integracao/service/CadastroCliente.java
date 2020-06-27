package br.com.spdata.integracao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spdata.integracao.entity.Contato;
import br.com.spdata.integracao.repository.ContatoRepository;
import br.com.spdata.integracao.representationmodel.ContatoRepresentationModel;

@Service
public class CadastroCliente {

	@Autowired
	ContatoRepository contatoRepository;
	
	public String salvar(ContatoRepresentationModel contato) {
				
		Contato cont = new Contato();
		
		cont.setId(contato.getId());
		cont.setNome(contato.getNome());
		cont.setEmail(contato.getEmail());
		cont.setTelefone(contato.getTelefone());
		cont.setNomeEmpresa(contato.getNomeEmpresa());
		cont.setCargo(contato.getCargo());
		cont.setEndereco(contato.getEndereco());
		cont.setEstado(contato.getEstado());
		cont.setDatahora(contato.getDatahora());
		cont.setMensagem(contato.getMensagem());
		
		Contato crm = contatoRepository.save(cont);

		return "O código do cliente cadastrado é : " + String.valueOf(crm.getId()) ;
		
	}
	
}
