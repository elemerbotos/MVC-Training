package com.epam.jjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.jjp.domain.Flight;
import com.epam.jjp.domain.Game;
import com.epam.jjp.domain.Plane;
import com.epam.jjp.domain.Route;
import com.epam.jjp.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repo;
	
	public Game getGame() {
		return repo.getGame();
	}

	public void setRepo(Game game) {
		this.repo.setGame(game);
	}
	
	public void gameStart() {
		repo.startGame();
	}
	
	public List<Flight> getFlights() {
		return repo.getFlights();
	}
	
	public void addPlane(Plane plane) {
		repo.addPlane(plane);
	}
	
	public void addRoute(Route route) {
		repo.addRoute(route);
	}
	
}
