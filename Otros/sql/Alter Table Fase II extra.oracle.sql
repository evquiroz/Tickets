-- SQL Server

ALTER TABLE Tck_CriticalIncidents
ADD
  Impact            VARCHAR2(64)    NOT NULL DEFAULT '4-Minor/Localized';
  
ALTER TABLE Tck_CriticalIncidents
ADD
  AssignedGroup     VARCHAR2(64)    NOT NULL DEFAULT 'Mesa de servicio'; 
  
ALTER TABLE Tck_CriticalIncidents
ADD
  Category_Lvl01    VARCHAR2(60)    NOT NULL DEFAULT 'Otros'; 
  
ALTER TABLE Tck_CriticalIncidents
ADD
  Category_Lvl02    VARCHAR2(60)    NOT NULL DEFAULT 'Falla'; 
  
ALTER TABLE Tck_CriticalIncidents
ADD
  Category_Lvl03    VARCHAR2(60)    NOT NULL DEFAULT 'Portal web'; 
  
ALTER TABLE Tck_CriticalIncidents
ADD
  Product_Lvl01     VARCHAR2(60)    NOT NULL DEFAULT 'Servicios'; 
  
ALTER TABLE Tck_CriticalIncidents
ADD
  Product_Lvl02     VARCHAR2(60)    NOT NULL DEFAULT 'Software BackOffice'; 
  
ALTER TABLE Tck_CriticalIncidents
ADD
  Product_Lvl03     VARCHAR2(60)    NOT NULL DEFAULT 'Remedy';   

CREATE TABLE Tck_Impactos
(
  ImpactID          SMALLINT       NOT NULL,
  ImpactName        VARCHAR2(64)    NOT NULL,
  CONSTRAINT pk_TckImpacts PRIMARY KEY( ImpactID )
);
CREATE UNIQUE INDEX ux_TckImpacts ON Tck_Impactos( ImpactName );

INSERT INTO Tck_Impactos VALUES( 1000, '1-Extensive/Generalized');
INSERT INTO Tck_Impactos VALUES( 2000, '2-Meaningful/Widespread');
INSERT INTO Tck_Impactos VALUES( 3000, '3-Moderated/Limited');
INSERT INTO Tck_Impactos VALUES( 4000, '4-Minor/Localized');

COMMIT;

