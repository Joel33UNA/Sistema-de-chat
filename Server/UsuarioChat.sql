CREATE DATABASE UsuarioChat;

use UsuarioChat;

create table Usuario (
	id varchar(19) not null,
    clave varchar(255) not null,
    nombre varchar(255) not null,
    primary key (id)
);