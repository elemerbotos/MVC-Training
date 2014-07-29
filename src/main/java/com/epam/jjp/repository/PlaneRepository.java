package com.epam.jjp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.jjp.domain.Plane;

@Repository
public class PlaneRepository {
	private final List<Plane> planes = new ArrayList<>();
	
	
	{
		Plane plane1 = new Plane();
		plane1.setId(0);
		plane1.setName("Plane1");
		plane1.setFuel(1000);
		
		Plane plane2 = new Plane();
		plane2.setId(1);
		plane2.setName("Plane2");	
		plane2.setFuel(2000);
		
		planes.add(plane1);
		planes.add(plane2);

	}


	public List<Plane> getPlanes() {
		return planes;
	}


	public int getPlaneNumber() {
		return planes.size();
	}
	
	public void addPlane(Plane plane) {
		planes.add(plane);
	}
}
