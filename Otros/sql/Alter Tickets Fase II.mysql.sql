
/* Defaults de los parametros del sistema */

ALTER TABLE Tck_Params
ADD
  Def_Inc_Supp_Co      VARCHAR(64)    NOT NULL DEFAULT '' AFTER Def_Inc_SuppOrg;

ALTER TABLE Tck_Params
ADD
  Def_WO_Supp_Co       VARCHAR(96)    NOT NULL DEFAULT '' AFTER Def_WO_Person_ID;

ALTER TABLE Tck_Params
ADD
  Def_WO_Cust_Co       VARCHAR(96)    NOT NULL DEFAULT '' AFTER Def_WO_Supp_Co;

ALTER TABLE Tck_Params
ADD
  Def_WO_Pet_Mgr_Name  VARCHAR(64)    NOT NULL DEFAULT '' AFTER Def_WO_Cust_Co;

ALTER TABLE Tck_Params
ADD
  Def_WO_Req_Mgr_ID   VARCHAR(64)    NOT NULL DEFAULT '' AFTER Def_Pet_Mgr_Name;

ALTER TABLE Tck_Params
ADD
  Def_WO_Req_Mgr_Grp  VARCHAR(64)    NOT NULL DEFAULT '' AFTER Def_WO_Req_Mgr_ID;

ALTER TABLE Tck_Params
ADD
  Def_WO_Req_Asg_User VARCHAR(64)    NOT NULL DEFAULT '' AFTER Def_WO_Req_Mgr_Grp;

ALTER TABLE Tck_Params
ADD
  Def_WO_Req_Asg_Org  VARCHAR(64)    NOT NULL DEFAULT '' AFTER Def_WO_Req_Asg_User;

ALTER TABLE Tck_Params
ADD
  Def_WO_Req_Asg_Grp  VARCHAR(64)    NOT NULL DEFAULT '' AFTER Def_WO_Req_Asg_Org;

/* Add the new parameter values */

UPDATE Tck_Params
   SET Def_Inc_Supp_Co     = 'Servicios', 
       Def_WO_Supp_Co      = 'Servicios', 
       Def_WO_Cust_Co      = 'Gentera', 
       Def_WO_Pet_Mgr_Name = 'G. ARTURO RAYA BERNAL', 
       Def_WO_Req_Mgr_ID   = 'MESA DE SERVICIO', 
       Def_WO_Req_Mgr_Grp  = 'MESA DE SERVICIO', 
       Def_WO_Req_Asg_User = '', 
       Def_WO_Req_Asg_Org  = 'Gentera', 
       Def_WO_Req_Asg_Grp  = 'MESA DE SERVICIO';
  
/* ID del ticket principal */

ALTER TABLE Tck_Incidents
ADD
  Main_TicketID       VARCHAR(96);

/* Tabla de incidentes criticos */

CREATE TABLE Tck_CriticalIncidents
(
  IncidentID        INT            NOT NULL AUTO_INCREMENT,
  RemedyID          VARCHAR(96)    NOT NULL, 
  Title             VARCHAR(80)    NOT NULL,  
  Notes             VARCHAR(255)   NOT NULL, 
  Impact            VARCHAR(64)    NOT NULL, 
  AssignedGroup     VARCHAR(64)    NOT NULL, 
  Category_Lvl01    VARCHAR(96)    NOT NULL, 
  Category_Lvl02    VARCHAR(96)    NOT NULL, 
  Category_Lvl03    VARCHAR(96)    NOT NULL, 
  Product_Lvl01     VARCHAR(96)    NOT NULL, 
  Product_Lvl02     VARCHAR(96)    NOT NULL, 
  Product_Lvl03     VARCHAR(96)    NOT NULL,   
  Ticket_State      VARCHAR(1)     NOT NULL, 
  Creationdate      DATETIME,
  Close_Date        DATETIME,
  CONSTRAINT pk_CritIncidents PRIMARY KEY( IncidentID )
);
CREATE UNIQUE INDEX ux_Tck_CritIncidents ON Tck_CriticalIncidents( IncidentID );

