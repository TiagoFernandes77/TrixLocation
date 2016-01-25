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
	private LocationService locationService;

	@Autowired
	private TagService tagService;

	@RequestMapping("/location")
	private List<Location> getLocations() {
		return locationService.listAll();
	}

	@RequestMapping("/location/{locationId}")
	private Location getLocation(@PathVariable("locationId") Integer locationId) {
		return locationService.getLocationById(locationId);
	}

	@RequestMapping(value = "/location/new", method = RequestMethod.POST)
	private Location setLocation(@RequestBody Location location)
			throws Exception {
		locationService.create(location);
		return location;
	}

	@RequestMapping(value = "/location/{locationId}/delete", method = RequestMethod.DELETE)
	private Location deleteLocation(
			@PathVariable("locationId") Integer locationId) throws Exception {
		Location location = locationService.getLocationById(locationId);

		locationService.delete(location);

		return location;
	}

	@RequestMapping(value = "/location/update", method = RequestMethod.POST)
	private void updateLocation(@RequestBody Location location)
			throws Exception {
		locationService.update(location);
	}

	@RequestMapping(value = "/location/{locationId}/setTag", method = RequestMethod.POST)
	private void setTag(@PathVariable("locationId") Integer locationId,
			@RequestBody Tag tag) throws Exception {

		tagService.create(tag);

		tag = tagService.getTagByName(tag.getName());

		locationService.setTagById(tag, locationId);
	}

	@RequestMapping(value = "/location/{locationId}/setTag/{tagId}")
	private void setTagById(@PathVariable("locationId") Integer locationId,
			@PathVariable("tagId") Integer tagId) throws Exception {

		Tag tag = tagService.getTagById(tagId);

		locationService.setTagById(tag, locationId);
	}

	@RequestMapping("/tag")
	private List<Tag> getTag() {
		return tagService.listAll();
	}

	@RequestMapping("/tag/{tagId}")
	private Tag getTags(@PathVariable("tagId") Integer tagId) {
		return tagService.getTagById(tagId);
	}

	@RequestMapping(value = "/tag/new", method = RequestMethod.POST)
	private void setTag(@RequestBody Tag tag) throws Exception {
		tagService.create(tag);
	}

	@RequestMapping(value = "/tag/{tagId}/delete", method = RequestMethod.DELETE)
	private Tag deleteTag(@PathVariable("tagId") Integer tagId)
			throws Exception {
		Tag tag = tagService.getTagById(tagId);

		tagService.delete(tag);
		return tag;
	}

	@RequestMapping(value = "/tag/update", method = RequestMethod.POST)
	private void updateTag(@RequestBody Tag tag) throws Exception {
		tagService.update(tag);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	private String handleException(Exception e) {
		return "Error: " + e.getMessage();
	}
}
