<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page import="mx.com.nttdata.service.ParametersService" %>

<jsp:useBean id="svcParams" class="mx.com.nttdata.service.ParametersService" scope="session" />

<s:set var="tckSuppGrp"  value="%{#session.svcParams.params.incidentDefaults.supportGroup}" />  
<s:set var="tckCat01"    value="%{#session.svcParams.params.incidentDefaults.categoryLevel01}" />
<s:set var="tckCat02"    value="%{#session.svcParams.params.incidentDefaults.categoryLevel02}" />
<s:set var="tckCat03"    value="%{#session.svcParams.params.incidentDefaults.categoryLevel03}" />
<s:set var="tckProd01"   value="%{#session.svcParams.params.incidentDefaults.productLevel01}" />
<s:set var="tckProd02"   value="%{#session.svcParams.params.incidentDefaults.productLevel02}" />
<s:set var="tckProd03"   value="%{#session.svcParams.params.incidentDefaults.productLevel03}" />

<script type="text/javascript">  
  
  function requireBrowserSupport() { 
    
    moz = navigator.userAgent.search("Firefox") > -1;
    ie  = navigator.userAgent.search("MSIE") > -1;
    return moz || ie;
  }
  
  if ( requireBrowserSupport()) { 
     webshims.setOptions( 'waitReady', false );
     webshims.setOptions( 'forms-ext', {types: 'date'} );
     webshims.polyfill( 'forms forms-ext' );    
  }

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datetools.js"></script>

<s:set var="cDate" value="%{#session.ciBean.creationFormatedDate" />
                            
<div align="center">

  <s:form id="incidentForm" name="incidentForm" namespace="/service" method="post" theme="simple">    
  <input type="hidden" name="actionID" value="4" />
  
  <table id="recordHeaderTable" widht="920">
  <tr>
    <td id="recordHeader" align="center" height="32" widht="920">
      <div align="center" id="divHeader" class="ui-widget-header ui-corner-tl ui-corner-tr jquiTableHeader" style="height: 32px; width: 920px">
        <s:property value="getText('cincidents.form.title')" />
      </div>
    </td>
  </tr>
  </table>

  <table class="criticalForm ui-corner-all" widht="920" class="listTable ui-corner-bottom">
  <tr>
    <td></td>
    <td>&nbsp;</td>
    <td></td>
  </tr>

  <!-- Numero de incidente Remedy -->
  <tr>
    <td class="formLeftColumn">
      <span class="fieldTitle">
        <s:property value="getText('ticket.form.incidentID')" />
      </span>
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="remedyID" name="remedyID" maxlength="96" size="40" 
                   cssClass="textField" cssStyle="text-transform: uppercase" />
    </td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td>
      <span class="fieldError">
        <s:property value="incidentFieldError" />
      </span>
    </td>
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
      <s:textfield id="title" name="title" maxlength="80" size="72" cssClass="textField" />
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

  <!--  Impacto - Incidente -->
  <tr>
    <td class="formLeftColumn" height="34">
      <span class="fieldTitle">
        <s:property value="getText('ticket.form.impact')" />*
      </span>    
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <select name="impact" id="impact">
      <s:iterator value="#session.impactMap">
        <option value="${key}"><s:property value="value" /></option>
      </s:iterator>  
      </select>
    </td>
  </tr>

  <!--  Grupo asignado - Incidente -->
  <tr>
    <td class="formLeftColumn" height="30">
      <span class="fieldTitle">
        <s:property value="getText('ticket.form.assignedGroup')" />*
      </span>      
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="assignedGroup" name="assignedGroup" value="%{tckSuppGrp}" maxlength="80" size="44" cssClass="textField" />
    </td>
  </tr>

  <!-- Categoria -->
  <tr>
    <td class="formLeftColumn" height="30">
      <s:property value="getText('ticket.form.category')" />*
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="categoryLevel01" name="categoryLevel01" value="%{tckCat01}" maxlength="60" size="22" cssClass="textField" />
      &nbsp;
      <s:textfield id="categoryLevel02" name="categoryLevel02" value="%{tckCat02}" maxlength="60" size="22" cssClass="textField" />
      &nbsp;
      <s:textfield id="categoryLevel03" name="categoryLevel03" value="%{tckCat03}" maxlength="60" size="22" cssClass="textField" />
    </td>
  </tr>

  <!-- Productos -->
  <tr>
    <td class="formLeftColumn" height="30">
      <span class="fieldTitle">
        <s:property value="getText('ticket.form.product')" />*
      </span>  
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <s:textfield id="productLevel01" name="productLevel01" value="%{tckProd01}" maxlength="60" size="22" cssClass="textField" />
      &nbsp;
      <s:textfield id="productLevel02" name="productLevel02" value="%{tckProd02}" maxlength="60" size="22" cssClass="textField" />
      &nbsp;
      <s:textfield id="productLevel03" name="productLevel03" value="%{tckProd03}" maxlength="60" size="22" cssClass="textField" />
    </td>
  </tr>
  
  <!-- Fecha de creacion -->
  <tr>
    <td class="formLeftColumn" height="30">
      <span class="fieldTitle">
        <s:property value="getText('ticket.form.createdOn')" />
      </span>
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <input type="date" id="creationDate" name="creationDate" value="<s:property value="%{#session.ciBean.creationFormatedDate}" />" 
              size="22" cssClass="textField" />
    </td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td>
      <span class="fieldError">
        <s:property value="createdFieldError" />
      </span>
    </td>
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
    <td width="120">&nbsp;</td>
  </tr>
  </table>

  </s:form>
    
</div>

<br clear="all"> 
<br clear="all"> 

<script type="text/javascript">
        
  $("input:text").each( function () { 
      
    var ename = this.name;
    var obj   = document.getElementById( ename );
      
    obj.className = "ui-widget ui-widget-content ui-corner-all";
  });
  $("#notes").className = "ui-widget ui-widget-content ui-corner-all";  
  $("#impact").selectmenu();  
  $("#creationDate").className = "ui-widget ui-widget-content ui-corner-all";  
  $("#remedyID").focus();


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

  function goBack() {

    this.location.href = "./service/handleCIncidents.xhtm";
  }

  function doPost() {

    var msgID     = '<s:property value="getText('fld.remedyID.required')" escapeHtml="false" />';
    var msgTitle  = '<s:property value="getText('fld.title.required')" escapeHtml="false" />';
    var msgNotes  = '<s:property value="getText('fld.notes.required')" escapeHtml="false" />';    
    var msgImpact = '<s:property value="getText('fld.impact.invalid')" escapeHtml="false" />';
    var msgGroup  = '<s:property value="getText('fld.group.invalid')" escapeHtml="false" />';
    var msgCat01  = '<s:property value="getText('fld.cat01.invalid')" escapeHtml="false" />';
    var msgCat02  = '<s:property value="getText('fld.cat02.invalid')" escapeHtml="false" />';
    var msgCat03  = '<s:property value="getText('fld.cat03.invalid')" escapeHtml="false" />';
    var msgProd01 = '<s:property value="getText('fld.Prod01.invalid')" escapeHtml="false" />';
    var msgProd02 = '<s:property value="getText('fld.Prod02.invalid')" escapeHtml="false" />';
    var msgProd03 = '<s:property value="getText('fld.Prod03.invalid')" escapeHtml="false" />';    
    var msgCDate  = '<s:property value="getText('fld.cdate.required')" escapeHtml="false" />';
    var msgIDate  = '<s:property value="getText('fld.cdate.invalid')" escapeHtml="false" />';
            
    var oForm     = document.forms['incidentForm'];
    var remedyID  = oForm.elements['remedyID'].value;
    var resumen   = oForm.elements['title'].value;
    var notas     = oForm.elements['notes'].value;
    var impact    = oForm.elements['impact'].value;
    var aGroup    = oForm.elements['assignedGroup'].value;
    var cat01     = oForm.elements['categoryLevel01'].value; 
    var cat02     = oForm.elements['categoryLevel02'].value;
    var cat03     = oForm.elements['categoryLevel03'].value;
    var prod01    = oForm.elements['productLevel01'].value;
    var prod02    = oForm.elements['productLevel02'].value;
    var prod03    = oForm.elements['productLevel03'].value;    
    var cdate     = oForm.elements['creationDate'].value;


    if ( !remedyID.match(/^.{6,80}$/)) {
       alert( msgID );
       oForm.elements['remedyID'].focus();
       return;
    }

    if ( !resumen.match(/^.{10,80}$/)) {
       alert( msgTitle );
       oForm.elements['title'].focus();
       return;
    }

    if ( notas.length < 10 ) {
       alert( msgNotes );
       oForm.elements['notes'].focus();
       return;
    }

    obj = $("#impact");
    val = $("#impact").val();

    if ( val.length === 0 ) {
       alert( msgImpact );
       obj.focus();
       return;
    }

    if ( !aGroup.match(/^.{4,80}$/)) {
       alert( msgGroup );
       oForm.elements['assignedGroup'].focus();
       return;
    }

    if ( !cat01.match(/^.{4,60}$/)) {
       alert( msgCat01 );
       oForm.elements['categoryLevel01'].focus();
       return;
    }

    if ( !cat02.match(/^.{4,60}$/)) {
       alert( msgCat02 );
       oForm.elements['categoryLevel02'].focus();
       return;
    }

    if ( !cat03.match(/^.{4,60}$/)) {
       alert( msgCat03 );
       oForm.elements['categoryLevel03'].focus();
       return;
    }

    if ( !prod01.match(/^.{4,60}$/)) {
       alert( msgProd01 );
       oForm.elements['productLevel01'].focus();
       return;
    }

    if ( !prod02.match(/^.{4,60}$/)) {
       alert( msgProd02 );
       oForm.elements['productLevel02'].focus();
       return;
    }

    if ( !prod03.match(/^.{4,60}$/)) {
       alert( msgProd03 );
       oForm.elements['productLevel03'].focus();
       return;
    }

    var dCode = isValidDate( cdate );
    if ( dCode < 0 ) {
       alert( dCode === -1 ? msgCDate : msgIDate );
       oForm.elements['creationDate'].focus();
       return;
    }
    oForm.submit();
  }
  
</script>
