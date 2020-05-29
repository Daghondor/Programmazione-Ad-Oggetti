package com.univpm.ProgettoOOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe che si occupa di gestire ed avviare tutti i componenti dell'applicazione.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
@SpringBootApplication
public class ProgettoOopApplication
{
	/**
	 * Metodo main che inizializza i componenti e fa partire l'applicazione SpringBoot.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		SpringApplication.run(ProgettoOopApplication.class, args);
	}
}
