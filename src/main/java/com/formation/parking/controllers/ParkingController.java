package com.formation.parking.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.parking.models.Parking;
import com.formation.parking.services.ParkingServices;

@RestController //montre à spring que cette classe est un composant instanciable et injectable
//dit aussi toutes les méthodes vont retourner une réponse sous forme de JSON
public class ParkingController {

	@Autowired
	/*
	 * injecte le bean de parking service via l'interface sans avoir à faire : 
	 * private ParkingServices parkingService = new ParkingServices parkingService = new ParkingServicesImpl() <----- le service qui implémente son interface
	 * évite de trop lier les classes entre elle.
	 */	
	
	private ParkingServices parkingService;
	
	/*
	 * @RequestMapping = mapping entre uri de notre serveur et la méthode java
	 */	
	@CrossOrigin("http://localhost:4200")// pour eviter les erreurs cross origin cors (un site web n'a pas le droit de charger d'autre donner venant d'autres serveurs ici 4200 et 8000
	// @CrossOrigin("https://parking-my-app.herokuapp.com/") pour le mode prod
	@RequestMapping(path = "/api/parkings", method = RequestMethod.GET)
	public List<Parking> getListParkings() {
		return parkingService.getListParkings();
	}

}
