package br.com.Chamado.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Chamado.domain.Chamados;
import br.com.Chamado.dto.ChamadoDto;
import br.com.Chamado.repository.ChamadoRepository;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;
	
	public Chamados findById(Long id) {
		Optional<Chamados> opt = repository.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException(id, "Objeto não encontrado"));
	}

	public List<Chamados> findAll() {
		return repository.findAll();
	}
}
