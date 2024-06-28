package br.edu.atitus.denguealerta.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.atitus.denguealerta.entities.FocoEntity;
import br.edu.atitus.denguealerta.entities.UsuarioEntity;
import br.edu.atitus.denguealerta.repositories.FocoRepository;
import br.edu.atitus.denguealerta.repositories.GenericRepository;

@Service
public class FocoService extends GenericService<FocoEntity>{
	
	private final FocoRepository focoRepository;
	

	public FocoService(FocoRepository focoRepository) {
		super();
		this.focoRepository = focoRepository;
	}
	
	@Override
	protected GenericRepository<FocoEntity> getRepository() {
		// TODO Auto-generated method stub
		return this.focoRepository;
	}

	@Override
	public void validate(FocoEntity objeto) throws Exception {
		var user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!(user instanceof UsuarioEntity))
			throw new Exception("É necessário estar logado.");
		
		UsuarioEntity usuarioLogado = (UsuarioEntity) user;
		if(objeto.getUsuario().getId().compareTo(
				usuarioLogado.getId()) != 0)
			throw new Exception("Usuário do Foco não coincide com o logado.");
		
		if (objeto.getLatitude() ==0 )
			throw new Exception("Latitude invalida!");
		if(objeto.getLongitude() == 0)
			throw new Exception("Longitude inválida!");
		
		if (objeto.getData() == null)
			throw new Exception("Data inválida!");
	
	
	}



}
