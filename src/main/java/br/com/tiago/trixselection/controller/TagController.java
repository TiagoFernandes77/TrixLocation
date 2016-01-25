package br.com.tiago.trixselection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.trixselection.model.Tag;
import br.com.tiago.trixselection.service.TagService;

@RestController
@RequestMapping(value="/tag")
public class TagController {
	
	@Autowired
	TagService tagService;
	
	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	private List<Tag> getTag() {
		return tagService.listAll();
	}

	@RequestMapping(value = "/tag/{tagId}", method = RequestMethod.GET)
	private Tag getTags(@PathVariable("tagId") Integer tagId) {
		return tagService.getTagById(tagId);
	}
	
	@RequestMapping(value = "/tag", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	private void setTag(@RequestBody Tag tag) throws Exception {
		tagService.create(tag);
	}

	@RequestMapping(value = "/tag/{tagId}", method = RequestMethod.DELETE)
	private void deleteTag(@PathVariable("tagId") Integer tagId)
			throws Exception {
		Tag tag = tagService.getTagById(tagId);

		tagService.delete(tag);
	}

	@RequestMapping(value = "/tag/{tagId}", method = RequestMethod.PUT)
	private void updateTag(@PathVariable("tagId") Integer tagId, @RequestBody Tag tag) throws Exception {
		tagService.update(tag);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	private String handleException(Exception e) {
		return "Error: " + e.getMessage();
	}
}
