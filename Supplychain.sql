create database supply;
use supply;
show tables;
create table User(
emailId varchar(255) PRIMARY KEY,
UserName varchar(255),
Pass varchar(255),
userType varchar(255));

select * from user;
Insert into user values("surya@gmail.com","Surya","1234","Buyer");
Insert into user values("balu@gmail.com","Balachander","1734","Buyer");
Insert into user values("Keerthi@gmail.com","Keerthi","abKee","Buyer");
Insert into user values("Deexika@gmail.com","Deexika","deepass","Buyer");
Insert into user(UserName,emailId,pass,userType)values("Madhu","Madhu@gmail.com","23453","Seller");

create table product(
productId int PRIMARY KEY,
productName varchar(255),
price float,
sellerId varchar(255),
foreign key(sellerId) references user(emailId));
insert into product values(1,"car","1234567","surya@gmail.com");
insert into product values(2,"Bike","182736457","balu@gmail.com");

select * from product;
create table orders(
orderID int PRIMARY KEY,
productID int,
userID varchar(255),
foreign key(productID) references product(productID),
foreign key(userID)references user(emailID));
select *from orders;


