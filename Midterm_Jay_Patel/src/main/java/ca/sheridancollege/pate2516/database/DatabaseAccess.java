package ca.sheridancollege.pate2516.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.pate2516.beans.Car;

@Repository
public class DatabaseAccess {

		@Autowired
		protected NamedParameterJdbcTemplate jdbc;
		
		public void insertCar() {
			MapSqlParameterSource namedParameters= new MapSqlParameterSource();
			String query="INSERT INTO cars(manufacturer) VALUES ('Honda')";
			int rowsAffected= jdbc.update(query, namedParameters);
			if (rowsAffected> 0) 
				System.out.println("A car is inserted successfully into database.");
			}
		public void insertCar(String manufacturer, String model, int year, String colour, double price) {
			

			MapSqlParameterSource namedParameters= new MapSqlParameterSource();
			namedParameters.addValue("manufacturer", manufacturer);
			String query="INSERT INTO cars(manufacturer, model, year, colour, price) VALUES (:manufacturer, :model, :year, :colour, :price)";
			int rowsAffected= jdbc.update(query, namedParameters);
			if (rowsAffected> 0) 
				System.out.println("A car is inserted successfully into database.");
			}
		
	   public void deleteCarById(int carId) {
			

			MapSqlParameterSource namedParameters= new MapSqlParameterSource();
			namedParameters.addValue("carID", carId);
			String query="DELETE FROM cars WHERE carId=:carId";
			int rowsAffected= jdbc.update(query, namedParameters);
			if (rowsAffected> 0) 
				System.out.println("Car deleted from the database.");
			}
		
	   public void updateCar(Car car) {
			

			MapSqlParameterSource namedParameters= new MapSqlParameterSource();
			namedParameters.addValue("carId",  car.getCarId());
			namedParameters.addValue("manufacturer", car.getManufacturer());
			namedParameters.addValue("model", car.getModel());
			namedParameters.addValue("year", car.getYear());
			namedParameters.addValue("colour", car.getColour());
			namedParameters.addValue("price", car.getPrice());
			String query="UPDATE cars SET manufacturer=:manufacturer, model=:model, year=:year, colour=:colour, price=:price WHERE carId=:carId";
			int rowsAffected= jdbc.update(query, namedParameters);
			if (rowsAffected> 0) 
				System.out.println("car info got updated on the database.");
			}
		public List<Car> getCars() {
		  	MapSqlParameterSource namedParameters= new  MapSqlParameterSource();
		  	String query = "SELECT * FROM cars";
		  	return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Car>(Car.class));

		}
		
		public List<Car> getCarById(int carId) {
		  	MapSqlParameterSource namedParameters= new  MapSqlParameterSource();
		  	
		  	namedParameters.addValue("carId", carId);
		  	String query = "SELECT * FROM  cars WHERE carId = :carId";
		  	return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Car>(Car.class));

		}





	
}
