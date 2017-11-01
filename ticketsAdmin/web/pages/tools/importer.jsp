<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ page import="mx.com.nttdata.beans.CriticalIncident" %>
<%@ page import="mx.com.nttdata.util.IGlobalConstants" %>
<%@ page import="mx.com.nttdata.util.DateUtils" %>
<%@ page import="mx.com.nttdata.util.IncidentStatus" %>
<%@ page import="mx.com.nttdata.util.TicketUtils" %>

<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set var="ix" value="0" />

<div align="center">
  <b><s:property value="getText('importer.page.title')" /></b>
  <br clear="all">
  <br>

  <!-- s:form id="listForm" name="listForm" namespace="/service" method="post" theme="simple" -->
  <!-- form id="listForm" name="listForm" method="post" action="${pageContext.request.contextPath}/service/importer.xhtm" -->
  <s:form id="listForm" name="listForm" namespace="/service" method="post" theme="simple">

  <table id="recordListTable" widht="920" class="listTable ui-corner-bottom">
    <thead>
      <tr>
        <th width="16">&nbsp;</th>
        <th width="44">
            <a href="#" title="<s:property value="getText('importer.tool.selectAll')" />" onClick="javascript:checkAll()">
              <img src="${pageContext.request.contextPath}/img/checkedAll.png"
                   alt="<s:property value="getText('importer.tool.selectAll')" />"
                   border="0" width="16"  height="16" /></a>
            <a href="#" title="<s:property value="getText('importer.tool.selectNone')" />" onClick="javascript:checkNone()">
              <img src="${pageContext.request.contextPath}/img/checkedNone.png"
                   alt="<s:property value="getText('importer.tool.selectNone')" />"
                   border="0" width="16"  height="16" /></a>
        </th>
        <th width="20%"><s:property value="getText('lbl.cincidents.incident')" /></th>
        <th width="40%"><s:property value="getText('lbl.cincidents.title')" /></th>
        <th width="12%"><s:property value="getText('lbl.cincidents.descrip')" /></th>
        <th width="16%"><s:property value="getText('lbl.cincidents.created')" /></th>
        <th width="16">&nbsp;</th>
      </tr>
    </thead>
    <tbody>

  <s:iterator value="#session.importList" var="incidentBean">

    <s:set var="className"    value="%{'gray'}" />
    <s:if test="#ix == 0 || ( #ix % 2 ) == 0">
      <s:set name="className" value="%{'white'}" />
    </s:if>

      <tr>
        <td width="16" height="32" class="${className}">&nbsp;</td>
        <td width="44" class="${className}Icon" align="center" valign="middle">
          <input type="checkbox" name="incidents" id="incidents" value="<s:property value="#incidentBean.remedyID" />" />
        </td>
        <td class="${className}" width="20%" height="32" style="font-size: smaller"><s:property value="#incidentBean.remedyID" /></td>
        <td class="${className}" width="40%" height="32" style="font-size: smaller"><s:property value="#incidentBean.title" /></td>
        <td class="${className}Center" width="12%" height="32" style="font-size: smaller" align="center" valign="middle">
          <input type="hidden" name="notes_${ix}" value="<s:property value="#incidentBean.notes" />" />
          <a href="#" id="link_${ix}" title="<s:property value="#incidentBean.notes" />">
            <img src="${pageContext.request.contextPath}/img/globe.png" alt="Ver detalles" border="0" width="22" height="22" /></a>
        </td>
        <td class="${className}" height="32" width="16%" style="font-size: smaller">
          <s:property value="#incidentBean.creationTimestamp" />
        </td>
        <td class="${className}" width="16" height="32">&nbsp;</td>
      </tr>
    <s:set name="ix" value="%{#ix + 1}"/>

  </s:iterator>

    </tbody>
  </table>
  <input type="hidden" id="totalRecords" name="totalRecords" value="${ix}" />

  </s:form>

  <!-- los los botones -->

  <br><br>

  <table width="920">
  <tr>
    <td align="right">
      <button id="buttonCancel" class="ui-button ui-widget ui-corner-all formButton"
              onClick="javascript:goBack()">
        <span class="ui-icon iconReset"></span>
        &nbsp;
        <s:property value="getText('importer.button.back')" />
      </button>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <button id="buttonSave" class="ui-button ui-widget ui-corner-all formButton">
        <span class="ui-icon iconContinue"></span>
        &nbsp;
        <s:property value="getText('importer.button.continue')" />
      </button>
    </td>
    <td width="34">&nbsp;</td>
  </tr>
  </table>

</div>

<script type="text/javascript">
  var msgNoInc = '<s:property value="getText('list.err.noSelected')" escapeHtml="false" />';

  function checkAll() {

    $("input:checkbox").prop('checked', true );
  }

  function checkNone() {

    $("input:checkbox").prop('checked', false );
  }

  function goBack() {

    this.location.href = '${pageContext.request.contextPath}/service/cIncidents.xhtm';
  }

  function doPost() {

    var cnt = $("#listForm input:checkbox:checked").length;
    if ( cnt === 0 ) {
       alert( msgNoInc );
       return;
    }
    document.forms['listForm'].submit();
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

  for ( var cnt = 0; cnt < ${ix}; cnt++ ) {

      linkName = '#link_' + cnt;
      $( linkName ).tooltip();
  }

</script>

<%
  session.removeAttribute( IGlobalConstants.SESS_ERROR_MSG );
%>
