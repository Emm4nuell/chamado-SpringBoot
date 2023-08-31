package br.com.Chamado.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Chamado.domain.Chamados;
import br.com.Chamado.dto.ChamadoDto;
import br.com.Chamado.service.ChamadoService;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoController {

	@Autowired
	private ChamadoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ChamadoDto> findById(@PathVariable Long id){
		
		Chamados obj = service.findById(id);	
		return ResponseEntity.status(HttpStatus.OK).body(new ChamadoDto(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ChamadoDto>> findAll(){
		List<ChamadoDto> list = service.findAll().stream().map(x -> new ChamadoDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
}
