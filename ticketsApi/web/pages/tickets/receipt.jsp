<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page import="mx.com.nttdata.util.IGlobalConstants" %>
<s:set var="tckType" value="%{ticketType}" />

  <br clear="all">
  <br clear="all">
  <br clear="all">
  <br clear="all">

  <div align="center">
  <s:hidden name="ticketType" id="ticketType" value="%{ticketType}" />
  <s:hidden name="tckType"    id="tckType"    value="%{#tckType}" />
  <s:hidden name="remedyID"   id="remedyID"   value="%{remedyID}" />

    <h3>
      <s:property value="getText('lbl.receipt.remedyID')" /> <s:property value="%{remedyID}" />
    </h3>

    <br clear="all">
    <br clear="all">
    <br clear="all">
    <br clear="all">

    <button id="goBackButton" class="ui-button ui-widget ui-corner-all" onClick="goBack()">
      <span class="ui-icon iconContinue"></span>         
      &nbsp;
      <s:property value="getText('button.continue.label')" /></button>

  </div>

  <script TYPE="text/javascript">
    $("#goBackButton").button({
          text: true
        }).click( function ( event ) {

      event.preventDefault();
      goBack();
    });

    function goBack() {

      this.location.href = "${pageContext.request.contextPath}/service/home.xhtm";
    }
  </script>

