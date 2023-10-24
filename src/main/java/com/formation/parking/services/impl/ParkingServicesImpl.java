package com.formation.parking.services.impl;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.parking.dao.ParkingApiDAO;
import com.formation.parking.dao.entity.RecordEntity;
import com.formation.parking.dao.entity.ResponseParkingApiEntity;
import com.formation.parking.models.Parking;
import com.formation.parking.services.ParkingServices;


/*@Service permet de dire que cette classe est un composant spring instanciable et injectable via autowired. 
 * il va essayer de trouver une impléentation de l'interface
 * 
 * */
@Service
public class ParkingServicesImpl implements ParkingServices {

	@Autowired
	public ParkingApiDAO parkingApiDao;

	@Override
	public List<Parking> getListParkings() {
		ResponseParkingApiEntity responseParkingApiEntity = parkingApiDao.getListParkings();
		return transformEntityToModel(responseParkingApiEntity);
	}

	private List<Parking> transformEntityToModel(ResponseParkingApiEntity response) {
		List<Parking> resultats = new ArrayList<Parking>();
		for (RecordEntity record : response.getRecords()) {
			Parking parking = new Parking();
			parking.setIdentifiant(Integer.parseInt(record.getFields().getIdObj()));
			parking.setNom(record.getFields().getGrpNom());
			parking.setStatut(getLibelleStatut(record));
			parking.setNbrePlaceTotal(record.getFields().getGrpExploitation());
			parking.setNbrePlaceDispo(record.getFields().getGrpDisponible());
			parking.setHeureMaj(getHeureMaj(record));
			resultats.add(parking);
		}
		return resultats;
	}

	private String getHeureMaj(RecordEntity record) {
		//on a un décallage de date avec la date récupéréé on traduit le format
		OffsetDateTime dateMaj=OffsetDateTime.parse(record.getFields().getGrpHorodatage());
		OffsetDateTime dateMajWithOffsetPlus2=dateMaj.withOffsetSameInstant(ZoneOffset.of("+02:00"));
		return dateMajWithOffsetPlus2.getHour()+"h"+dateMajWithOffsetPlus2.getMinute();
	}

	private String getLibelleStatut(RecordEntity record) {
		switch (record.getFields().getGrpStatut()) {
			case 1: {
				return "fermé";
			}
			case 2: {
				return "reservé abonnés";
			}
			case 5:{
				return "ouvert";
			}
		}
		return "données non disponibles";
	}



}
