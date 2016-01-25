package br.com.tiago.trixselection.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiago.trixselection.dao.LocationDao;
import br.com.tiago.trixselection.model.Location;
import br.com.tiago.trixselection.model.Tag;
import br.com.tiago.trixselection.service.LocationService;

@Service
public class LocationServiceImp implements LocationService {

	@Autowired
	LocationDao locationDao;

	@Override
	public List<Location> listAll() {
		return locationDao.findAll();
	}

	@Override
	public Location getLocationById(int id) {
		return locationDao.findById(id);
	}

	@Override
	public void create(Location location) throws Exception {
		try {
			locationDao.save(location);
		} catch (Exception e) {
			throw new Exception("Location's name already exists.");
		}
	}

	@Override
	public void update(Location location) throws Exception {
		locationDao.update(location);
	}

	@Override
	public void delete(Location location) throws Exception {
		if (location == null)
			throw new Exception("Location not found.");
		locationDao.delete(location);
	}

	@Override
	public void setTagById(Tag tag, int locationId) throws Exception {
		if (tag == null)
			throw new Exception("The Tag don't exists");

		Location location = getLocationById(locationId);

		if (location == null)
			throw new Exception("The Location not exists");

		location.setTag(tag);

		update(location);
	}
}
