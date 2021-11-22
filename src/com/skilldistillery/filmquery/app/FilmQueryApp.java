package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out
				.println("1. Look up a film by ID. \n2. Look up a film by search keyword. \n3. Exit the application.");
		int userInput = input.nextInt();
		switch (userInput) {
		case 1:
			System.out.println("What is the id if the film you would like to review?");
			int filmId = 0;
			filmId = input.nextInt();
			Film film = db.findFilmById(filmId);
			if (film == null) {
				System.out.println("No film matches that ID.");
			} else {
				System.out.println(film);
			}
			break;
		case 2:
			System.out.println("Please enter the keyword you would like to search by");
			String keyword = input.next();
			List<Film> filmByKeyword = db.findFilmBySearchKeyword(keyword);
			if (filmByKeyword == null || filmByKeyword.isEmpty()) {
				System.out.println("Film not found using the given keyword");
			} else {
				System.out.println(filmByKeyword);
			}
			break;
		case 3:
			System.out.println("Thank you for using The Film Query App. Goodbye!");
			break;
			}

	}

}
