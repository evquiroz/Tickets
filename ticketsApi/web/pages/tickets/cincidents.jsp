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
<s:set var="deleteTitle"><s:property value="getText('toolbar.delete.label')" /></s:set>

<script type="text/javascript">
  var baseUrl   = '<s:url forceAddSchemeHostAndPort="true" includeParams="none"/>';
  var urlCreate = baseUrl.replace( 'cIncidents', 'newDerived' ) + '?parID=';
</script>

<br clear="all" />

<div align="left">

  <table>
  <tr>
    <td widh="80">&nbsp;</td>
    <td align="center" valign="middle" width="40">
      <s:a action="home" namespace="/service">
        <img src="${pageContext.request.contextPath}/img/Home.png" alt="" width="24" height="24"></s:a>
    </td>  
    
    <td valign="middle">
      <s:a action="home" namespace="/service" cssClass="breadcumbs">
        <s:property value="getText('link.lbl.start')" /></s:a>
    </td>
  </tr>
  </table>
  <br clear="all" />
   
</div>

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
        <th width="12%">
          <s:property value="getText('lbl.cincidents.created')" />
        </th>
        <th width="20%" align="center" valign="middle">&nbsp;</th>
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
        <td class="${className}" height="32" width="18%" style="font-size: smaller" width="20%">
          <s:property value="#incidentBean.creationTimestamp" />
        </td>
        <td class="${className}Icon" align="center" valign="middle" width="20%">
          <input type="hidden" id="uuid_${ix}" value="${ TicketUtils.cloackData( uuid )}" />
          <s:if test='%{ #stID == "A" }' >
          <a href="#" onClick="javascript:deriveIncident( ${ix} )" title="${derivedTitle}">
            <img src="${pageContext.request.contextPath}/img/nuevoIncidente.gif" alt="${derivedTitle}" width="78" height="24" /></a>
          </s:if>  
        </td>
        <td class="${className}" width="16" height="32">&nbsp;</td>
      </tr>
    <s:set name="ix" value="%{#ix + 1}"/>
    
  </s:iterator>
      
    </tbody>
  </table>
  <input type="hidden" id="totalRecords" name="totalRecords" value="${ix}" />
      
  <br><br>
  </form>     
  
</div>

  <SCRIPT TYPE="text/javascript">
    
    var linkName;
    for ( var cnt = 0; cnt < ${ix}; cnt++ ) {
        
        linkName = '#link_' + cnt;
        $( linkName ).tooltip();
    }

    function deriveIncident( id ) {

      var uuid = $( ('#uuid_' + id )).val();
      this.location.href = urlCreate + uuid;
    }

  </SCRIPT>

<%
  session.removeAttribute( IGlobalConstants.SESS_ERROR_MSG );
%>
