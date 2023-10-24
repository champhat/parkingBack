package com.formation.parking.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.formation.parking.dao.ParkingApiDAO;
import com.formation.parking.dao.entity.ResponseParkingApiEntity;

// @repository pour la couche DAO
/* @repository permet de dire que cette classe est un composant spring instanciable et injectable via autowired. 
 * il va essayer de trouver une impléentation de l'interface
 * 
 * */
@Repository
public class ParkingDaoImpl implements ParkingApiDAO {

	private static final String URL_API_OPEN_DATA = "https://data.nantesmetropole.fr/api/records/1.0/search/?dataset=244400404_parkings-publics-nantes-disponibilites&q=&facet=grp_nom&facet=grp_statut";
	
	@Autowired
	private RestTemplate restTemplate; //bean qui a été crée dans ParkingApplication
	
	@Override
	public ResponseParkingApiEntity getListParkings() {
		// TODO Auto-generated method stub
		return restTemplate.getForEntity(URL_API_OPEN_DATA, ResponseParkingApiEntity.class).getBody();
	}

}
