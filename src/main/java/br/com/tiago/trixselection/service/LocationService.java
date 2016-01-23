package br.com.tiago.trixselection.service;

import java.util.List;

import br.com.tiago.trixselection.model.Location;

public interface LocationService {
	List<Location> listAll();
	Location getLocationById(int id);
	void create(Location location);
	void update(Location location);
	void delete(Location location);
}
