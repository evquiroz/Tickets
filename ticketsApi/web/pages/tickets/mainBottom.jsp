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
<s:set var='loginName' value="#session.appLoginName" />

<script type="text/javascript">
  var baseUrl   = '<s:url forceAddSchemeHostAndPort="true" includeParams="none"/>';
  var urlCreate = baseUrl.replace( 'home', 'newDerived' ) + '?parID=';
</script>

<!-- Main Top -->

  <table width="100%">
  <tr>
    <td style="background-color: #F1F1F1; color: #426CAA; padding-right: 4px; padding-top: 24px; vertical-align: top; width: 170px">

      <div align="center">

        <b><s:property value="getText('menu.left.chat')" /></b>
        <br><br>

        <!-- BoldChat Live Chat Button HTML v5.00 (Type=Web,ChatButton=Gentera Chat Button,Website=- None -) -->
        <!-- div style="text-align: center; white-space: nowrap;" -->
        <div id="chatArea" style="ui-corner-all">
          <script type="text/javascript" src="${pageContext.request.contextPath}/js/livechat.js"></script>
        </div>
        <!-- /BoldChat Live Chat Button HTML v5.00 -->

        <br>
        <hr size="4">
        <br>

        <a href="<s:property value="getText('lbl.autoayuda.link')" />" target="_blank">
          <s:property value="getText('lbl.autoayuda.title')" /></a>

        <br><br>
<!--
        <a href="<s:property value="getText('lbl.wiki.link')" />" target="_blank">
          <s:property value="getText('lbl.wiki.title')" /></a>
-->
        <a href="<s:property value="getText('lbl.resetpwd.link')" />" target="_blank">
          <s:property value="getText('lbl.resetpwd.title')" /></a>

        <br><br>
        
      </div>

    </td>
    <td width="26" style="background-color: white">&nbsp;</td>
    <td width="788" align="center" valign="top" style="min-height: 506px; height: 506px">

      <br><br>

      <form name="listForm">
      <span class="fieldError"><s:property value="#session.sessionErrorMsg" /></span>
      <br>

      <table id="recordHeaderTable" widht="720">
      <tr>
        <td id="recordHeader" align="center" height="32" widht="780">
          <div align="center" id="divHeader" class="ui-widget-header ui-corner-tl ui-corner-tr jquiTableHeader" style="height: 32px; width: 920px"><s:property value="getText('cincidents.title')" /></div>
        </td>
      </tr>
      </table>

<div align="center" style="display: inline">
      <table id="recordListTable" widht="720" class="listTable ui-corner-bottom">
        <thead>
          <tr>
            <th width="14%"><s:property value="getText('lbl.cincidents.incident')" /></th>
            <th width="36%"><s:property value="getText('lbl.cincidents.title')" /></th>
            <th width="104"><s:property value="getText('lbl.cincidents.descrip')" /></th>
            <th width="120">
              <s:property value="getText('lbl.cincidents.created')" />
            </th>
            <th width="86" align="center" valign="middle">&nbsp;</th>
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
            <td class="${className}" width="14%" height="32" style="font-size: smaller"><s:property value="#incidentBean.remedyID" /></td>
            <td class="${className}" width="36%" height="32" style="font-size: smaller"><s:property value="#incidentBean.title" /></td>
            <td class="${className}Center" width="104" height="32" style="font-size: smaller" align="center" valign="middle">
              <input type="hidden" name="notes_${ix}" value="<s:property value="#incidentBean.notes" />" />
              <a href="#" id="link_${ix}" title="<s:property value="#incidentBean.notes" />">
                <img src="${pageContext.request.contextPath}/img/globe.png" alt="Ver detalles" border="0" width="22" height="22" /></a>
            </td>
            <td class="${className}Center" height="32" width="120" style="font-size: smaller">
              <s:property value="#incidentBean.creationTimestamp" />
            </td>
            <td class="${className}Icon" align="center" valign="middle" width="86">
              <input type="hidden" id="uuid_${ix}" value="${ TicketUtils.cloackData( uuid )}" xx="${loginName}" yy="${session.appLoginName}" />
              <s:if test="#session.appLoginName != null">
                <a href="#" onClick="javascript:doDerivedIncident( ${ix} )" title="${derivedTitle}">
                  <img src="${pageContext.request.contextPath}/img/nuevoIncidente.gif" alt="${derivedTitle}" width="78" height="24" /></a>
              </s:if>
            </td>
          </tr>
        <s:set name="ix" value="%{#ix + 1}"/>

      </s:iterator>

        </tbody>
      </table>
      <input type="hidden" id="totalRecords" name="totalRecords" value="${ix}" />

      <br><br>
      </form>
</div>

    </td>
    <td width="26" style="background-color: white">&nbsp;</td>
<!--    
    <td style="background-color: #5D6A72; color: #FFFFFF; padding-right: 4px; padding-top: 24px; vertical-align: top; width: 190px">
-->
    <td style="background-color: #F1F1F1; color: #426CAA; padding-right: 4px; padding-top: 24px; vertical-align: top; width: 170px">

      <s:if test="#session.appLoginName != null">

        <div align="center">

<!--          
          <b><s:property value="getText('menu.left.soporte')" /></b>
          <br><br>

         <button id="createIncident" class="ui-button ui-widget ui-corner-all" style="font-size: smaller" onClick="javascript:doCreateWorkOrder()">
            <s:property value="getText('lbl.main.buttonIncident')" /></button>

          <br><br>

          <button id="createWorkOrder" class="ui-button ui-widget ui-corner-all" style="font-size: smaller"  onClick="javascript:doCreateWorkOrder()">
            <s:property value="getText('lbl.main.buttonOrder')" /></button>
-->
      </s:if>
      <s:else>
        <div align="center">  
          <b><s:property value="getText('lbl.link.askLogin')" /></b><br>         
          <a href="${pageContext.request.contextPath}/service/login.xhtm" class="linkColumn">
            <s:property value="getText('lbl.link.askLogin2')" /></a>  
        </div>  
      </s:else>    

      </div>

    </td>
  </tr>

  </table>


  <SCRIPT TYPE="text/javascript">

    var linkName;
    for ( var cnt = 0; cnt < ${ix}; cnt++ ) {

        linkName = '#link_' + cnt;
        $( linkName ).tooltip();
    }

    $("#createIncident").button({
          text: true
        }).click( function ( event ) {

          event.preventDefault();
    });

    $("#createWorkOrder").button({
          text: true
        }).click( function ( event ) {

          event.preventDefault();
    });

    $("#createDerived").button({
          text: true
        }).click( function ( event ) {

          event.preventDefault();
    });


    function doDerivedIncident( id ) {

      var uuid = $( ('#uuid_' + id )).val();
      this.location.href = urlCreate + uuid;
    }

    function doCreateIncident() {

      this.location.href = "${pageContext.request.contextPath}/service/newIncident.xhtm";
    }

    function doCreateWorkOrder() {

      this.location.href = "${pageContext.request.contextPath}/service/newWorkOrder.xhtm";
    }

  </SCRIPT>
