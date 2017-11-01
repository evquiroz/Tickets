<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ page import="mx.com.nttdata.beans.User" %>
<%@ page import="mx.com.nttdata.beans.UserLevel" %>
<%@ page import="mx.com.nttdata.beans.UserStatus" %>
<%@ page import="mx.com.nttdata.util.IGlobalConstants" %>
<%@ page import="mx.com.nttdata.util.TicketUtils" %>

<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set var="ix"   value="0" />
<s:set var="lvl"  />
<s:set var="stID" />

<s:set var="editTitle"><s:property value="getText('toolbar.edit.label')" /></s:set>
<s:set var="deleteTitle"><s:property value="getText('toolbar.delete.label')" /></s:set>
<script type="text/javascript">
  var baseUrl   = '<s:url forceAddSchemeHostAndPort="true" includeParams="none"/>';
  var urlCreate = baseUrl.replace( 'manageUsers', 'handleUser' ) + '?ac=1';
  var urlUpdate = baseUrl.replace( 'manageUsers', 'handleUser' ) + '?ac=2&id=';
  var urlDelete = baseUrl.replace( 'manageUsers', 'handleUser' ) + '?ac=3&id=';
</script>

<div align="center">

  <br>
  <span class="fieldError"><s:property value="#session.sessionErrorMsg" /></span>
  <br>

  <table widht="920">
  <tr>
    <td width="40">&nbsp;</td>
    <td align="center" valign="middle" width="700">
      <span id="infoMessage"></span>
    </td>
    <td width="40">&nbsp;</td>
    <td align="right" valign="middle" width="140" >
      <button id="buttonAddUser" class="ui-button ui-widget ui-corner-all formButton"
              onClick="javascript:addNewUser()">
        <span class="ui-icon iconAddRecord"></span>
        <s:property value="getText('toolbar.add.label')" />
      </button>
    </td>
  </tr>
  </table>

  <br><br>

  <table id="recordHeaderTable" widht="920">
  <tr>
    <td id="recordHeader" align="center" height="32" widht="920">
      <div align="center" id="divHeader" class="ui-widget-header ui-corner-tl ui-corner-tr jquiTableHeader" style="height: 32px; width: 920px"><s:property value="getText('users.title')" /></div>
    </td>
  </tr>
  </table>

  <table id="recordListTable" widht="920" class="listTable ui-corner-bottom">
    <thead>
      <tr>
        <th width="16">&nbsp;</th>
        <th width="25%"><s:property value="getText('users.table.login')" /></th>
        <th width="30%"><s:property value="getText('users.table.mail')" /></th>
        <th width="15%"><s:property value="getText('users.table.level')" /></th>
        <th width="10%"><s:property value="getText('users.table.status')" /></th>
        <th width="16">&nbsp;</th>
        <th width="40">&nbsp;</th>
        <th width="16">&nbsp;</th>
        <th width="40">&nbsp;</th>
        <th width="16">&nbsp;</th>
      </tr>
    </thead>
    <tbody>

  <s:iterator value="#session.userlist" var="userbean">

    <s:set var="className" value="%{'gray'}" />
    <s:if test="#ix == 0 || ( #ix % 2 ) == 0">
      <s:set name="className" value="%{'white'}" />
    </s:if>
    <s:set var="uuid"><s:property value="#userbean.loginName" /></s:set>
    <s:set var="lvl"><s:property  value="#userbean.level" /></s:set>
    <s:set var="stID"><s:property value="#userbean.status" /></s:set>

      <tr>
        <td width="16" class="${className}">
         <input type="hidden" id="uuid_${ix}" value="${ TicketUtils.cloackData( uuid )}" />
        </td>
        <td class="${className}">
          <a href="#" onClick="javascript:updateUser( ${ix} )">
            <s:property value="#userbean.loginName" /></a>
        </td>
        <td class="${className}"><s:property value="#userbean.mail" /></td>
        <td class="${className}Center">${ UserLevel.getUserLevelName( lvl )}</td>
        <td class="${className}Center">${ UserStatus.getStatusName( stID )}</td>
        <td width="16" class="${className}">&nbsp;</td>
        <td class="${className}Icon" align="center" valign="middle" width="40">
          <a href="#" onClick="javascript:updateUser( ${ix} )" title="${editTitle}">
            <img src="${pageContext.request.contextPath}/img/color_line.png" alt="${editTitle}" width="24" height="24" /></a>
        </td>
        <td width="16" class="${className}">&nbsp;</td>
        <td class="${className}Icon" align="center" valign="middle" width="40">
          <a href="#" onClick="javascript:deleteUser( ${ix} )" title="${deleteTitle}">
            <img src="${pageContext.request.contextPath}/img/edittrash.png" alt="${deleteTitle}" width="24" height="24" /></a>
        </td>
        <td width="16" class="${className}">&nbsp;</td>
      </tr>
    <s:set name="ix" value="%{#ix+1}"/>

  </s:iterator>

    </tbody>
  </table>

</div>

<script type="text/javascript">

  $( "#buttonAddUser" ).button({
    text: true
  }).click( function ( event ) {

    event.preventDefault();
  });

  function addNewUser() {

    window.location = urlCreate;
  }

  function updateUser( id ) {

    var uuid = $( ('#uuid_' + id )).val();
    window.location = urlUpdate + uuid;
  }

  function deleteUser( id ) {

    var uuid = $( ('#uuid_' + id )).val();
    window.location = urlDelete + uuid;
  }

</script>

<%
  session.removeAttribute( IGlobalConstants.SESS_ERROR_MSG );
%>