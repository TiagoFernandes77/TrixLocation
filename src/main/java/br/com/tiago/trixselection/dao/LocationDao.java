package br.com.tiago.trixselection.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.tiago.trixselection.model.Location;
import br.com.tiago.trixselection.model.Tag;

public class LocationDao extends GenericDao<Location, Integer> {
	
	public void save(Location location, Tag tag) throws Exception{
		List<Tag> tags = location.getTags();
		
		if(tags == null)
			tags = new ArrayList<Tag>();
		
		tags.add(tag);
		
		update(location);
	}
}
