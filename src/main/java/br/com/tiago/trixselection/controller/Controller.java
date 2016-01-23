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

import br.com.tiago.trixselection.model.Location;
import br.com.tiago.trixselection.model.Tag;
import br.com.tiago.trixselection.service.LocationService;
import br.com.tiago.trixselection.service.TagService;

@RestController
public class Controller {

	@Autowired
	LocationService locationService;

	@Autowired
	TagService tagService;

	@RequestMapping("/location")
	public List<Location> getLocations() {
		return locationService.listAll();
	}
	
	@RequestMapping("/location/{locationId}")
	public Location getLocation(@PathVariable("locationId") Integer locationId) {
		return locationService.getLocationById(locationId);
	}
	
	@RequestMapping(value = "/location/new", method = RequestMethod.POST)
	public Location setLocation(@RequestBody Location location) {
		locationService.create(location);
		return location;
	}
	
	@RequestMapping(value = "/location/{locationId}/delete", method = RequestMethod.DELETE)
	public Location deleteLocation(@PathVariable("locationId") Integer locationId){
		Location location = locationService.getLocationById(locationId);
		
		locationService.delete(location);
		
		return location;
	}
	
	@RequestMapping(value = "/location/update", method = RequestMethod.POST)
	public void updateLocation(@RequestBody Location location){		
		locationService.update(location);
	}

	@RequestMapping(value = "/location/{locationId}/setTag", method = RequestMethod.POST)
	public Location setTag(@PathVariable("locationId") Integer locationId,
			@RequestBody Tag tag) {

		Location location = locationService.getLocationById(locationId);
		
		tagService.create(tag);
		
		tag = tagService.getTagByName(tag.getName());
		
		location.setTag(tag);

		locationService.update(location);

		return location;
	}
	
	@RequestMapping("/tag")
	public List<Tag> getTag() {
		return tagService.listAll();
	}
	
	@RequestMapping("/tag/{tagId}")
	public Tag getTags(@PathVariable("tagId") Integer tagId) {
		return tagService.getTagById(tagId);
	}
	
	@RequestMapping(value = "/tag/new", method = RequestMethod.POST)
	public Tag setTag(@RequestBody Tag tag) {
		tagService.create(tag);
		return tag;
	}
	
	@RequestMapping(value = "/tag/{tagId}/delete", method = RequestMethod.DELETE)
	public Tag deleteTag(@PathVariable("tagId") Integer tagId) throws Exception{
		Tag tag = tagService.getTagById(tagId);
		
		tagService.delete(tag);
		
		return tag;
	}
	
	@RequestMapping(value = "/tag/update", method = RequestMethod.POST)
	public void updateTag(@RequestBody Tag tag){		
		tagService.update(tag);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception e) {
	    return "Error: " + e.getMessage();
	}
}
