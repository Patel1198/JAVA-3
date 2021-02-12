package ca.sheridancollege.pate2516.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.pate2516.beans.Team;



@Repository
public class DatabaseAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertTeam(String teamName,String continent,int played,int won,int drawn,int lost) {
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		namedParameters.addValue("teamName", teamName);
		namedParameters.addValue("continent",continent);
		namedParameters.addValue("played", played);
		namedParameters.addValue("won", won);
		namedParameters.addValue("drawn", drawn);
		namedParameters.addValue("lost", lost);
		String query="INSERT INTO teams(teamName,continent,played,won,drawn,lost) VALUES"
				+ " (:teamName,:continent,:played,:won,:drawn,:lost)";
		int rowsAffected= jdbc.update(query, namedParameters);
		if (rowsAffected> 0) 
			System.out.println("Team is successfully inserted into database.");
	}
	
	 public void deleteTeamById(Long teamId) {
			

			MapSqlParameterSource namedParameters= new MapSqlParameterSource();
			namedParameters.addValue("teamId", teamId);
			String query="DELETE FROM teams WHERE teamId=:teamId";
			int rowsAffected= jdbc.update(query, namedParameters);
			if (rowsAffected> 0) 
				System.out.println("Team is successfully deleted from the database.");
			}

	 public void updateTeam(Team team) {
			
			MapSqlParameterSource namedParameters= new MapSqlParameterSource();
			namedParameters.addValue("teamId", team.getTeamId());
			namedParameters.addValue("teamName", team.getTeamName());
			namedParameters.addValue("continent", team.getContinent());
			namedParameters.addValue("played", team.getPlayed());
			namedParameters.addValue("won", team.getWon());
			namedParameters.addValue("drawn", team.getDrawn());
			namedParameters.addValue("lost", team.getLost());
			String query="UPDATE teams SET teamName =:teamName," + 
					"continent=:continent,played=:played,won=:won,drawn=:drawn,lost=:lost where teamId=:teamId";
			int rowsAffected= jdbc.update(query, namedParameters);
			if (rowsAffected> 0) 
				System.out.println("Team info got updated on the database.");
			}
	
	public List<Team> getTeamList() {
		MapSqlParameterSource namedParameters= new  MapSqlParameterSource();
		String query = "SELECT * FROM teams";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Team>(Team.class));
		}
	
	public List<Team> sortName(){
		MapSqlParameterSource namedParameters= new  MapSqlParameterSource();
		String query = "SELECT * FROM teams ORDER BY teamName";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Team>(Team.class));
	}
	
	public List<Team> sortContinent(){
		MapSqlParameterSource namedParameters= new  MapSqlParameterSource();
		String query = "SELECT * FROM teams ORDER BY continent";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Team>(Team.class));
	}
	
	
	
	public List<Team> getTeamById(Long teamId) {
	  	MapSqlParameterSource namedParameters= new  MapSqlParameterSource();
	  	namedParameters.addValue("teamId", teamId);
	  	String query = "SELECT * FROM teams WHERE teamId = :teamId";
	  	return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Team>(Team.class));

	}


}
