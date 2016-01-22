package br.com.tiago.trixselection.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.trixselection.dao.LocationDao;
import br.com.tiago.trixselection.model.Location;

@RestController
public class Controller {
	
	@RequestMapping("/location")
	public List<Location> getLocation(){
		LocationDao ld = new LocationDao();
		
		return ld.findAll();
		
	}
	
	@RequestMapping(value="/setLocation", method = RequestMethod.POST)
	public Location setLocation(@RequestBody Location location){
		LocationDao ld = new LocationDao();
		try {
			ld.save(location);
		} catch (Exception e) {
			location.setName(e.getMessage());
			e.printStackTrace();
		}
		return location;
	}
}
