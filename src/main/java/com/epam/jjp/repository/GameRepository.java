package com.epam.jjp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.jjp.domain.Flight;
import com.epam.jjp.domain.Game;
import com.epam.jjp.domain.Plane;
import com.epam.jjp.domain.Route;

@Repository
public class GameRepository {
	private Game game;

	{
		game = new Game();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public void startGame() {
		new Thread(game).start();
	}

	public List<Flight> getFlights() {
		return game.getFlights();
	}

	public void addPlane(Plane plane) {
		game.addPlane(plane);
	}

	public void addRoute(Route route) {
		game.addRoute(route);
	}
}
