package br.com.Chamado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Chamado.domain.Tecnico;
import br.com.Chamado.dto.TecnicoDto;
import br.com.Chamado.service.TecnicoService;

@RestController
@RequestMapping(value = "/tecnico")
public class TecnicoController {
	
	@Autowired
	private TecnicoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDto> findById(@PathVariable Long id){
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDto(obj));
	}

}
