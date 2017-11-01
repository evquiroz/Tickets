<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>

<%@ page import="java.util.Map" %>
<%@ page import="mx.com.nttdata.beans.UserLevel" %>
<%@ page import="mx.com.nttdata.beans.UserStatus" %>
<%@ page import="mx.com.nttdata.util.IGlobalConstants" %>
<%@ page import="mx.com.nttdata.util.TicketUtils" %>

<%@ taglib prefix="s" uri="/struts-tags"%>

<%
  Map<Integer, String> mapLevelsJ = UserLevel.getLevelsList();
  Map<String, String>  mapStatusJ = UserStatus.getStatusList();

  session.setAttribute( "mapLevels", mapLevelsJ );
  session.setAttribute( "mapStatus", mapStatusJ );
%>

<s:set var="varActionID"><s:property value="#session.recordAction" /></s:set>
<s:set var="varBossLevel"><s:property value="#session.appLocalLvl" /></s:set>

<s:set var="varUserID"     value="%{#session.userBean.ID}" />
<s:set var="varUserName"   value="%{#session.userBean.loginName}" />
<s:set var="varUserMail"   value="%{#session.userBean.mail}" />
<s:set var="varUsrLevel"   value="%{#session.userBean.level}" />
<s:set var="varUserStatus" value="%{#session.userBean.status}" />

<s:set var="varUserNameFE"   value="%{#session.usrNameError}" />
<s:set var="varUserSecretFE" value="%{#session.usrSecretError}" />
<s:set var="varUserMailFE"   value="%{#session.usrMailError}" />
<s:set var="varUserLevelFE"  value="%{#session.usrLevelError}" />
<s:set var="varUserStatusFE" value="%{#session.usrStatusError}" />

<s:if test="#varActionID == 1">
  <s:set var="formTitle"   value="getText('user.form.createTitle')" />
  <s:set var="asterisk"    value="%{'* '}" />
</s:if>
<s:elseif test="#varActionID == 2">
  <s:set var="formTitle"   value="getText('user.form.updateTitle')" />
  <s:set var="asterisk"    value="'&nbsp;&nbsp;'" />
</s:elseif>

<div align="center">

  <div>
    <span class="fieldError"><s:property value="#session.sessionErrorMsg" /></span>
  </div>

  <form action="${pageContext.request.contextPath}/service/handleUser.xhtm" name="recordForm" id="recordForm" method="post">
  <s:hidden name="userActionID" id="userActionID" value="%{ #session.recordAction + 3}" />

  <table id="recordHeaderTable" widht="920">
  <tr>
    <td id="recordHeader" align="center" height="32" widht="920">
      <div align="center" id="divHeader" class="ui-widget-header ui-corner-tl ui-corner-tr jquiTableHeader" style="height: 32px; width: 920px">
        ${formTitle}
      </div>
    </td>
  </tr>
  </table>

  <table widht="920" class="recordTable">
  <tr>
    <td colspan="5">&nbsp;</td>
  </tr>

  <!-- Login Name -->
  <tr>
    <td width="40">&nbsp;</td>
    <s:if test="#varActionID == 1">
      <td width="240" class="formLeftColumn">
    </s:if>
    <s:else>
      <td width="240" class="formLeftColumnDisabled">
    </s:else>
      <span class="fieldTitle">
        <s:property value="getText('user.form.login')" />
      </span>
    </td>
    <td width="80" class="fromMiddleColumn">&nbsp;</td>
    <td width="520">
      <s:hidden id="userID" name="userID" value="%{#varUserID}" />
      <s:if test="#varActionID == 1">
        <s:textfield id="userName" name="userName" maxLength="24" size="36" value="%{#varUserName}" />
      </s:if>
      <s:else>
        <s:textfield id="userName" name="userName" maxLength="24" size="36" value="%{#varUserName}" readonly="true" />
      </s:else>
    </td>
    <td width="40">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
    <td class="inputError">${varUserNameFE}<s:property value="userNameFieldError" /></td>
    <td width="40">&nbsp;</td>
  </tr>

  <!-- Correo electronico -->

  <tr>
    <td width="40">&nbsp;</td>
    <td width="240" class="formLeftColumn">
      <span class="fieldTitle"><s:property value="getText('user.form.email')" /></span>
    </td>
    <td width="80" class="fromMiddleColumn">&nbsp;</td>
    <td width="520">
      <s:textfield id="userMail" name="userMail" maxLength="128" size="64" value="%{#varUserMail}" />
    </td>
    <td width="40">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
    <td class="inputError">${varUserMailFE} <s:property value="#session.userMailFieldError" /></td>
    <td width="40">&nbsp;</td>
  </tr>

  <!-- Password -->

  <tr>
    <td width="40">&nbsp;</td>
    <td width="240" class="formLeftColumn">
      <span class="fieldTitle">
        <s:property value="getText('user.form.secret')" /><s:property value="asterisk" escapeHtml="false" />
      </span>
    </td>
    <td width="80" class="fromMiddleColumn">&nbsp;</td>
    <td width="520">
      <input type="password" id="userSecret" name="userSecret" maxlength="16" size="36" />
    </td>
    <td width="40">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
    <td class="inputError">${varUserSecretFE}</td>
    <td width="40">&nbsp;</td>
  </tr>

  <!-- Confirmacion -->

  <tr>
    <td width="40">&nbsp;</td>
    <td width="240" class="formLeftColumn">
      <span class="fieldTitle">
        <s:property value="getText('user.form.confirm')" /><s:property value="asterisk" escapeHtml="false" />
      </span>
    </td>
    <td width="80" class="fromMiddleColumn">&nbsp;</td>
    <td width="520">
      <input type="password" id="userConfirm" name="userConfirm" maxlength="16" size="36" />
    </td>
    <td width="40">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5">&nbsp;</td>
  </tr>

  <!-- Nivel del usuario -->
  <tr>
    <td width="40">&nbsp;</td>
    <td width="240" class="formLeftColumn">
      <span class="fieldTitle">
        <s:property value="getText('user.form.level')" />
      </span>
    </td>
    <td width="80" class="fromMiddleColumn">&nbsp;</td>
    <td width="520">
      <select name="userLevel" id="userLevel">
        <s:iterator value="#session.mapLevels">

          <s:set var="isSelectedLvl" value="%{'  '}" />
          <s:if test="%{ key == #varUsrLevel }" >
            <s:set var="isSelectedLvl" value="%{' selected'}" />
          </s:if>
          <s:if test="%{ key gte #varBossLevel }" >
            <option value="${key}" ${isSelectedLvl}><s:property value="value" /></option>
          </s:if>

        </s:iterator>
      </select>
    </td>
    <td width="40">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
    <td class="inputError">${varUserLevelFE}</td>
    <td width="40">&nbsp;</td>
  </tr>

  <!-- Estado del usuario -->
  <tr>
    <td width="40">&nbsp;</td>
    <td width="240" class="formLeftColumn">
      <s:if test="#varActionID == 1">
      <span class="disabledLabel">
        <s:property value="getText('user.form.statusI')" />
      </span>
      </s:if>
      <s:elseif test="#varActionID == 2">
      <span class="fieldTitle">
        <s:property value="getText('user.form.statusA')" />
      </span>
      </s:elseif>
    </td>
    <td width="80" class="fromMiddleColumn">&nbsp;</td>
    <td width="520">
      <s:if test="#varActionID == 1">
        <input type="hidden" id="userStatus" name="userStatus" value="${varUserStatus}" />
        <input type="text" id="statusName" name="levelName" value="${ UserStatus.getStatusName( varUserStatus )}" readonly="readonly"
               class="ui-widget ui-widget-content ui-corner-all disabledTexbox" />
      </s:if>
      <s:elseif test="#varActionID == 2">

      <select name="userStatus" id="userStatus">
        <s:iterator value="#session.mapStatus">
          <s:set var="isSelected" value="%{'  '}" />
          <s:if test="%{ key eq #varUserStatus }" >
            <s:set var="isSelected" value="%{' selected'}" />
          </s:if>
          <option value="${key}" ${isSelected}><s:property value="value" /></option>
        </s:iterator>
      </select>
      </s:elseif>
    </td>
    <td width="40">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
    <td class="inputError">${varUserStatusFE}</td>
    <td width="40">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5">&nbsp;</td>
  </tr>

  </table>

  <!-- los los botones -->

  <br><br>

  <table width="920">
  <tr>
    <td align="right">
      <button id="buttonCancel" class="ui-button ui-widget ui-corner-all formButton"
              onClick="javascript:goBack()">
        <span class="ui-icon iconCancel"></span>
        &nbsp;
        <s:property value="getText('user.button.cancel')" />
      </button>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <button id="buttonSave" class="ui-button ui-widget ui-corner-all formButton">
        <span class="ui-icon iconSave"></span>
        &nbsp;
        <s:property value="getText('user.button.save')" />
      </button>
    </td>
    <td width="34">&nbsp;</td>
  </tr>
  </table>

</div>

<script type="text/javascript">
  var recordAction     = <s:property value="#session.recordAction" />;
  var asterisk         = '${asterisk}';
  var cssTitleOn       = 'fieldTitle';
  var cssTitleOff      = 'disabledLabel';

  var msgLoginEmpty    = '<s:property value="getText('user.form.login.empty')" escapeHtml="false" escapeJavaScript="true" />';
  var msgLogininvalid  = '<s:property value="getText('user.form.login.invalid')" escapeHtml="false" escapeJavaScript="true" />';
  var msgLoginRepeated = '<s:property value="getText('user.form.login.repeated')" escapeHtml="false" escapeJavaScript="true" />';
  var msgMailEmpty     = '<s:property value="getText('user.form.mail.empty')" escapeHtml="false" escapeJavaScript="true" />';
  var msgMailInvalid   = '<s:property value="getText('user.form.mail.invalid')" escapeHtml="false"  escapeJavaScript="true" />';
  var msgMailRepeated  = '<s:property value="getText('user.form.mail.repeated')" escapeHtml="false" escapeJavaScript="true" />';
  var msgPwdEmpty      = '<s:property value="getText('user.form.pwd.empty')" escapeHtml="false" escapeJavaScript="true" />';
  var msgPwdInvalid    = '<s:property value="getText('user.form.pwd.invalid')" escapeHtml="false" escapeJavaScript="true" />';
  var msgConfEmpty     = '<s:property value="getText('user.form.conf.empty')" escapeHtml="false" escapeJavaScript="true" />';
  var msgConfInvalid   = '<s:property value="getText('user.form.conf.invalid')" escapeHtml="false" escapeJavaScript="true" />';
  var msgPwdNotEqual   = '<s:property value="getText('user.form.conf.notequal')" escapeHtml="false" escapeJavaScript="true" />';
  var msgLevelEmpty    = '<s:property value="getText('user.form.lvl.empty')" escapeHtml="false" escapeJavaScript="true" />';
  var msgLevelInvalid  = '<s:property value="getText('user.form.lvl.invalid')" escapeHtml="false" escapeJavaScript="true" />';
  var msgStatusEmpty   = '<s:property value="getText('user.form.status.empty')" escapeHtml="false" escapeJavaScript="true" />';
  var msgStatusInvalid = '<s:property value="getText('user.form.status.invalid')" escapeHtml="false" escapeJavaScript="true" />';


  $( function() {
    $("input:text").addClass("ui-widget ui-widget-content ui-corner-all");
    $("input:password").addClass("ui-widget ui-widget-content ui-corner-all");
    $('#userName').attr('autocomplete','off');
    $('#userMail').attr('autocomplete','off');
    $('#userSecret').attr('autocomplete','off');
    $('#userConfirm').attr('autocomplete','off');

    $( "#userLevel" ).selectmenu();
    if ( recordAction !== 1 )
    {
       $("#userName").attr('readonly','readonly');
       $("#userStatus").selectmenu();
       $('#userSecret').focus();
    }
    else
    {
       $("#userStatus").addClass("ui-widget ui-widget-content ui-corner-all disabledTexbox");
       $('#userName').focus();
    }
  });

  function isValidMail( mailAddress ) {

    if ( mailAddress !== '' )
       return /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test( mailAddress );
    return false;
  }

  function goBack() {

    this.location.href = '${pageContext.request.contextPath}/service/listUsers.xhtm';
  }

  function doPost() {

    var oForm  = document.forms['recordForm'];
    var obj    = oForm.elements['userName'];
    var val    = obj.value;

    if ( val.length === 0 ) {
       alert( msgLoginEmpty );
       obj.focus();
       return;
    }

    if ( !val.match(/^[A-Za-z][A-Za-z0-9]{5,15}$/)) {
       alert( msgLogininvalid );
       obj.focus();
       return;
    }

    obj = oForm.elements['userMail'];
    val = obj.value;
    if ( val.length === 0 ) {
       alert( msgMailEmpty );
       obj.focus();
       return;
    }

    if ( !isValidMail( val )) {
       alert( msgMailInvalid );
       obj.focus();
       return;
    }

    var pwd01   = oForm.elements['userSecret'].value;
    var pwd02   = oForm.elements['userConfirm'].value;
    var needPwd = ( recordAction === 1 ||  pwd01.length !== 0 || pwd02.length !== 0 );

    if ( needPwd ) {

       obj = oForm.elements['userSecret'];

       if ( pwd01.length === 0 ) {
          alert( msgPwdEmpty );
          obj.focus();
          return;
       }

       if ( !pwd01.match(/^[^\s]{8,16}$/)) {
          alert( msgPwdInvalid );
          obj.focus();
          return;
       }

       obj   = oForm.elements['userConfirm'];
       if ( pwd02.length === 0 ) {
          alert( msgConfEmpty );
          obj.focus();
          return;
       }

       if ( !pwd02.match(/^[^\s]{8,16}$/)) {
          alert( msgConfInvalid );
          obj.focus();
          return;
       }

       if ( pwd01 !== pwd02 ) {

          alert( msgPwdNotEqual );
          obj.focus();
          return;
       }
    }

    obj = $("#userLevel");
    val = $("#userLevel").val();

    if ( val.length === 0 ) {
       alert( msgLevelEmpty );
       obj.focus();
       return;
    }

    val = parseInt( val );
    if ( val < 1 || val > 3 ) {
       alert( msgLevelInvalid );
       obj.focus();
       return;
    }

    obj = $("#userStatus");
    val = $("#userStatus").val();

    if ( val.length === 0 ) {
       alert( msgStatusEmpty );
       obj.focus();
       return;
    }

    if ( !val.match(/^[ABS]$/) ) {
       alert( msgStatusInvalid );
       obj.focus();
       return;
    }

    oForm.submit();
  }

  $("#buttonCancel").button({
    icons: {
      primary: "iconReset"
    },
    text: true
  }).click( function ( event ) {

    event.preventDefault();
    goBack();
  });

  $("#buttonSave").button({
    icons: {
      primary: "iconReset"
    },
    text: true
  }).click( function ( event ) {

    event.preventDefault();
    doPost();
  });
  $("#userName").focus();

</script>

<%
  session.removeAttribute( "mapLevels" );
  session.removeAttribute( "mapStatus" );
/*
  session.removeAttribute( "userBean" );
  session.removeAttribute( "recordAction" );
*/
%>
