package com.andre.analisecredito;

import com.andre.analisecredito.domain.Proposta;
import com.andre.analisecredito.service.AnaliseCreditoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class AnalisecreditoApplication {

	private AnaliseCreditoService analiseCreditoService;
	public static void main(String[] args) {
		SpringApplication.run(AnalisecreditoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(Proposta proposta) {
		return args -> {
			analiseCreditoService.analisar(proposta);
		};
	}
}
