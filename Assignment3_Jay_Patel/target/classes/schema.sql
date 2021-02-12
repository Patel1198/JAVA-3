CREATE TABLE contacts(
id INT NOT NULL primary key auto_increment,
name VARCHAR(50) NOT NULL,
phoneNumber long NOT NULL ,
address VARCHAR(50),
email  VARCHAR(75) NOT NULL,
role VARCHAR(30) NOT NULL,
userId INT NOT NULL auto_increment,
encryptedPassword VARCHAR(128) NOT NULL
);


CREATE table users(
userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
email  VARCHAR(75) NOT NULL UNIQUE,
role VARCHAR(30) NOT NULL,
encryptedPassword VARCHAR(128) NOT NULL

);





ALTER TABLE contacts
  ADD CONSTRAINT user_role_fk1 FOREIGN KEY (userId)
  REFERENCES users (userId);
 
  
  
  

