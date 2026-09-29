package org.anudip.base;

import java.util.ArrayList;

public class MovieWatchList {
	public static void main(String[] args) {
		ArrayList<String> movies = new ArrayList<>();
		
		
		movies.add("Inception");
		movies.add("Interstealler");
		movies.add("3 idiots");
		movies.add("The Dark Knight");
		movies.add("Avengers");
		
		System.out.println("WatchList : ");
		System.out.println(movies);
		
		
		movies.set(4, "Avengers :EndGame");
		System.out.println("After Updating the movies");
		System.out.println(movies);
		
		
		movies.remove("Inception");
		System.out.println("After Removing Inception");
		System.out.println(movies);
		
		String searchMovie = "Interstealler";
		if(movies.contains(searchMovie))
		{
			System.out.println(searchMovie + " is in your list");
		}else
		{
			
			System.out.println(searchMovie + " is not in your list");
		}
		
		
		System.out.println("Total Movies : " + movies.size());
		
		System.out.println("Movies One by One ");
		for(String movie : movies)
		{
			System.out.println(movie);
		}
	}

}
