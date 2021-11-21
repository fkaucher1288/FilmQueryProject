package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private final String user = "student";
	private final String pass = "student";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading mysql driver!");
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String sql = "SELECT * FROM film WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				film = new Film(); // Create the object
				// Here is our mapping of query columns to our object fields:
				film.setId(filmResult.getInt(1));
				// film.setFirstName(actorResult.getString(2));
				// film.setLastName(actorResult.getString(3));
			}
		filmResult.close();
		stmt.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		String user = "student";
		String pass = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?"; //change sql statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor(); // Create the object
				// Here is our mapping of query columns to our object fields:
				actor.setId(actorResult.getInt(2));
				// film.setFirstName(actorResult.getString(2));
				// film.setLastName(actorResult.getString(3));
			}
		actorResult.close();
		stmt.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		Actor actor = null;
		String user = "student";
		String pass = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?"; //change sql statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor(); // Create the object
				// Here is our mapping of query columns to our object fields:
				actor.setId(actorResult.getInt(3));
				// film.setFirstName(actorResult.getString(2));
				// film.setLastName(actorResult.getString(3));
			}
		actorResult.close();
		stmt.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
