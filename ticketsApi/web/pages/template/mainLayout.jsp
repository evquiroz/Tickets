<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate" );
  response.setHeader("Pragma", "no-cache" );
  response.setHeader("Expires", "0");
%>

<!DOCTYPE html>
<html lang="es">
<head>
  <title><s:property value="getText('lbl.html.title')" /></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-with, initial-scale=1">

  <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv="Expires" content="0">

  <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/favicon.ico">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/gentera.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-ui.css">

  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/links.js"></script>

  <style>
    html {
      display : none ;
      visibility : hidden ;
    }
  </style>

  <script>
    if ( self === top )
    {
       document.documentElement.style.display    = 'block' ;
       document.documentElement.style.visibility = 'visible' ;
    }
    else
       top.location = self.location;
  </script>
</head>

<body amrgin-left="0" margin-right="0">

<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="externalBody" />
<tiles:insertAttribute name="internalBody" />    

<div align="center"> 
  <tiles:insertAttribute name="footer" />
</div>

</body>
</html>
