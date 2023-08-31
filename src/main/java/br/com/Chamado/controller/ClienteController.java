package br.com.Chamado.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.Chamado.domain.Cliente;
import br.com.Chamado.dto.ClienteDto;
import br.com.Chamado.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(new ClienteDto(obj));
	}

	@GetMapping
	public ResponseEntity<List<ClienteDto>> findAll() {
		List<ClienteDto> list = service.findAll().stream().map(x -> new ClienteDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<ClienteDto> create(@Valid @RequestBody ClienteDto dto) {
		Cliente tecnico = service.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDto> update(@PathVariable Long id, @Valid @RequestBody ClienteDto dto) {
		Cliente tec = service.update(id, dto);
		return ResponseEntity.ok().body(new ClienteDto(tec));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
