package ca.sheridancollege.pate2516.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class VideoGame implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private String publisher;
	private String platform;
	private BigDecimal price;
	
	private final String[] platforms = {"Mobile","PC","Xbox","PlayStation","Nintendo"};

}
