CREATE TABLE teams(
teamId long primary key auto_increment,
teamName nvarchar(20),
continent nvarchar(20),
played int,
won int,
drawn int,
lost int
);