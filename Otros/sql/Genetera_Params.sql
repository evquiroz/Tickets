CREATE TABLE Tck_Params 
(
  SendMessages        SMALLINT      NOT NULL,
  CompanyName         VARCHAR2(128) NOT NULL,
  Def_Inc_Source      VARCHAR2(64)  NOT NULL,
  Def_Inc_Status      VARCHAR2(64)  NOT NULL,
  Def_Inc_StReason    VARCHAR2(64)  NOT NULL,
  Def_Inc_ServType    VARCHAR2(64)  NOT NULL,
  Def_Inc_Impact      VARCHAR2(64)  NOT NULL,
  Def_Inc_Urgency     VARCHAR2(64)  NOT NULL,
  Def_Inc_Priority    VARCHAR2(64)  NOT NULL,
  Def_Inc_Group       VARCHAR2(64)  NOT NULL,
  Def_Inc_SuppOrg     VARCHAR2(64)  NOT NULL,
  Def_Inc_Supp_Co     VARCHAR2(64)  NOT NULL,
  Def_Inc_Action      VARCHAR2(64)  NOT NULL,
  Def_Inc_CLvl01      VARCHAR2(96)  NOT NULL,
  Def_Inc_CLvl02      VARCHAR2(96)  NOT NULL,
  Def_Inc_CLvl03      VARCHAR2(96)  NOT NULL,
  Def_Inc_PLvl01      VARCHAR2(96)  NOT NULL,
  Def_Inc_PLvl02      VARCHAR2(96)  NOT NULL,
  Def_Inc_PLvl03      VARCHAR2(96)  NOT NULL,
  Def_Inc_LastName    VARCHAR2(64)  NOT NULL,
  Def_Inc_Person_ID   VARCHAR2(64)  NOT NULL,
  Def_WO_OrdType      VARCHAR2(64)  NOT NULL,
  Def_WO_GrpAdm       VARCHAR2(64)  NOT NULL,
  Def_WO_GrpSop       VARCHAR2(64)  NOT NULL,
  Def_WO_Status       VARCHAR2(64)  NOT NULL,
  Def_WO_StReason     VARCHAR2(64)  NOT NULL,
  Def_WO_Priority     VARCHAR2(64)  NOT NULL,
  Def_WO_Action       VARCHAR2(64)  NOT NULL,
  Def_WO_Source       VARCHAR2(64)  NOT NULL,
  Def_WO_CLvl01       VARCHAR2(96)  NOT NULL,
  Def_WO_CLvl02       VARCHAR2(96)  NOT NULL,
  Def_WO_CLvl03       VARCHAR2(96)  NOT NULL,
  Def_WO_PLvl01       VARCHAR2(96)  NOT NULL,
  Def_WO_PLvl02       VARCHAR2(96)  NOT NULL,
  Def_WO_PLvl03       VARCHAR2(96)  NOT NULL,
  Def_WO_LastName     VARCHAR2(64)  NOT NULL,
  Def_WO_Person_ID    VARCHAR2(64)  NOT NULL,
  Def_WO_Supp_Co      VARCHAR2(96)  NOT NULL,
  Def_WO_Cust_Co      VARCHAR2(96)  NOT NULL,
  Def_WO_Pet_Mgr_Name VARCHAR2(64)  NOT NULL,
  Def_WO_Req_Mgr_ID   VARCHAR2(64)  NOT NULL,
  Def_WO_Req_Mgr_Grp  VARCHAR2(64)  NOT NULL,
  Def_WO_Req_Asg_User VARCHAR2(64)  NOT NULL,
  Def_WO_Req_Asg_Org  VARCHAR2(64)  NOT NULL,
  Def_WO_Req_Asg_Grp  VARCHAR2(64)  NOT NULL
);

INSERT INTO Tck_Params VALUES ( 
  0,'Gentera','Web','Assigned','Initial Status','User Service Restoration','4-Minor/Localized',
  'Baja','Low','Mesa de servicio','Back End','Servicios','CREATE','Incidencia','Funcionalidad','General',
  'Servicios','Software Backoffice','General','SIEM','PPL000000028790','General','Mesa de servicio',
  'Mesa de servicio','Assigned', 'Initial Status', 'Low','CREATE','Web','Solicitud',
  'Configuracion','General','Servicios','Software Backoffice','General','SIEM','PPL000000028790',

  'Servicios','Gentera','G. ARTURO RAYA BERNAL','Mesa de servicio','Mesa de servicio','##FULLNAME##',
  'Gentera','Mesa de servicio'
);

UPDATE Tck_Params
  SET 
      Def_Inc_Supp_Co     = 'Servicios',
      Def_WO_Supp_Co      = 'Servicios', 
      Def_WO_Cust_Co      = 'Gentera', 
      Def_WO_Pet_Mgr_Name = 'G. ARTURO RAYA BERNAL', 
      Def_WO_Req_Mgr_ID   = 'Mesa de servicio', 
      Def_WO_Req_Mgr_Grp  = 'Mesa de servicio', 
      Def_WO_Req_Asg_User = '##FULLNAME##', 
      Def_WO_Req_Asg_Org  = 'Gentera', 
      Def_WO_Req_Asg_Grp  = 'Mesa de servicio';

COMMIT;
