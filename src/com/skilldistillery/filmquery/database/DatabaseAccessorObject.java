package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				/*
				 * private int id; private String title; private String description; private int
				 * release_year; private String languageName; private int rental_duration;
				 * private double rental_rate; private int length; private double
				 * replacement_cost; private String rating; private String special_features;
				 * private String category; private List<Actor> actors;
				 */
				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setRelease_year(filmResult.getInt("release_year"));
				//film.setLanguage(filmResult.getString("language"));
				film.setRental_duration(filmResult.getInt("rental_duration"));
				film.setRental_rate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacement_cost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecial_features(filmResult.getString("special_features"));
				// film.setCategory(filmResult.getString("category"));
			}
			conn.close();
			filmResult.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> findFilmBySearchKeyword(String keyword) {
		List<Film> filmList = new ArrayList<>();
		Film film = null;
		String sql = "SELECT film.id, language.name, film.language_id, title, description, " 
		+ "release_year, rental_duration, rental_rate, length, replacement_cost, rating, special_features "
		+ "FROM film " 
		+ "JOIN language ON language.id = film.language_id "
		+ "WHERE title LIKE ? OR description LIKE ?";
	
	try {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		keyword = "%" + keyword + "%";
		stmt.setString(1, keyword);
		stmt.setString(2, keyword);
		ResultSet filmResult = stmt.executeQuery();
		while (filmResult.next()) {
			film = new Film();
			film.setId(filmResult.getInt("film.id"));
			film.setTitle(filmResult.getString("film.title"));
			film.setLanguage(filmResult.getString("language.name"));
			film.setDescription(filmResult.getString("description"));
			film.setRelease_year(filmResult.getInt("film.id"));
			film.setRental_duration(filmResult.getInt("rental_duration"));
			film.setRental_rate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacement_cost(filmResult.getDouble("replacement_cost"));
			film.setSpecial_features(filmResult.getString("special_features"));
			film.setActors(findActorsByFilmId(film.getId()));
			
			filmList.add(film);
		}
		conn.close();
		stmt.close();
		filmResult.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return filmList;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
