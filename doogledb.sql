drop database if exists doogledb;
create database doogledb;
use doogledb;
create table shelter(
id int primary key auto_increment,
`name` varchar(30) not null,
`location` varchar(50) not null,
`website` varchar(100));
create table dog(
id int primary key auto_increment,
`name` varchar(30) not null,
`breed` varchar(100),
`color` varchar(30),
`foodPreference` varchar(100),
`walksPerDay` int,
age int not null,
shelterId int not null,
foreign key (shelterId) references shelter(id));