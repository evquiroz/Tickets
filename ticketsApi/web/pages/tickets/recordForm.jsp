<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page import="mx.com.nttdata.service.ParametersService" %>

<jsp:useBean id="svcParams" class="mx.com.nttdata.service.ParametersService" scope="session" />

<s:if test="#ticketType == 1">
  <s:set var="formTitle"   value="getText('ticket.title.incident')" />
  <s:set var="actName"     value="'newIncident'" />
    
  <s:set var="remAction"   value="%{#session.svcParams.params.incidentDefaults.action}" />
  <s:set var="tckPriority" value="%{#session.svcParams.params.incidentDefaults.priority}" />
  <s:set var="tckStatus"   value="%{#session.svcParams.params.incidentDefaults.status}" />
  <s:set var="tckReason"   value="%{#session.svcParams.params.incidentDefaults.reason}" />
  <s:set var="tckLastName" value="%{#session.svcParams.params.incidentDefaults.lastName}" />
  <s:set var="tckPersonID" value="%{#session.svcParams.params.incidentDefaults.personID}" />
  <s:set var="tckSource"   value="%{#session.svcParams.params.incidentDefaults.source}" />
  <s:set var="tckSuppGrp"  value="%{#session.svcParams.params.incidentDefaults.supportGroup}" />  
  <s:set var="tckCat01"    value="%{#session.svcParams.params.incidentDefaults.categoryLevel01}" />
  <s:set var="tckCat02"    value="%{#session.svcParams.params.incidentDefaults.categoryLevel02}" />
  <s:set var="tckCat03"    value="%{#session.svcParams.params.incidentDefaults.categoryLevel03}" />
  <s:set var="tckProd01"   value="%{#session.svcParams.params.incidentDefaults.productLevel01}" />
  <s:set var="tckProd02"   value="%{#session.svcParams.params.incidentDefaults.productLevel02}" />
  <s:set var="tckProd03"   value="%{#session.svcParams.params.incidentDefaults.productLevel03}" />
</s:if>
<s:elseif test="#ticketType == 2">
  <s:set var="formTitle"   value="getText('ticket.title.workOrder')" />
  <s:set var="actName"     value="'newWorkOrder'" />
  
  <s:set var="remAction"   value="%{#session.svcParams.params.orderDefaults.action}" />
  <s:set var="tckPriority" value="%{#session.svcParams.params.orderDefaults.priority}" />
  <s:set var="tckStatus"   value="%{#session.svcParams.params.orderDefaults.status}" />
  <s:set var="tckReason"   value="%{#session.svcParams.params.orderDefaults.reason}" />
  <s:set var="tckLastName" value="%{#session.svcParams.params.orderDefaults.lastName}" />
  <s:set var="tckPersonID" value="%{#session.svcParams.params.orderDefaults.personID}" />
  <s:set var="tckSource"   value="%{#session.svcParams.params.orderDefaults.source}" />
  <s:set var="tckSuppGrp"  value="%{#session.svcParams.params.orderDefaults.supportGroup}" />
  <s:set var="tckCat01"    value="%{#session.svcParams.params.orderDefaults.categoryLevel01}" />
  <s:set var="tckCat02"    value="%{#session.svcParams.params.orderDefaults.categoryLevel02}" />
  <s:set var="tckCat03"    value="%{#session.svcParams.params.orderDefaults.categoryLevel03}" />
  <s:set var="tckProd01"   value="%{#session.svcParams.params.orderDefaults.productLevel01}" />
  <s:set var="tckProd02"   value="%{#session.svcParams.params.orderDefaults.productLevel02}" />
  <s:set var="tckProd03"   value="%{#session.svcParams.params.orderDefaults.productLevel03}" />
</s:elseif>

<s:form id="ticketForm" name="ticketForm" action="%{#actName}.xhtm" namespace="/service" method="post" theme="simple">

  <s:hidden name="ticketType"   id="ticketType"     value="%{#ticketType}" />
  <s:hidden name="companyName"  id="companyName"    value="%{#session.svcParams.params.companyName}" />
  <s:hidden name="customer"     id="customer"       value="%{#session.appLoginName}" />
  <s:hidden name="serviceType"  id="serviceType"    value="%{#session.svcParams.params.incidentDefaults.serviceType}" />
  <s:hidden name="urgency"      id="urgency"        value="%{#session.svcParams.params.incidentDefaults.urgency}" />
  <s:hidden name="priority"     id="priority"       value="%{tckPriority}" />
  <s:hidden name="lastName"     id="lastName"       value="%{tckLastName}" />
  <s:hidden name="personID"     id="personID"       value="%{tckPersonID}" />
  <s:hidden name="source"       id="source"         value="%{tckSource}" />
  <s:hidden name="remedyAction" id="remedyAction"   value="%{remAction}" />  
  
<s:if test="#ticketType == 1">    
  <s:hidden name="supportGroup" id="supportGroup"  value="%{tckSuppGrp}" />
  <s:hidden name="status"       id="status"        value="%{tckStatus}" />
  <s:hidden name="reason"       id="reason"        value="%{tckReason}" />
</s:if>  
  <div align="center">
  <br clear="all" />

  <table class="ticketForm ui-corner-all">
  <tr>
    <td colspan="3">
      <div align="center" class="ui-widget-header ui-corner-tl ui-corner-tr jquiTableHeader ticketFormTitle">
        ${formTitle}
      </div>
    </td>
  </tr>
  <tr>
    <td></td>
    <td>&nbsp;</td>
    <td></td>
  </tr>

  <!-- Resumen -->
  <tr>
    <td class="formLeftColumn">
      <span class="fieldTitle">
        <s:property value="getText('ticket.form.title')" />
      </span>
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="title" name="title" maxlength="80" size="80" cssClass="textField" />
    </td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td>
      <span class="fieldError">
        <s:property value="titleFieldError" />
      </span>
    </td>
  </tr>

  <!-- Notas -->
  <tr>
    <td class="formLeftColumn">
      <span class="fieldTitle">
        <s:property value="getText('ticket.form.notes')" />
      </span>
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textarea id="notes" name="notes" cols="80" rows="4" cssClass="textField" />
    </td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td>
      <span class="fieldError">
        <s:property value="notesFieldError" />
      </span>
    </td>
  </tr>

<s:if test="#ticketType == 1">

  <!--  Impacto - Incidencia -->
  <tr>
    <td class="formLeftColumnDisabled">
      <s:property value="getText('ticket.form.impact')" />
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="impact" name="impact" value="%{#session.svcParams.params.incidentDefaults.impact}" maxlength="80" size="40" cssClass="textField" readonly="true" />
    </td>
  </tr>

</s:if>

<s:if test="#ticketType == 2">

  <!--  Tipo de orden - Requisicion -->
  <tr>
    <td class="formLeftColumnDisabled">
      <s:property value="getText('ticket.form.orderType')" />
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="orderType" name="orderType" value="%{#session.svcParams.params.orderDefaults.orderType}" maxlength="64" size="32" cssClass="textField" readonly="true" />
    </td>
  </tr>

</s:if>

<s:if test="#ticketType == 1">

  <!--  Grupo asignado - Incidencia -->
  <tr>
    <td class="formLeftColumnDisabled">
      <s:property value="getText('ticket.form.assignedGroup')" />
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="assignedGroup" name="assignedGroup" value="%{#session.svcParams.params.incidentDefaults.group}" maxlength="80" size="40" cssClass="textField" readonly="true" />
    </td>
  </tr>

</s:if>

<s:if test="#ticketType == 2">

  <!--  Grupo de gestion - Requisicion -->
  <tr>
    <td class="formLeftColumnDisabled">
      <s:property value="getText('ticket.form.mngmtGroup')" />
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="mngmtGroup" name="mngmtGroup" value="%{#session.svcParams.params.orderDefaults.managementGroup}" maxlength="80" size="40" cssClass="textField" readonly="true" />
    </td>
  </tr>

  <!--  Grupo de soporte - Requisicion -->
  <tr>
    <td class="formLeftColumnDisabled">
      <s:property value="getText('ticket.form.suppGroup')" />
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="supportGroup" name="supportGroup" value="%{tckSuppGrp}" maxlength="80" size="40" cssClass="textField" readonly="true" />
    </td>
  </tr>

  <!--  Estado - Requisicion -->
  <tr>
    <td class="formLeftColumnDisabled">
      <s:property value="getText('ticket.form.status')" />
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="status" name="status" value="%{tckStatus}" maxlength="64" size="32" cssClass="textField" readonly="true" />
    </td>
  </tr>

  <!--  Motivo de estado - Requisicion -->
  <tr>
    <td class="formLeftColumnDisabled">
      <s:property value="getText('ticket.form.reason')" />
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="reason" name="reason" value="%{tckReason}" maxlength="64" size="32" cssClass="textField" readonly="true" />
    </td>
  </tr>

</s:if>

  <!-- Categoria -->
  <tr>
    <td class="formLeftColumnDisabled">
      <s:property value="getText('ticket.form.category')" />
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="categoryLevel01" name="categoryLevel01" value="%{tckCat01}" maxlength="96" size="26" cssClass="textField" readonly="true" />
      &nbsp;
      <s:textfield id="categoryLevel02" name="categoryLevel02" value="%{tckCat02}" maxlength="96" size="26" cssClass="textField" readonly="true" />
      &nbsp;
      <s:textfield id="categoryLevel03" name="categoryLevel03" value="%{tckCat03}" maxlength="96" size="26" cssClass="textField" readonly="true" />
    </td>
  </tr>

  <!-- Productos -->
  <tr>
    <td class="formLeftColumnDisabled">
      <s:property value="getText('ticket.form.product')" />
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="productLevel01" name="productLevel01" value="%{tckProd01}" maxlength="96" size="26" cssClass="textField" readonly="true" />
      &nbsp;
      <s:textfield id="productLevel02" name="productLevel02" value="%{tckProd02}" maxlength="96" size="26" cssClass="textField" readonly="true" />
      &nbsp;
      <s:textfield id="productLevel03" name="productLevel03" value="%{tckProd03}" maxlength="96" size="26" cssClass="textField" readonly="true" />
    </td>
  </tr>

  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>
</table>

<br>

<table class="formButtonsTable">
<tr>
  <td>
    <button id="buttonCancel" class="ui-button ui-widget ui-corner-all formButton"  onClick="javascript:goBack()">
      <span class="ui-icon iconCancel"></span>         
        &nbsp;
      <s:property value="getText('form.button.cancel')" /></button>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <button id="buttonSave" class="ui-button ui-widget ui-corner-all formButton">
      <span class="ui-icon iconSave"></span>         
      &nbsp;
      <s:property value="getText('form.button.save')" /></button>
  </td>
  <td width="34">&nbsp;</td>
</tr>
</table>

</div>

</s:form>

<br clear="all"> 
<br clear="all"> 

<script type="text/javascript">

  $( function() {
    $("input:text").each( function () { 
      
      var ename = this.name;
      var obj   = document.getElementById( ename );
      
      if ( ename === "title" )
         obj.className = "ui-widget ui-widget-content ui-corner-all";
      else 
         obj.className = "ui-widget ui-widget-content ui-corner-all disabledTexbox";
    });
    $("#title").focus();    
  });

  function goBack() {

    this.location.href = "${pageContext.request.contextPath}/service/home.xhtm";
  }

  function doPost() {

    var msgTitle = '<s:property value="getText('fld.title.required')" escapeHtml="false" />';
    var msgNotes = '<s:property value="getText('fld.notes.required')" escapeHtml="false" />';
    var oForm    = document.forms['ticketForm'];
    var resumen  = oForm.elements['title'].value;
    var notas    = oForm.elements['notes'].value;

    if ( !resumen.match(/^.{10,80}$/)) {
       alert( msgTitle );
       oForm.elements['title'].focus();
       return;
    }

    if ( !notas.match(/^.{24,255}$/)) {
       alert( msgNotes );
       oForm.elements['notes'].focus();
       return;
    }

    oForm.submit();
  }

  $("#buttonCancel").button({
    text: true
  }).click( function ( event ) {

    event.preventDefault();
    goBack();
  });

  $("#buttonSave").button({
    text: true
  }).click( function ( event ) {

    event.preventDefault();
    doPost();
  });
  $("#title").focus();    

</script>
