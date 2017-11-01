<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div align="center">

  <br><br>
  <h3><s:property value="getText('error.title')" /></h3>
  <br>
  
  <div align="left" style="padding-left: 28px">
    <s:property value="getText('error.subtitle')" />
    <br><br> 
  <br>
  <table>
  <tr>
    <td>
      <b><s:property value="getText('error.kind')" /><b>            
    </td>    
    <td>
      <s:property value="exception" />
    </td>    
  </tr>    
  <tr>
    <td>
      <b><s:property value="getText('error.details')" /></b>
    </td>    
    <td>
      <s:property value="exceptionStack" />
    </td>    
  </tr>    
  </table>
  </div>
    
  <br clear="all">
  <br clear="all">
  <br clear="all">
  <br clear="all">

  <button id="goHomeButton" class="ui-button ui-widget ui-corner-all" onClick="goHome()">
    <span class="ui-icon iconContinue"></span>         
    &nbsp;
    <s:property value="getText('button.continue.label')" /></button>
    
</div>
    
  <script TYPE="text/javascript">
    $("#goHomeButton").button({
          text: true
        }).click( function ( event ) {

      event.preventDefault();
      goHome();
    });

    function goHome() {

      this.location.href = "${pageContext.request.contextPath}/service/home.xhtm";
    }
  </script>
    