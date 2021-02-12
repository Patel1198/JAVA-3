package ca.sheridancollege.pate2516.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.pate2516.beans.Dice;



@Repository 
public class DatabaseAccess {
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	
public void insertDice(Dice dice ) {
			
		String sql="INSERT INTO dice(numberOfDices,numberOfSides,diceTotal) VALUES(:numberOfDices,:numberOfSides,:diceTotal)";
		namedParameters.addValue("numberOfDices", dice.getNumberOfDices());
		namedParameters.addValue("numberOfSides", dice.getNumberOfSides());
		namedParameters.addValue("diceTotal", dice.getDiceTotal());
		
		jdbc.update(sql, namedParameters);
	}
	
      public  List<Dice> DiceList() {
		
		String sql="SELECT * FROM dice";
		
		return jdbc.query(sql, new BeanPropertyRowMapper<Dice>(Dice.class));
	}
	
      public  void diceDelete() {
    		
    		String sql="DELETE FROM dice";
    		
    		jdbc.update(sql, namedParameters);
    		int rowsAffected= jdbc.update(sql, namedParameters);
  		if (rowsAffected> 0) 
  			System.out.println("Dice is successfully deleted from the database.");
  		}
      
  	
}