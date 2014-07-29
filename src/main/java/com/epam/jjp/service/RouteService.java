package com.epam.jjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.jjp.domain.Plane;
import com.epam.jjp.domain.Route;
import com.epam.jjp.repository.RouteRepository;

@Service
public class RouteService {
	
	@Autowired
	private RouteRepository repo;
	
	public void addRoute(Route route) {
		repo.addRoute(route);
	}
	
	public List<Route> getRoutes() {
		return repo.getRoutes();
	}

	public Route getRouteById(String routeId) {
		Route route = null;
		for(Route r: getRoutes()) {
			if(r.getId().equals(routeId)) {
				route = r;
			}
		}
		return route;
	}
	
}
