package ca.sheridancollege.pate2516.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course implements Serializable{
	
	@NonNull	
	private Long id;
	private static final long serialVersionUID=1L; 
	private String prefix;
	
	private int code;
	
	private String name;

}
