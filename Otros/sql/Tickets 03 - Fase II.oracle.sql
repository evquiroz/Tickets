-- Oracle Script for Ticket Database
-- Database must be previously created

-- CREATE DATABASE Tickets;

CREATE TABLE Tck_Params
(
  SendMessages         SMALLINT        NOT NULL,
  CompanyName          VARCHAR2(128)   NOT NULL, 
  Def_Inc_Source       VARCHAR2(64)    NOT NULL, 
  Def_Inc_Status       VARCHAR2(64)    NOT NULL, 
  Def_Inc_StReason     VARCHAR2(64)    NOT NULL, 
  Def_Inc_ServType     VARCHAR2(64)    NOT NULL, 

  Def_Inc_Impact       VARCHAR2(64)    NOT NULL, 
  Def_Inc_Urgency      VARCHAR2(64)    NOT NULL, 
  Def_Inc_Priority     VARCHAR2(64)    NOT NULL, 
  Def_Inc_Group        VARCHAR2(64)    NOT NULL, 
  Def_Inc_SuppOrg      VARCHAR2(64)    NOT NULL, 
  Def_Inc_Supp_Co      VARCHAR2(96)    NOT NULL, 
  Def_Inc_Action       VARCHAR2(64)    NOT NULL,
  Def_Inc_CLvl01       VARCHAR2(96)    NOT NULL, 
  Def_Inc_CLvl02       VARCHAR2(96)    NOT NULL, 
  Def_Inc_CLvl03       VARCHAR2(96)    NOT NULL, 
  Def_Inc_PLvl01       VARCHAR2(96)    NOT NULL, 
  Def_Inc_PLvl02       VARCHAR2(96)    NOT NULL, 
  Def_Inc_PLvl03       VARCHAR2(96)    NOT NULL, 

  Def_Inc_LastName     VARCHAR2(64)    NOT NULL,
  Def_Inc_Person_ID    VARCHAR2(64)    NOT NULL, 
    
  Def_WO_OrdType       VARCHAR2(64)    NOT NULL, 
  Def_WO_GrpAdm        VARCHAR2(64)    NOT NULL, 
  Def_WO_GrpSop        VARCHAR2(64)    NOT NULL, 
  Def_WO_Status        VARCHAR2(64)    NOT NULL, 
  Def_WO_StReason      VARCHAR2(64)    NOT NULL, 
  Def_WO_Priority      VARCHAR2(64)    NOT NULL, 
  Def_WO_Action        VARCHAR2(64)    NOT NULL,
  Def_WO_Source        VARCHAR2(64)    NOT NULL,
  Def_WO_CLvl01        VARCHAR2(96)    NOT NULL, 
  Def_WO_CLvl02        VARCHAR2(96)    NOT NULL, 
  Def_WO_CLvl03        VARCHAR2(96)    NOT NULL, 
  Def_WO_PLvl01        VARCHAR2(96)    NOT NULL, 
  Def_WO_PLvl02        VARCHAR2(96)    NOT NULL, 
  Def_WO_PLvl03        VARCHAR2(96)    NOT NULL,
  
  Def_WO_LastName      VARCHAR2(64)    NOT NULL,
  Def_WO_Person_ID     VARCHAR2(64)    NOT NULL,

  Def_WO_Supp_Co       VARCHAR2(96)    NOT NULL,
  Def_WO_Cust_Co       VARCHAR2(96)    NOT NULL, 
  Def_WO_Pet_Mgr_Name  VARCHAR2(64)    NOT NULL,
  Def_WO_Req_Mgr_ID    VARCHAR2(64)    NOT NULL, 
  Def_WO_Req_Mgr_Grp   VARCHAR2(64)    NOT NULL, 
  Def_WO_Req_Asg_User  VARCHAR2(64)    NOT NULL, 
  Def_WO_Req_Asg_Org   VARCHAR2(64)    NOT NULL, 
  Def_WO_Req_Asg_Grp   VARCHAR2(64)    NOT NULL
);

INSERT INTO Tck_Params( 
            SendMessages,     CompanyName,       Def_Inc_Source,   Def_Inc_Status, Def_Inc_StReason, Def_Inc_ServType,
            Def_Inc_Impact,   Def_Inc_Urgency,   Def_Inc_Priority, Def_Inc_Group,  Def_Inc_SuppOrg,  Def_Inc_Action, 
            Def_Inc_CLvl01,   Def_Inc_CLvl02,    Def_Inc_CLvl03,   Def_Inc_PLvl01, Def_Inc_PLvl02,   Def_Inc_PLvl03,
			Def_Inc_LastName, Def_Inc_Person_ID, 
            Def_WO_OrdType,   Def_WO_GrpAdm,     Def_WO_GrpSop, Def_WO_Status, Def_WO_StReason, Def_WO_Priority, 
			Def_WO_Action,    Def_WO_Source,  
            Def_WO_CLvl01,    Def_WO_CLvl02,     Def_WO_CLvl03, Def_WO_PLvl01, Def_WO_PLvl02, Def_WO_PLvl03,
			Def_WO_LastName,  Def_WO_Person_ID, 

			Def_Inc_Supp_Co,  Def_WO_Supp_Co,    Def_WO_Cust_Co,   Def_WO_Pet_Mgr_Name,       
			Def_WO_Req_Mgr_ID,
			Def_WO_Req_Mgr_Grp, 
			Def_WO_Req_Asg_User,  
            Def_WO_Req_Asg_Org, 
            Def_WO_Req_Asg_Grp
	   )
VALUES ( 0,                   'Gentera',          'Web',              'Assigned',         'Initial Status',      'User Service Restoration', 
         '4-Minor/Localized', 'Baja',             'Low',              'Mesa de servicio', 'Back End',            'CREATE', 
         'Otros',             'Falla',            'Portal web',       'Servicios',        'Software BackOffice', 'Remedy',
		 'SIEM',              'PPL000000028790',
         'General',           'Mesa de servicio', 'Mesa de servicio', 'Assigned',         'Initial Status',      'Low', 
		 'CREATE',            'Web', 
         'Otros',             'Solicitud',        'Portal web',       'Servicios',        'Software BackOffice', 'Remedy', 
		 'SIEM',              'PPL000000028790', 

         'Servicios',         'Servicios',        'Gentera',          'G. ARTURO RAYA BERNAL',
         'MESA DE SERVICIO',  'MESA DE SERVICIO', ' ',                 'Gentera',          'MESA DE SERVICIO'
	   );
COMMIT;       
       
CREATE TABLE Tck_LocalUsers
(
  RecordID          SMALLINT        NOT NULL, 
  LoginName         VARCHAR2(16)    NOT NULL,
  Secret            VARCHAR2(128)   NOT NULL,
  eMail             VARCHAR2(128)   NOT NULL, 
  UserLevel         SMALLINT        DEFAULT  3  NOT NULL ,
  Status            VARCHAR2(1)     DEFAULT 'A' NOT NULL,
  CreatedBy         VARCHAR2(16)    NOT NULL, 
  CreatedOn         DATE            DEFAULT CURRENT_TIMESTAMP NOT NULL,   
  UpdatedBy         VARCHAR2(16)    NOT NULL, 
  LastUpdate        TIMESTAMP       DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_LocalUsers PRIMARY KEY( RecordID )
);
CREATE UNIQUE INDEX ux_TckLocalLogins ON Tck_LocalUsers( LoginName );
CREATE UNIQUE INDEX ux_TckLocalUsers ON Tck_LocalUsers( eMail );

CREATE TABLE Tck_LogSessions
(
  RecordID          INT            NOT NULL,
  LoginName         VARCHAR2(16)   NOT NULL,
  SessionDate       TIMESTAMP      DEFAULT CURRENT_TIMESTAMP NOT NULL,
  CONSTRAINT pk_LogSessions PRIMARY KEY( RecordID )
);

CREATE TABLE Tck_Messages
(
  MessageID         INT,
  InfoMessage       CLOB, 
  StartDate         DATE,
  EndDate           DATE, 
  MainMessage       SMALLINT       NOT NULL,
  CreatedBy         VARCHAR2(16)   NOT NULL, 
  CreatedOn         DATE           DEFAULT CURRENT_TIMESTAMP NOT NULL,
  UpdatedBy         VARCHAR2(16)   NOT NULL, 
  LastUpdate        TIMESTAMP      DEFAULT CURRENT_TIMESTAMP NOT NULL,
  CONSTRAINT pk_Messages PRIMARY KEY( MessageID )
);
 
CREATE TABLE Tck_Incidents
(
  IncidentID        INT            NOT NULL,
  RemedyID          VARCHAR2(96)   NOT NULL, 
  CompanyName       VARCHAR2(128)  NOT NULL, 
  Customer          VARCHAR2(32)   NOT NULL,
  Title             VARCHAR2(80)   NOT NULL,  
  Notes             VARCHAR2(255)  NOT NULL, 
  Priority          VARCHAR2(64)   NOT NULL, 
  Impact            VARCHAR2(64)   NOT NULL, 
  Urgency           VARCHAR2(64)   NOT NULL, 
  AssignedGroup     VARCHAR2(64)   NOT NULL, 
  Source            VARCHAR2(64)   NOT NULL, 
  Category_Lvl01    VARCHAR2(96)   NOT NULL, 
  Category_Lvl02    VARCHAR2(96)   NOT NULL, 
  Category_Lvl03    VARCHAR2(96)   NOT NULL, 
  Product_Lvl01     VARCHAR2(96)   NOT NULL, 
  Product_Lvl02     VARCHAR2(96)   NOT NULL, 
  Product_Lvl03     VARCHAR2(96)   NOT NULL, 
  Main_TicketID     VARCHAR2(96), 
  CONSTRAINT pk_Tck_Incidents PRIMARY KEY( IncidentID ) 
);

CREATE TABLE Tck_WorkOrders
(
  WorkOrderID       INT            NOT NULL,
  RemedyID          VARCHAR2(96)   NOT NULL, 
  CompanyName       VARCHAR2(128)  NOT NULL, 
  Customer          VARCHAR2(32)   NOT NULL,
  Title             VARCHAR2(80)   NOT NULL,  
  Notes             VARCHAR2(255)  NOT NULL, 
  Priority          VARCHAR2(64)   NOT NULL, 
  Order_Type        VARCHAR2(64)   NOT NULL,     
  Mngmt_Group       VARCHAR2(64)   NOT NULL, 
  Support_Group     VARCHAR2(64)   NOT NULL, 
  Order_Status      VARCHAR2(64)   NOT NULL, 
  Status_Reason     VARCHAR2(64)   NOT NULL, 
  Source            VARCHAR2(64)   NOT NULL, 
  Category_Lvl01    VARCHAR2(96)   NOT NULL, 
  Category_Lvl02    VARCHAR2(96)   NOT NULL, 
  Category_Lvl03    VARCHAR2(96)   NOT NULL, 
  Product_Lvl01     VARCHAR2(96)   NOT NULL, 
  Product_Lvl02     VARCHAR2(96)   NOT NULL, 
  Product_Lvl03     VARCHAR2(96)   NOT NULL, 
  CONSTRAINT pk_Tck_WorkOrders PRIMARY KEY( WorkOrderID ) 
);

CREATE TABLE Tck_CriticalIncidents
(
  IncidentID        INT            NOT NULL,
  RemedyID          VARCHAR2(96)   NOT NULL, 
  Title             VARCHAR2(80)   NOT NULL,  
  Notes             VARCHAR2(255)  NOT NULL, 
  Impact            VARCHAR2(64)   NOT NULL, 
  AssignedGroup     VARCHAR2(64)   NOT NULL, 
  Category_Lvl01    VARCHAR2(96)   NOT NULL, 
  Category_Lvl02    VARCHAR2(96)   NOT NULL, 
  Category_Lvl03    VARCHAR2(96)   NOT NULL, 
  Product_Lvl01     VARCHAR2(96)   NOT NULL, 
  Product_Lvl02     VARCHAR2(96)   NOT NULL, 
  Product_Lvl03     VARCHAR2(96)   NOT NULL, 
  Ticket_State      VARCHAR2(1)    NOT NULL, 
  Creationdate      DATE           DEFAULT CURRENT_TIMESTAMP,
  Close_Date        DATE,
  CONSTRAINT pk_CritIncidents PRIMARY KEY( IncidentID )
);
CREATE UNIQUE INDEX ux_Tck_CritIncidents ON Tck_CriticalIncidents( RemedyID );

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

----
---- Secuencias
----

CREATE SEQUENCE sq_LogSessions
  INCREMENT BY 1 
  START WITH   1 
  MAXVALUE     999999999 
  MINVALUE     1 
  ORDER;

CREATE SEQUENCE sq_LocalUsers
  INCREMENT BY 1 
  START WITH   1 
  MAXVALUE     999999999 
  MINVALUE     1 
  ORDER;

CREATE SEQUENCE sq_Messages
  INCREMENT BY 1 
  START WITH   1 
  MAXVALUE     999999999 
  MINVALUE     1 
  ORDER;

CREATE SEQUENCE sq_Incidents
  INCREMENT BY 1 
  START WITH   1 
  MAXVALUE     999999999 
  MINVALUE     1 
  ORDER;
  
CREATE SEQUENCE sq_WorkOrders
  INCREMENT BY 1 
  START WITH   1 
  MAXVALUE     999999999 
  MINVALUE     1 
  ORDER;
  
CREATE SEQUENCE sq_CritIncidents
  INCREMENT BY 1 
  START WITH   1 
  MAXVALUE     999999999 
  MINVALUE     1 
  ORDER;
  
----
---- Triggers
----

CREATE OR REPLACE TRIGGER tgr_bi_Tck_LocalUserID
  BEFORE INSERT ON Tck_LocalUsers 
  REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
  SELECT sq_LocalUsers.NEXTVAL INTO :new.RecordID 
         FROM dual;
END;

/
  
CREATE OR REPLACE TRIGGER tgr_bi_Tck_LogSessionID
  BEFORE INSERT ON Tck_LogSessions 
  REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
  SELECT sq_LogSessions.NEXTVAL INTO :new.RecordID 
         FROM dual;
END;

/

CREATE OR REPLACE TRIGGER tgr_bi_Tck_MessageID
  BEFORE INSERT ON Tck_Messages 
  REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
  SELECT sq_Messages.NEXTVAL INTO :new.MessageID 
         FROM dual;
END;

/

CREATE OR REPLACE TRIGGER tgr_bi_Tck_IncidentID
  BEFORE INSERT ON Tck_Incidents 
  REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
  SELECT sq_Incidents.NEXTVAL INTO :new.IncidentID 
         FROM dual;
END;

/

CREATE OR REPLACE TRIGGER tgr_bi_Tck_WorkOrderID
  BEFORE INSERT ON Tck_WorkOrders 
  REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
  SELECT sq_WorkOrders.NEXTVAL INTO :new.WorkOrderID 
         FROM dual;
END;

/

CREATE OR REPLACE TRIGGER tgr_bi_Tck_CIncidentID
  BEFORE INSERT ON Tck_CriticalIncidents 
  REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
  SELECT sq_CritIncidents.NEXTVAL INTO :new.IncidentID 
         FROM dual;
END;

/

-- Password Ticket101
INSERT INTO Tck_LocalUsers( LoginName, Secret, eMail, UserLevel, Status, CreatedBy, UpdatedBy )
  VALUES( 'admin', '0dcf6a4b7699c7914e7838640be05fed', 'admin@gentera.com.mx', 1, 'A', 'admin', 'admin' );

COMMIT;  
