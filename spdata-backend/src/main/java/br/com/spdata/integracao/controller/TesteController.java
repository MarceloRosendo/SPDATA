package br.com.spdata.integracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController(value = "")
public class TesteController
{
	
	@GetMapping(name = "/teste")
	public String name()
	{
		return "teste";
	}
}
