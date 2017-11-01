
/* Defaults de los parametros del sistema */

ALTER TABLE Tck_Params
ADD
  Def_Inc_Supp_Co      VARCHAR(64)    NOT NULL DEFAULT '';

ALTER TABLE Tck_Params
ADD
  Def_WO_Supp_Co       VARCHAR(96)    NOT NULL DEFAULT '';

ALTER TABLE Tck_Params
ADD
  Def_WO_Cust_Co       VARCHAR(96)    NOT NULL DEFAULT '';

ALTER TABLE Tck_Params
ADD
  Def_WO_Pet_Mgr_Name  VARCHAR(64)    NOT NULL DEFAULT '';

ALTER TABLE Tck_Params
ADD
  Def_WO_Req_Mgr_ID   VARCHAR(64)    NOT NULL DEFAULT '';

ALTER TABLE Tck_Params
ADD
  Def_WO_Req_Mgr_Grp  VARCHAR(64)    NOT NULL DEFAULT '';

ALTER TABLE Tck_Params
ADD
  Def_WO_Req_Asg_User VARCHAR(64)    NOT NULL DEFAULT '';

ALTER TABLE Tck_Params
ADD
  Def_WO_Req_Asg_Org  VARCHAR(64)    NOT NULL DEFAULT '';

ALTER TABLE Tck_Params
ADD
  Def_WO_Req_Asg_Grp  VARCHAR(64)    NOT NULL DEFAULT '';

/* ID del ticket principal */

ALTER TABLE Tck_Incidents
ADD
  Main_TicketID     varchar(96);

/* Tabla de incidentes criticos */

CREATE TABLE Tck_CriticalIncidents
(
  IncidentID        INT            NOT NULL IDENTITY(1,1),
  RemedyID          VARCHAR(96)    NOT NULL, 
  Title             VARCHAR(80)    NOT NULL,  
  Notes             VARCHAR(255)   NOT NULL, 
  Ticket_State      VARCHAR(1)     NOT NULL, 
  Close_Date        DATETIME,
  CONSTRAINT pk_CritIncidents PRIMARY KEY( IncidentID )
);
CREATE UNIQUE INDEX ux_Tck_CritIncidents ON Tck_CriticalIncidents( IncidentID );


