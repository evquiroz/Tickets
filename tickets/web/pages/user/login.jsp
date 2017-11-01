<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<form action="${pageContext.request.contextPath}/service/userLogin.xhtm" name="loginForm" method="post">

  <div align="center">

  <br clear="all" />
  <br clear="all" />
  <br clear="all" />
  <span class="fieldError">
    <s:property value="#session.sessionErrorMsg" />
  </span>
  <br clear="all" />
  <br clear="all" />
  <table class="loginForm ui-corner-all">
  <tr>
    <td colspan="3">
      <div align="center" class="ui-widget-header ui-corner-tl ui-corner-tr jquiTableHeader ticketFormTitle">
        <s:property value="getText('login.form.title')" />
      </div>
    </td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>

  <!-- Login Name -->
  <tr>
    <td class="formLeftColumn">
      <span class="fieldTitle">
        <s:property value="getText('login.form.login')" />
      </span>
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <input type="text" id="login" name="login" maxlength="24" size="36" class="textField" />
    </td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td>
      <span class="fieldError"><s:property value="loginFieldError" /></span>
    </td>
  </tr>

  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>

  <!-- User's secret -->
  <tr>
    <td class="formLeftColumn">
      <span class="fieldTitle">
        <s:property value="getText('login.form.secret')" />
      </span>
    </td>
    <td class="fromMiddleColumn">&nbsp;</td>
    <td>
      <input type="password" name="secret" maxlength="16" size="36" class="textField" />
    </td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td>
      <span class="fieldError"><s:property value="loginFieldError" /></span>
    </td>
  </tr>

  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>
  </table>

  <br clear="all" />
  <br clear="all" />

  <table style="width: 600px">
  <tr>
    <td align="center">
      <button id="buttonLogin" class="ui-button ui-widget ui-corner-all formButton"
              onClick="javascript:doLogin()">
        <span class="ui-icon iconLogin"></span>         
        &nbsp;
        <s:property value="getText('form.button.login')" /></button>
    </td>
  </tr>
  </table>

  </div>

</form>

<script type="text/javascript">

  function doLogin() {

    var msgLoginR  = '<s:property value="getText('fld.login.required')" escapeHtml="false" />';
    var msgLoginV  = '<s:property value="getText('fld.login.invalid')" escapeHtml="false" />';
    var msgSecretR = '<s:property value="getText('fld.secret.required')" escapeHtml="false" />';
    var msgSecretV = '<s:property value="getText('fld.secret.invalid')" escapeHtml="false" />';

    var oForm      = document.forms[0];
    var login      = oForm.elements['login'].value;
    var secret     = oForm.elements['secret'].value;


    if ( login.length === 0 ) {
       alert( msgLoginR );
       oForm.elements['login'].focus();
       return;
    }

    if ( !login.match(/^[A-Za-z0-9\.\-\_]{3,16}$/)) {
       alert( msgLoginV );
       oForm.elements['login'].focus();
       return;
    }

    if ( secret.length === 0 ) {
       alert( msgSecretR );
       oForm.elements['secret'].focus();
       return;
    }

    if ( !secret.match(/^[^\s]{8,20}$/)) {
       alert( msgSecretV );
       oForm.elements['secret'].focus();
       return;
    }
    oForm.submit();
  }

  $('#login').attr('autocomplete','off');
  $('#secret').attr('autocomplete','off');
  $( function() {
    $("input:text").addClass("ui-widget ui-widget-content ui-corner-all");
    $("input:password").addClass("ui-widget ui-widget-content ui-corner-all");
  });

  $("#buttonLogin").button({
    text: true
  }).click( function ( event ) {

    event.preventDefault();
  });

  $("#login").focus();

</script>
