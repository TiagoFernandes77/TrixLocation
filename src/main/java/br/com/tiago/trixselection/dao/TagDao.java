package br.com.tiago.trixselection.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.tiago.trixselection.model.Tag;

@Repository
public class TagDao extends GenericDao<Tag, Integer> {
	
	public Tag getByName(String name){
		List<Tag> tags = (List<Tag>) this.executeQuery("FROM Tag WHERE name= ?0 ", name);
		
		if(tags != null && tags.size() > 0)
			return tags.get(0);
		
		return null;
	}

}
