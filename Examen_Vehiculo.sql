create database vehiculo;

use vehiculo;

create table vehiculo(
id int auto_increment primary key,
tipo varchar(100) not null,
marca varchar(100) not null,
potencia int not null,
fechaDeCompra int not null
);

select * from vehiculo;
