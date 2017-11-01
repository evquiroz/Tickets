<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

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

