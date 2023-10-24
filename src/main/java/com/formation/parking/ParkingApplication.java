package com.formation.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*@SpringBootApplication cette annotation regroupe 3 annotations:
 * @configuration : indique sue cette classe est une classe de configuration dans laquelle on déclare nos beans avec @bean
 * @enableAutoConfiguration: applique une config par défaut au démarrage de l'appli pour toutes les dépendances 
 * (spring mvc, port tomecat etc..) qui se font dans le fichier applications.properties, ici j'ai changer le port car une autre appli tourne sur 8080
 * @componentScan: indique a spring de scanner les packages et sous packages de la classe à la recherche de composant à instancier et à injecter (les imports en haut)
 * */

@SpringBootApplication
public class ParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}

	// nécessaire au @Autowired de ParkingDaoImpl
	// private RestTemplate restTemplate;
	//ici bean de configuration
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
