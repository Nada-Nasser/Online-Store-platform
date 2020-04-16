CREATE TABLE Administrator (
  Name      varchar(255) NULL, 
  password  varchar(255) NULL, 
  email     varchar(255) NOT NULL, 
  autherity varchar(255) NULL, 
  enabled   bit NULL, 
  CONSTRAINT email 
    PRIMARY KEY (email));
CREATE TABLE Buyers (
  Name      varchar(255) NULL, 
  password  varchar(255) NULL, 
  email     varchar(255) NOT NULL, 
  autherity varchar(255) NULL, 
  enabled   bit NULL, 
  PRIMARY KEY (email));
CREATE TABLE StoreOwner (
  Name      varchar(255) NULL, 
  password  varchar(255) NULL, 
  email     varchar(255) NOT NULL, 
  autherity varchar(255) NULL, 
  enabled   bit NULL, 
  CONSTRAINT email 
    PRIMARY KEY (email));

