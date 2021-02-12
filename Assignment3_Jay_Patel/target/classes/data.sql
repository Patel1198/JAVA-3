INSERT INTO users (userId,email,role,encryptedPassword)
VALUES 
(1,'jaypatel@gmail.com','ROLE_USER','$2a$10$vkOkjEBB2jcS/NzXHqh/RuHBQzslFBgbSkVUPfmQKAQsy4dErcX.O'),
(2,'yadi@gmail.com','ROLE_ADMIN','$2a$10$DiHqArUf/rCDJzQsVoMhIO4yaGFirykG503c8DTQe9PZlRBEpQ/5O'),
(3,'meet@gmail.com','ROLE_ADMIN','$2a$10$BnnOf22mBBriIKqfFHj3segp9oV3OCIHPy7NRInC5CUw.VwIPGG7W'),
(4,'sarthak@gmail.com','ROLE_ADMIN','$2a$10$iHKuMcXhtwk/cAVwgKQhY.Ypw8nCNGA5LAKn3ObpmFl6apPLxwMrG'),
(5,'parthpatel@outlook.com','ROLE_GUEST','$2a$10$8.Og/AGdRJe7YN/r6Hzwne1dI5sT815xPGKi5rrOZHOzPiU/WaQJ2'),
(6,'garry@outlook.com','ROLE_GUEST','$2a$10$aGNI3Rc7I3YBQVH8qIciBuX9TJdl7fANNOMWIi7QNmQq0G1RYUWvq'),
(7,'guri@outlook.com','ROLE_GUEST','$2a$10$m/CCxpGVWLdt7aIhoZpTHOYuxFnWYa3pImUXfCnM7342nQToguX1e'),
(8,'rati@outlook.com','ROLE_GUEST','$2a$10$CLZFKO47oDDr2xQ9Q6V/EO5NtDaBLTtIIYMNA///KxxkD75mOWYn2'),
(9,'harshpatel@yahoo.com','ROLE_USER','$2a$10$NJ87INnYlaG4jQEI4A815uq8yyzWZs7L9gTMsZ0f7Df8J0aE84rPe'),
(10,'kush@yahoo.com','ROLE_USER','$2a$10$tBPiZY/dRmmxXnul6pVUNepLfD9QIrqwFUOwnDmXugAuxc1dRUhW2'),
(11,'mika@yahoo.com','ROLE_USER','$2a$10$Be9u/9RGjdKfpiW5bbT2f.rey9T0OgzofhQdmk1v0/gzhpaId37SK'),
(12,'darshan@yahoo.com','ROLE_USER','$2a$10$TCmteCp7.ppiivBNUVkof.e.1pwn8loLnMv2Vzr3PkZX3Rev5R1le');



INSERT INTO contacts(
id,name, phoneNumber, address, email,role,userId,encryptedPassword)
VALUES
(1,'Jay','6475400292','358 Mill Street South','jaypatel@gmail.com','ROLE_USER',1,'$2a$10$vkOkjEBB2jcS/NzXHqh/RuHBQzslFBgbSkVUPfmQKAQsy4dErcX.O'),
(2,'Yadwinder','6475400293','40 verity','yadi@gmail.com','ROLE_ADMIN',2,'$2a$10$DiHqArUf/rCDJzQsVoMhIO4yaGFirykG503c8DTQe9PZlRBEpQ/5O'),
(3,'Meet','6475400294','42 verity','meet@gmail.com','ROLE_ADMIN',3,'$2a$10$BnnOf22mBBriIKqfFHj3segp9oV3OCIHPy7NRInC5CUw.VwIPGG7W'),
(4,'Sarthak','6475400295','47 verity','sarthak@gmail.com','ROLE_ADMIN',4,'$2a$10$iHKuMcXhtwk/cAVwgKQhY.Ypw8nCNGA5LAKn3ObpmFl6apPLxwMrG'),
(5,'Parth','6474254211','152 Suryanarayan','parthpatel@outlook.com','ROLE_GUEST',5,'$2a$10$8.Og/AGdRJe7YN/r6Hzwne1dI5sT815xPGKi5rrOZHOzPiU/WaQJ2'),
(6,'garry','6474254221','253 Suryanarayan','garry@outlook.com','ROLE_GUEST',6,'$2a$10$aGNI3Rc7I3YBQVH8qIciBuX9TJdl7fANNOMWIi7QNmQq0G1RYUWvq'),
(7,'guri','6474254231','354 Suryanarayan','guri@outlook.com','ROLE_GUEST',7,'$2a$10$m/CCxpGVWLdt7aIhoZpTHOYuxFnWYa3pImUXfCnM7342nQToguX1e'),
(8,'rati','6474254241','455 Suryanarayan','rati@outlook.com','ROLE_GUEST',8,'$2a$10$CLZFKO47oDDr2xQ9Q6V/EO5NtDaBLTtIIYMNA///KxxkD75mOWYn2'),
(9,'Harsh','6471200292','420 Kisananagar','harshpatel@yahoo.com','ROLE_USER',9,'$2a$10$NJ87INnYlaG4jQEI4A815uq8yyzWZs7L9gTMsZ0f7Df8J0aE84rPe'),
(10,'Kush','6478918179','101 crest avenue','kush@yahoo.com','ROLE_USER',10,'$2a$10$tBPiZY/dRmmxXnul6pVUNepLfD9QIrqwFUOwnDmXugAuxc1dRUhW2'),
(11,'mika','6473476179','451 crest avenue','mika@yahoo.com','ROLE_USER',11,'$2a$10$Be9u/9RGjdKfpiW5bbT2f.rey9T0OgzofhQdmk1v0/gzhpaId37SK'),
(12,'darshan','6479029649','657 crest avenue','darshan@yahoo.com','ROLE_USER',12,'$2a$10$TCmteCp7.ppiivBNUVkof.e.1pwn8loLnMv2Vzr3PkZX3Rev5R1le');
