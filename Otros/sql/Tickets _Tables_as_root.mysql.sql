
USE Tickets;

CREATE TABLE Tck_Params
(
  SendMessages      SMALLINT       NOT NULL,
  CompanyName       VARCHAR(128)   NOT NULL, 
  Def_Inc_Source    VARCHAR(64)    NOT NULL, 
  Def_Inc_Status    VARCHAR(64)    NOT NULL, 
  Def_Inc_StReason  VARCHAR(64)    NOT NULL, 
  Def_Inc_ServType  VARCHAR(64)    NOT NULL, 

  Def_Inc_Impact    VARCHAR(64)    NOT NULL, 
  Def_Inc_Urgency   VARCHAR(64)    NOT NULL, 
  Def_Inc_Priority  VARCHAR(64)    NOT NULL, 
  Def_Inc_Group     VARCHAR(64)    NOT NULL, 
  Def_Inc_SuppOrg   VARCHAR(64)    NOT NULL, 
  Def_Inc_Action    VARCHAR(64)    NOT NULL,
  Def_Inc_CLvl01    VARCHAR(96)    NOT NULL, 
  Def_Inc_CLvl02    VARCHAR(96)    NOT NULL, 
  Def_Inc_CLvl03    VARCHAR(96)    NOT NULL, 
  Def_Inc_PLvl01    VARCHAR(96)    NOT NULL, 
  Def_Inc_PLvl02    VARCHAR(96)    NOT NULL, 
  Def_Inc_PLvl03    VARCHAR(96)    NOT NULL, 

  Def_Inc_LastName  VARCHAR(64)    NOT NULL,
  Def_Inc_Person_ID VARCHAR(64)    NOT NULL, 
    
  Def_WO_OrdType    VARCHAR(64)    NOT NULL, 
  Def_WO_GrpAdm     VARCHAR(64)    NOT NULL, 
  Def_WO_GrpSop     VARCHAR(64)    NOT NULL, 
  Def_WO_Status     VARCHAR(64)    NOT NULL, 
  Def_WO_StReason   VARCHAR(64)    NOT NULL, 
  Def_WO_Priority   VARCHAR(64)    NOT NULL, 
  Def_WO_Action     VARCHAR(64)    NOT NULL,
  Def_WO_Source     VARCHAR(64)    NOT NULL,
  Def_WO_CLvl01     VARCHAR(96)    NOT NULL, 
  Def_WO_CLvl02     VARCHAR(96)    NOT NULL, 
  Def_WO_CLvl03     VARCHAR(96)    NOT NULL, 
  Def_WO_PLvl01     VARCHAR(96)    NOT NULL, 
  Def_WO_PLvl02     VARCHAR(96)    NOT NULL, 
  Def_WO_PLvl03     VARCHAR(96)    NOT NULL,
  
  Def_WO_LastName   VARCHAR(64)    NOT NULL,
  Def_WO_Person_ID  VARCHAR(64)    NOT NULL
);

INSERT INTO Tck_Params( 
            SendMessages,     CompanyName,       Def_Inc_Source,   Def_Inc_Status, Def_Inc_StReason, Def_Inc_ServType,
            Def_Inc_Impact,   Def_Inc_Urgency,   Def_Inc_Priority, Def_Inc_Group,  Def_Inc_SuppOrg,  Def_Inc_Action, 
            Def_Inc_CLvl01,   Def_Inc_CLvl02,    Def_Inc_CLvl03,   Def_Inc_PLvl01, Def_Inc_PLvl02,   Def_Inc_PLvl03,
			Def_Inc_LastName, Def_Inc_Person_ID, 
            Def_WO_OrdType,   Def_WO_GrpAdm,     Def_WO_GrpSop, Def_WO_Status, Def_WO_StReason, Def_WO_Priority, 
			Def_WO_Action,    Def_WO_Source,  
            Def_WO_CLvl01,    Def_WO_CLvl02,     Def_WO_CLvl03, Def_WO_PLvl01, Def_WO_PLvl02, Def_WO_PLvl03,
			Def_WO_LastName,  Def_WO_Person_ID
	   )
VALUES ( 0,                   'Gentera',          'Web',              'Assigned',         'Initial Status',      'User Service Restoration', 
         '4-Minor/Localized', 'Baja',             'Low',              'Mesa de servicio', 'Back End',            'CREATE', 
         'Otros',             'Falla',            'Portal web',       'Servicios',        'Software BackOffice', 'Remedy',
		     'SIEM',              'PPL000000028790',
         'General',           'Mesa de servicio', 'Mesa de servicio', 'Assigned',         'Initial Status',      'Low', 
		     'CREATE',            'Web', 
         'Otros',             'Solicitud',        'Portal web',       'Servicios',        'Software BackOffice', 'Remedy', 
		     'SIEM',              'PPL000000028790'
	   );


CREATE TABLE Tck_LocalUsers
(
  LoginName         VARCHAR(16)    NOT NULL,
  Secret            VARCHAR(128)   NOT NULL,
  eMail             VARCHAR(128)   NOT NULL, 
  UserLevel         SMALLINT       NOT NULL DEFAULT 3,
  STATUS            VARCHAR(1)     NOT NULL DEFAULT 'A',
  CreatedBy         VARCHAR(16)    NOT NULL, 
  CreatedOn         DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP,   
  UpdatedBy         VARCHAR(16)    NOT NULL, 
  LastUpdate        TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_LocalUsers PRIMARY KEY( LoginName )
);
CREATE UNIQUE INDEX ux_TckLocalUsers ON Tck_LocalUsers( eMail );

ALTER TABLE Tck_LocalUsers
ADD 
  CONSTRAINT def_TckUserCreatedOn DEFAULT CURRENT_TIMESTAMP FOR CreatedOn;

-- Password Ticket101
INSERT INTO Tck_LocalUsers( LoginName, Secret, eMail, UserLevel, Status, CreatedBy, UpdatedBy )
  VALUES( 'admin', '0dcf6a4b7699c7914e7838640be05fed', 'admin@gentera.com.mx', 1, 'A', 'admin', 'admin' );


CREATE TABLE Tck_LogSessions
(
  RecordID          INT            NOT NULL AUTO_INCREMENT,
  LoginName         VARCHAR(16)    NOT NULL,
  SessionDate       DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_LogSessions PRIMARY KEY( RecordID )
);

ALTER TABLE Tck_LogSessions
ADD 
  CONSTRAINT def_TckSessionDate DEFAULT CURRENT_TIMESTAMP FOR SessionDate;


CREATE TABLE Tck_Messages
(
  MessageID         INT            NOT NULL AUTO_INCREMENT,
  InfoMessage       TEXT, 
  StartDate         DATETIME,
  EndDate           DATETIME, 
  MainMessage       SMALLINT       NOT NULL,
  CreatedBy         VARCHAR(16)    NOT NULL, 
  CreatedOn         DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UpdatedBy         VARCHAR(16)    NOT NULL, 
  LastUpdate        TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_Messages PRIMARY KEY( MessageID )
);

ALTER TABLE Tck_Messages
ADD 
  CONSTRAINT def_TckMsgCreatedOn DEFAULT CURRENT_TIMESTAMP FOR CreatedOn;

 
CREATE TABLE Tck_Incidents
(
  IncidentID        INT            NOT NULL AUTO_INCREMENT,
  RemedyID          VARCHAR(96)    NOT NULL, 
  CompanyName       VARCHAR(128)   NOT NULL, 
  Customer          VARCHAR(32)    NOT NULL,
  Title             VARCHAR(80)    NOT NULL,  
  Notes             VARCHAR(255)   NOT NULL, 
  Priority          VARCHAR(64)    NOT NULL, 
  Impact            VARCHAR(64)    NOT NULL, 
  Urgency           VARCHAR(64)    NOT NULL, 
  AssignedGroup     VARCHAR(64)    NOT NULL, 
  Source            VARCHAR(64)    NOT NULL, 
  Category_Lvl01    VARCHAR(96)    NOT NULL, 
  Category_Lvl02    VARCHAR(96)    NOT NULL, 
  Category_Lvl03    VARCHAR(96)    NOT NULL, 
  Product_Lvl01     VARCHAR(96)    NOT NULL, 
  Product_Lvl02     VARCHAR(96)    NOT NULL, 
  Product_Lvl03     VARCHAR(96)    NOT NULL, 
  CONSTRAINT pk_Tck_Incidents PRIMARY KEY( IncidentID ) 
);

CREATE TABLE Tck_WorkOrders
(
  WorkOrderID       INT            NOT NULL AUTO_INCREMENT,
  RemedyID          VARCHAR(96)    NOT NULL, 
  CompanyName       VARCHAR(128)   NOT NULL, 
  Customer          VARCHAR(32)    NOT NULL,
  Title             VARCHAR(80)    NOT NULL,  
  Notes             VARCHAR(255)   NOT NULL, 
  Priority          VARCHAR(64)    NOT NULL, 
  Order_Type        VARCHAR(64)    NOT NULL,     
  Mngmt_Group       VARCHAR(64)    NOT NULL, 
  Support_Group     VARCHAR(64)    NOT NULL, 
  Order_Status      VARCHAR(64)    NOT NULL, 
  Status_Reason     VARCHAR(64)    NOT NULL, 
  Source            VARCHAR(64)    NOT NULL, 
  Category_Lvl01    VARCHAR(96)    NOT NULL, 
  Category_Lvl02    VARCHAR(96)    NOT NULL, 
  Category_Lvl03    VARCHAR(96)    NOT NULL, 
  Product_Lvl01     VARCHAR(96)    NOT NULL, 
  Product_Lvl02     VARCHAR(96)    NOT NULL, 
  Product_Lvl03     VARCHAR(96)    NOT NULL, 
  CONSTRAINT pk_Tck_WorkOrders PRIMARY KEY( WorkOrderID ) 
);
