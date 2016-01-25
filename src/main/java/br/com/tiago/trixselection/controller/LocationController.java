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
@RequestMapping(value="/location")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private TagService tagService;

	@RequestMapping("/")
	private List<Location> getLocations() {
		return locationService.listAll();
	}

	@RequestMapping(value = "/{locationId}", method = RequestMethod.GET)
	private Location getLocation(@PathVariable("locationId") Integer locationId) {
		return locationService.getLocationById(locationId);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	private void setLocation(@RequestBody Location location)
			throws Exception {
		locationService.create(location);
	}

	@RequestMapping(value = "/{locationId}", method = RequestMethod.DELETE)
	private void deleteLocation(
			@PathVariable("locationId") Integer locationId) throws Exception {
		Location location = locationService.getLocationById(locationId);

		locationService.delete(location);
	}

	@RequestMapping(value = "/{locationId}", method = RequestMethod.PUT)
	private void updateLocation(@PathVariable("locationId") Integer locationId, @RequestBody Location location)
			throws Exception {
		locationService.update(location);
	}

	@RequestMapping(value = "/{locationId}/tag", method = RequestMethod.POST)
	private void setTag(@PathVariable("locationId") Integer locationId,
			@RequestBody Tag tag) throws Exception {

		tagService.create(tag);

		tag = tagService.getTagByName(tag.getName());

		locationService.setTagById(tag, locationId);
	}

	@RequestMapping(value = "/{locationId}/tag/{tagId}", method = RequestMethod.POST)
	private void setTagById(@PathVariable("locationId") Integer locationId,
			@PathVariable("tagId") Integer tagId) throws Exception {

		Tag tag = tagService.getTagById(tagId);

		locationService.setTagById(tag, locationId);
	}
}
