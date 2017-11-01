<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div align="center">

  <table widht="920">
  <tr>
    <td width="40">&nbsp;</td>
    <td align="center" valign="middle" width="700">
      <span class="fieldError">
        <s:property value="#session.sessionErrorMsg" />
      </span>
    </td>
    <td width="40">&nbsp;</td>
    <td width="140">&nbsp;</td>
  </tr>
  </table>
      
  <form action="${pageContext.request.contextPath}/service/handleMessage.xhtm" name="recordForm" id="recordForm" method="post">
    
  <table id="recordHeaderTable" widht="920">
  <tr>
    <td id="recordHeader" align="center" height="32" widht="920">
      <div align="center" id="divHeader" class="ui-widget-header ui-corner-tl ui-corner-tr jquiTableHeader" style="height: 32px; width: 920px">
        <s:property value="getText('msg.form.title')" />
      </div>
    </td>
  </tr>
  </table>
    
  <table widht="920" class="recordTable">
  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>

  <tr>
    <td width="40">&nbsp;</td>
    <td height="40">
      <span class="fieldTitle">
        <b><s:property value="getText('msg.form.msg')" /></b>
      </span>
    </td>
    <td width="40">&nbsp;</td>
  </tr>  
  <tr>
    <td width="40">&nbsp;</td>
    <td>
      <textarea id="siteMessage" name="siteMessage" maxlength="255" cols="96" rows="4">${ appGlobalMsg }</textarea>
      <input type="hidden" name="actionMessageID" id="actionMessageID" value="${ appMsgActionID + 3 }" />
    </td>
    <td width="40">&nbsp;</td>
  </tr>  
  <tr>
    <td width="40">&nbsp;</td>
    <td>&nbsp;</td>
    <td width="40">&nbsp;</td>
  </tr>  
  <tr>
    <td width="40">&nbsp;</td>
    <td class="textNote">
      <s:property value="getText('msg.form.note')" /></i>
    </td>
    <td width="40">&nbsp;</td>
  </tr>  
  <tr>
    <td width="40">&nbsp;</td>
    <td>&nbsp;</td>
    <td width="40">&nbsp;</td>
  </tr>  
  </table>
    
  </form>  

  <!-- los los botones -->  
  
  <br><br>

  <table width="920">
  <tr>
    <td align="right">
      <button id="buttonCancel" class="ui-button ui-widget ui-corner-all formButton" 
              onClick="javascript:goBack()">
        <span class="ui-icon iconCancel"></span>         
        &nbsp;
        <s:property value="getText('msg.button.cancel')" />
      </button>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <button id="buttonSave" class="ui-button ui-widget ui-corner-all formButton">
        <span class="ui-icon iconSave"></span>         
        &nbsp;
        <s:property value="getText('msg.button.save')" />
      </button>
    </td>
    <td width="34">&nbsp;</td>
  </tr>
  </table>      
    
</div>

<script type="text/javascript">
  
  $( function() {
    $("#siteMessage").addClass("ui-widget ui-widget-content ui-corner-all");
    $("#siteMessage").focus();
  });

  function goBack() {

    this.location.href = '${pageContext.request.contextPath}/service/main.xhtm';
  }
  
  function doPost() { 
    
    var oForm  = document.forms['recordForm'];
    var msg    = $("#siteMessage");
    var val    = msg.value;

    // Si se quiere agregar alguna validacion, hacerlo aqui
    
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
