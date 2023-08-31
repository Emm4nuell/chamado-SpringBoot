package br.com.Chamado.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.Chamado.domain.Cliente;
import br.com.Chamado.dto.ClienteDto;
import br.com.Chamado.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElse(null);
	}


	public List<Cliente> findAll() {
		return repository.findAll();
	}


	public Cliente create(ClienteDto dto) {
		dto.setId(null);
		Cliente obj = new Cliente(dto);
		return repository.save(obj);
	}


	public Cliente update(Long id, @Valid ClienteDto dto) {
		Optional<Cliente> opt = repository.findById(id);
		Cliente obj = new Cliente(dto);
		if(opt.isEmpty()) {
			throw new NullPointerException("Dados não localizado para alteração");
		}
		obj.setId(id);
		return repository.save(obj);
	}


	public void delete(Long id) {
		Cliente obj = findById(id);
		
		if(obj.getChamados().size() > 0) {
			System.out.println("Verdadeiro::::" + obj.getChamados());
			throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
		}else {			
			repository.deleteById(id);
		}
	}
}
