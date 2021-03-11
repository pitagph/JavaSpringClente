package com.example.bancodados.views;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

	@GetMapping("/")
	public String index() {
		return "Tela Principal - RestFull By PhillipeSilva";
	}
	
}
