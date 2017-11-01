<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page import="mx.com.nttdata.util.IGlobalConstants" %>

<!-- Main Top -->

  <br>
  <div align="center">

  <div class="formArea ui-corner-all">

    <blockquote style="text-align: left">
      <h3><s:property value="getText('lbl.main.welcome')" /></h3>
    </blockquote>
    <br>
    <button id="createIncident" class="ui-button ui-widget ui-corner-all bigButton" onClick="javascript:doCreateIncident()">
      <s:property value="getText('lbl.main.butonIncident')" /></button>
    <br><br><br>
    <button id="createWorkOrder" class="ui-button ui-widget ui-corner-all bigButton" onClick="javascript:doCreateWorkOrder()">
      <s:property value="getText('lbl.main.butonOrder')" /></button>
  </div>

  <div style="display: none">
    <s:a action="addIncident" namespace="/service" id="linkCreateIncident">
       <s:property value="getText('lbl.main.butonIncident')" /></s:a>
    <br>
    <s:a action="addWorkOrder" namespace="/service" id="linkCreateWorkOrder">
       <s:property value="getText('lbl.main.butonOrder')" /></s:a>
  </div>

  <br><br>
  </div>

  <SCRIPT TYPE="text/javascript">

    $("#createIncident").button({
          icons: {
          primary: "iconReset"
          },
          text: true
        }).click( function ( event ) {

          event.preventDefault();
    });

    $("#createIncident").button({
          icons: {
          primary: "iconCancel"
          },
          text: true
        }).click( function ( event ) {

          event.preventDefault();
    });

    function doCreateIncident() {

      this.location.href = "${pageContext.request.contextPath}/service/newIncident.xhtm";
    }

    function doCreateWorkOrder() {

      this.location.href = "${pageContext.request.contextPath}/service/newWorkOrder.xhtm";
    }

  </SCRIPT>
