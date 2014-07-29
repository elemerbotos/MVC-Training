package com.epam.jjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.jjp.domain.Plane;
import com.epam.jjp.repository.PlaneRepository;


@Service
public class PlaneService {
	
	@Autowired
	private PlaneRepository repo;
	

	public List<Plane> getPlanes() {
		
		return repo.getPlanes();
	}


	public int getPlaneCount() {
		return repo.getPlaneNumber();
	}


	public void addPlane(Plane plane) {
		repo.addPlane(plane);
		
	}

	public Plane getPlaneById(String planeName) {
		List<Plane> planes = getPlanes();
		long id = Integer.parseInt(planeName);
		for(int i = 0; i < planes.size() ; ++i) {
			Plane plane = planes.get(i);
			if(plane.getId() == id) {
				return plane;
			}
		}
		return null;
	}
}
