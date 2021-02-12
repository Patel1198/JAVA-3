package ca.sheridancollege.pate2516.beans;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private Long id;
	private String title;
	private String director;
	private String genre;
	
	private final String[] genres = {"Comedy","Action"," Drama", "Horror", "Fantasy","Sci-Fi"};
}
