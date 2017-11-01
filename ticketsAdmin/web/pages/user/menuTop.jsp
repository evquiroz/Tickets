<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page import="mx.com.nttdata.util.IGlobalConstants" %>

  <div align="center">

  <br>
  <span class="fieldError"><s:property value="#session.sessionErrorMsg" /></span>
  <br>

  <div class="formArea ui-corner-all">

    <blockquote style="text-align: left">
      <h3><s:property value="getText('lbl.main.welcomeAdm')" /></h3>
    </blockquote>
    
    <br>    
    <button id="buttonUsers" class="ui-button ui-widget ui-corner-all bigButton"
            onClick="javascript:adminUsers()">
      <s:property value="getText('lbl.main.buttonUsers')" /></button>
    
    <br><br><br>
    <button id="buttonCIncidents" class="ui-button ui-widget ui-corner-all bigButton"
            onClick="javascript:adminCIncidents()">
      <s:property value="getText('lbl.main.buttonCincs')" /></button>
      
    <br><br><br>
    <button id="buttonMessages" class="ui-button ui-widget ui-corner-all bigButton"
            onClick="javascript:adminMessages()">
      <s:property value="getText('lbl.main.buttonMsgs')" /></button>
      
  </div>

<!--
  <div style="display: none">
    <s:a action="manageUsers" namespace="/service" id="linkManageUsers">
       <s:property value="getText('lbl.main.butonIncident')" /></s:a>
    <br>
    <s:a action="manageMessages" namespace="/service" id="linkManageMsgs">
       <s:property value="getText('lbl.main.butonOrder')" /></s:a>
  </div>
-->
  <br><br>
  </div>

  <SCRIPT TYPE="text/javascript">

    $("#buttonUsers").button({

      text: true

    }).click( function ( event ) {

      event.preventDefault();
    });

    $("#buttonMessages").button({

      text: true

    }).click( function ( event ) {

      event.preventDefault();
    });

    $("#buttonCIncidents").button({

      text: true

    }).click( function ( event ) {

      event.preventDefault();
    });

    function adminUsers() {

      this.location.href = '${pageContext.request.contextPath}/service/listUsers.xhtm';
    }

    function adminMessages() {

      this.location.href = '${pageContext.request.contextPath}/service/handleMessage.xhtm';
    }
    
    function adminCIncidents() {

      this.location.href = '${pageContext.request.contextPath}/service/handleCIncidents.xhtm';
    }    
  </SCRIPT>

<%
  session.removeAttribute( IGlobalConstants.SESS_ERROR_MSG );
%>