package br.com.Chamado.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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


	public Tecnico create(TecnicoDto dto) {
		dto.setId(null);
		Tecnico tecnico = new Tecnico(dto);
		return repository.save(tecnico);
	}


	public Tecnico update(Long id, @Valid TecnicoDto dto) {
		Optional<Tecnico> obj = repository.findById(id);
		Tecnico tec = new Tecnico(dto);
		if(obj.isEmpty()) {
			throw new NullPointerException("Dados não localizado para alteração");
		}
		tec.setId(id);
		return repository.save(tec);
	}


	public void delete(Long id) {
		Tecnico obj = findById(id);
		
		if(obj.getChamados().size() > 0) {
			System.out.println("Verdadeiro::::" + obj.getChamados());
			throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
		}else {			
			repository.deleteById(id);
		}
	}
}
