package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private int release_year;
	private String language;
	private int rental_duration;
	private double rental_rate;
	private int length;
	private double replacement_cost;
	private String rating;
	private String special_features;
	private String category;
	private List<Actor> actors;
	
	public Film () {}
	
	
	public Film(int id, String title, String description, int release_year, int language_id, String language,
		int rental_duration, double rental_rate, int length, double replacement_cost) {
	super();
	this.id = id;
	this.title = title;
	this.description = description;
	this.release_year = release_year;
	this.language = language;
	this.rental_duration = rental_duration;
	this.rental_rate = rental_rate;
	this.length = length;
	this.replacement_cost = replacement_cost;
}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRelease_year() {
		return release_year;
	}
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getRental_duration() {
		return rental_duration;
	}
	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}
	public double getRental_rate() {
		return rental_rate;
	}
	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getReplacement_cost() {
		return replacement_cost;
	}
	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	
	


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getSpecial_features() {
		return special_features;
	}


	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public List<Actor> getActors() {
		return actors;
	}


	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}


	@Override
	public int hashCode() {
		return Objects.hash(actors, category, description, id, language, length, rating, release_year,
				rental_duration, rental_rate, replacement_cost, special_features, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(category, other.category)
				&& Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(language, other.language) && length == other.length
				&& Objects.equals(rating, other.rating) && release_year == other.release_year
				&& rental_duration == other.rental_duration
				&& Double.doubleToLongBits(rental_rate) == Double.doubleToLongBits(other.rental_rate)
				&& Double.doubleToLongBits(replacement_cost) == Double.doubleToLongBits(other.replacement_cost)
				&& Objects.equals(special_features, other.special_features) && Objects.equals(title, other.title);
	}


	@Override
	public String toString() {
		return "Film [title=" + title + ", release_year=" + release_year
				+ ", languageName=" + language + ", rating=" + rating
				+ ", actors=" + actors + "]";
	}


	
	
	
	
	
}
