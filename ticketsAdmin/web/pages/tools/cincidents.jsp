<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ page import="mx.com.nttdata.beans.CriticalIncident" %>
<%@ page import="mx.com.nttdata.util.IGlobalConstants" %>
<%@ page import="mx.com.nttdata.util.DateUtils" %>
<%@ page import="mx.com.nttdata.util.IncidentStatus" %>
<%@ page import="mx.com.nttdata.util.TicketUtils" %>

<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set var="ix"   value="0" />
<s:set var="incID" />
<s:set var="closeTitle"><s:property value="getText('toolbar.close.label')" /></s:set>
<s:set var="reopenTitle"><s:property value="getText('toolbar.reopen.label')" /></s:set>
<s:set var="deleteTitle"><s:property value="getText('toolbar.delete.label')" /></s:set>

<script type="text/javascript">
  var baseUrl   = '<s:url forceAddSchemeHostAndPort="true" includeParams="none"/>';
  var urlCreate = baseUrl.replace( 'cIncidents', 'newIncident' ) + '?ac=1';
  var urlClose  = baseUrl.replace( 'cIncidents', 'newIncident' ) + '?ac=5&id=';
  var urlDelete = baseUrl.replace( 'cIncidents', 'newIncident' ) + '?ac=3&id=';
</script>

<div align="center">

  <form name="listForm">
  <span class="fieldError"><s:property value="#session.sessionErrorMsg" /></span>
  <br>
  
  <table id="recordHeaderTable" widht="920">
  <tr>
    <td id="recordHeader" align="center" height="32" widht="920">
      <div align="center" id="divHeader" class="ui-widget-header ui-corner-tl ui-corner-tr jquiTableHeader" style="height: 32px; width: 920px"><s:property value="getText('cincidents.title')" /></div>
    </td>
  </tr>
  </table>
    
  <table id="recordListTable" widht="920" class="listTable ui-corner-bottom">
    <thead>
      <tr>
        <th width="16">&nbsp;</th>
        <th width="18%"><s:property value="getText('lbl.cincidents.incident')" /></th>
        <th width="30%"><s:property value="getText('lbl.cincidents.title')" /></th>
        <th width="10%"><s:property value="getText('lbl.cincidents.descrip')" /></th>
        <th width="10%"><s:property value="getText('lbl.cincidents.status')" /></th>
        <th width="18%">
          <s:property value="getText('lbl.cincidents.created')" /> <br>
          <s:property value="getText('lbl.cincidents.closed')" />
        </th>
        <th width="20" align="center" valign="middle">&nbsp;</th>
        <th width="20" align="center" valign="middle">&nbsp;</th>
        <th width="16">&nbsp;</th>
      </tr>
    </thead>
    <tbody>
      
  <s:iterator value="#session.incidentList" var="incidentBean">
    
    <s:set var="className"    value="%{'gray'}" />
    <s:if test="#ix == 0 || ( #ix % 2 ) == 0">
      <s:set name="className" value="%{'white'}" />
    </s:if>
    <s:set var="uuid"><s:property value="#incidentBean.incidentID" /></s:set>
    <s:set var="stID"><s:property value="#incidentBean.status" /></s:set>
    
      <tr>
        <td width="16" height="32" class="${className}">&nbsp;</td>
        <td class="${className}" width="18%" height="32" style="font-size: smaller"><s:property value="#incidentBean.remedyID" /></td>
        <td class="${className}" width="30%" height="32" style="font-size: smaller"><s:property value="#incidentBean.title" /></td>
        <td class="${className}Center" width="10%" height="32" style="font-size: smaller" align="center" valign="middle">
          <input type="hidden" name="notes_${ix}" value="<s:property value="#incidentBean.notes" />" />
          <a href="#" id="link_${ix}" title="<s:property value="#incidentBean.notes" />">
            <img src="${pageContext.request.contextPath}/img/globe.png" alt="Ver detalles" border="0" width="22" height="22" /></a>
        </td>
        <td class="${className}Center" height="32" width="10%" style="font-size: smaller"><s:property value="#incidentBean.statusName" /></td>
        <td class="${className}" height="32" width="18%" style="font-size: smaller" width="20%">
          <s:property value="#incidentBean.creationTimestamp" /> <br>
          <s:property value="#incidentBean.closeTimestamp"  />
        </td>
        <td class="${className}Icon" align="center" valign="middle" width="20">
          <input type="hidden" id="uuid_${ix}" value="${ TicketUtils.cloackData( uuid )}" />
          <s:if test='%{ #stID == "A" }' >
          <a href="#" onClick="javascript:closeIncident( ${ix}, 0 )" title="${closeTitle}">
            <img src="${pageContext.request.contextPath}/img/flag_red.png" alt="${closeTitle}" width="16" height="16" /></a>          
          </s:if>  
          <s:elseif  test='%{ #stID == "C" }'>
          <a href="#" onClick="javascript:closeIncident( ${ix}, 1 )" title="${reopenTitle}">
            <img src="${pageContext.request.contextPath}/img/flag_green.png" alt="${reopenTitle}" width="16" height="16" /></a>          
          </s:elseif>
        </td>
        <td class="${className}Icon" align="center" valign="middle" width="20">
          <a href="#" onClick="javascript:deleteIncident( ${ix} )" title="${deleteTitle}">
            <img src="${pageContext.request.contextPath}/img/edittrash.png" alt="${deleteTitle}" width="24" height="24" /></a>
        </td>
        <td class="${className}" width="16" height="32">&nbsp;</td>
      </tr>
    <s:set name="ix" value="%{#ix + 1}"/>
    
  </s:iterator>
      
    </tbody>
  </table>
  <input type="hidden" id="totalRecords" name="totalRecords" value="${ix}" />

  <br>
        
  <table widht="920">
  <tr>
    <td width="16">&nbsp;</td>
    <td align="right" valign="middle" width="880" >
      <button id="buttonImport" class="ui-button ui-widget ui-corner-all formButton"
              onClick="javascript:importIncidents()">
        <span class="ui-icon iconImportRecord"></span>
        <s:property value="getText('btn.cincidents.import')" />
      </button>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <button id="buttonCreate" class="ui-button ui-widget ui-corner-all formButton"
              onClick="javascript:addIncident()">
        <span class="ui-icon iconAddRecord"></span>
        <s:property value="getText('btn.cincidents.add')" />
      </button>
      &nbsp;&nbsp;
    </td>
    <td width="16">&nbsp;</td>
  </tr>
  </table>

  <br><br>
  </form>     
  
</div>

  <SCRIPT TYPE="text/javascript">
    
    $("#buttonImport").button({

      text: true

    }).click( function ( event ) {

      event.preventDefault();
    });

    $("#buttonCreate").button({

      text: true

    }).click( function ( event ) {

      event.preventDefault();
    });
  
    
    var cntCritical = <s:property value="getText('ss.cnt.critical')" />;    
    var linkName;
    for ( var cnt = 0; cnt < ${ix}; cnt++ ) {
        
        linkName = '#link_' + cnt;
        $( linkName ).tooltip();
    }

    function addIncident() {

      this.location.href = urlCreate;
    }

    function deleteIncident( id ) {

      var uuid = $( ('#uuid_' + id )).val();
      window.location = urlDelete + uuid;
    }

    function closeIncident( id, s ) {
  
      var uuid = $( ('#uuid_' + id )).val();
      var loc  = urlClose + uuid + '&s=' + s;
      // alert( "Procesing loc: " + loc);
      window.location = loc;
    }

    function importIncidents() {

      this.location.href = "${pageContext.request.contextPath}/service/importIncidents.xhtm";
    }    
  </SCRIPT>

<%
  session.removeAttribute( IGlobalConstants.SESS_ERROR_MSG );
%>
