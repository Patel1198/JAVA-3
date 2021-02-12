package ca.sheridancollege.pate2516.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	private Long id;
	private String prefix;
	private String code;
	private String name;
	
}
