package br.com.tiago.trixselection.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiago.trixselection.dao.LocationDao;
import br.com.tiago.trixselection.dao.TagDao;
import br.com.tiago.trixselection.model.Tag;
import br.com.tiago.trixselection.service.TagService;

@Service
public class TagServiceImp implements TagService{
	
	@Autowired
	TagDao tagDao;
	
	@Autowired
	LocationDao locationDao;
	
	@Override
	public List<Tag> listAll() {
		return tagDao.findAll();
	}

	@Override
	public Tag getTagById(int id) {
		return tagDao.findById(id);
	}

	@Override
	public void create(Tag tag) {
		try {
			tagDao.save(tag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Tag tag) {
		try {
			tagDao.update(tag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Tag tag) throws Exception {
		tagDao.delete(tag);		
	}

	@Override
	public Tag getTagByName(String name) {
		return tagDao.getByName(name);
	}

}
