create table if not exists PriceInfo (
  id identity,
  Name varchar(25) not null,
  Price decimal(5,2) not null
);

insert into PriceInfo (Name,Price) values('Soap',2.5);
insert into PriceInfo (Name,Price) values('Milk',4.5);
insert into PriceInfo (Name,Price) values('Rice',6.5);
insert into PriceInfo (Name,Price) values('baseProduct',10.4);