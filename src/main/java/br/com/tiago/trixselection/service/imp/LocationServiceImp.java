package br.com.tiago.trixselection.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiago.trixselection.dao.LocationDao;
import br.com.tiago.trixselection.model.Location;
import br.com.tiago.trixselection.service.LocationService;

@Service
public class LocationServiceImp implements LocationService{
	
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
	public void create(Location location) {
		try {
			locationDao.save(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Location location) {
		try {
			locationDao.update(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Location location) {
		try {
			locationDao.delete(location);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
