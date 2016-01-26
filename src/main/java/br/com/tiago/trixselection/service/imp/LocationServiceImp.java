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
		locationDao.save(location);
	}

	@Override
	public void update(Location location) throws Exception {
		locationDao.update(location);
	}

	@Override
	public void delete(Location location) throws Exception {
		locationDao.delete(location);
	}

	@Override
	public void setTagById(Tag tag, int locationId) throws Exception {
		Location location = getLocationById(locationId);

		location.setTag(tag);

		update(location);
	}
}
