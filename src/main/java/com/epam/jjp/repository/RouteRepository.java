package com.epam.jjp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.jjp.domain.Route;

@Repository
public class RouteRepository {
	List<Route> routes = new ArrayList<>();
	
	public void addRoute(Route route) {
		routes.add(route);
	}

	public List<Route> getRoutes() {
		return routes;
		
	}
}
