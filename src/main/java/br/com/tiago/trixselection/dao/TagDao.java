package br.com.tiago.trixselection.dao;

import java.util.List;

import br.com.tiago.trixselection.model.Tag;

public class TagDao extends GenericDao<Tag, Integer> {
	
	@Override
	public void delete(Tag entity) throws Exception {
		List<Tag> tags = (List<Tag>) this.executeQuery("SELECT * FROM LocationTag WHERE tag_id= 0", entity.getId());
		
		if(tags.size() > 0)
			throw new Exception("The tag is associated with a location.");
		
		super.delete(entity);
	}

}
