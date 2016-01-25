package br.com.tiago.trixselection.service;

import java.util.List;

import br.com.tiago.trixselection.model.Tag;

public interface TagService {
	List<Tag> listAll();

	Tag getTagById(int id);

	Tag getTagByName(String Name);

	void create(Tag tag) throws Exception;

	void update(Tag tag) throws Exception;

	void delete(Tag tag) throws Exception;
}
