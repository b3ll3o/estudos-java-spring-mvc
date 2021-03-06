package br.com.alura.mvc.mudi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.NovoPedidoDto;
import br.com.alura.mvc.mudi.models.Pedido;
import br.com.alura.mvc.mudi.repositories.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(NovoPedidoDto novoPedidoDto) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid NovoPedidoDto novoPedidoDto, BindingResult result) {
		
		if(result.hasErrors())
			return "pedido/formulario";
		
		Pedido pedido = novoPedidoDto.toPedido();
		
		pedidoRepository.save(pedido);
		
		return "pedido/formulario";
	}
}
