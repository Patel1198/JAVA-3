package ca.sheridancollege.pate2516.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Team {
	
	private Long teamId;
	private String teamName;
	private String continent;
	private int played;
	private int won;
	private int drawn;
	private int lost;
	private int pts;
	private final String[] continents = {"Europe", "S.America", "Africa", "Asia",
			"N.America", "Antarctica", "Australia"};
		
	
}
