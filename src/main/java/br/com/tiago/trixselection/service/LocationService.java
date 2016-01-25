package br.com.tiago.trixselection.service;

import java.util.List;

import br.com.tiago.trixselection.model.Location;
import br.com.tiago.trixselection.model.Tag;

public interface LocationService {
	List<Location> listAll();

	Location getLocationById(int id);

	void create(Location location) throws Exception;

	void update(Location location) throws Exception;

	void delete(Location location) throws Exception;

	void setTagById(Tag tag, int locationId) throws Exception;
}
