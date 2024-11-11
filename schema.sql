create database userdetailsdb;

use userdetailsdb;

create table userdata
(
S_No integer auto_increment primary key,
UserName varchar(150) not null,
Email varchar(50) not null unique,
Passwd varchar(20) not null
);

create table expenses
(
S_No integer auto_increment primary key,
Trip_Name varchar(200) not null,
Budget integer not null,
Expense_Amount integer not null,
Expense_Reason varchar(100) not null
);