create table Item(
	name varchar(500) primary key,
	descripton varchar(500) not null
);
insert into Item values ('AREP', 'Curso en la ECI');


select * from Item;
drop table Item;