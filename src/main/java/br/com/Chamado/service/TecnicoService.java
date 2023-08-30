package br.com.Chamado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Chamado.domain.Tecnico;
import br.com.Chamado.dto.TecnicoDto;
import br.com.Chamado.repository.TecnicoRepository;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;

	
	public Tecnico findById(Long id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElse(null);
	}


	public List<Tecnico> findAll() {
		return repository.findAll();
	}
}
