package br.com.tiago.trixselection.dao;

import org.springframework.stereotype.Repository;

import br.com.tiago.trixselection.model.Location;
import br.com.tiago.trixselection.model.Tag;

@Repository
public class LocationDao extends GenericDao<Location, Integer> {

	public void save(Location location, Tag tag) throws Exception {
		location.setTag(tag);
		update(location);
	}
}
