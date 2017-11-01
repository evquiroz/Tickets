<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

  <%
    String localUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
    session.setAttribute("localUri", localUri );

    String printHome  = "1";
    String printLogin = "1";

    if ( localUri.indexOf("home") > -1 )
       printHome = "0";
    session.setAttribute("printHome", printHome );
    if ( localUri.indexOf("login") > -1 )
       printLogin = "0";
    session.setAttribute("printLogin", printLogin );
  %>

  <div id="header">
    <div align="center">

      <table class="headerTable">
      <tr>
        <td colspan="4" align="left">
          <span class="pageTitle"><s:property value="getText('lbl.portal.name')" /></span>
        </td>
        <td class="menuSup">
        <s:if test='%{ #session.printLogin.equals("1") }'>

          <s:if test="#session.appLoginName != null">
            <a href="${pageContext.request.contextPath}/logout.jsp" class="linkMenuSup">
              <s:property value="getText('lbl.link.logout')" /></a>
          </s:if>
          <s:else>
            <a href="${pageContext.request.contextPath}/service/login.xhtm" class="linkMenuSup">
              <s:property value="getText('lbl.link.login')" /></a>
          </s:else>

        </s:if>

        <s:if test='%{ #session.printHome.equals("1") }'>

          <s:if test='%{ #session.printLogin.equals("1") }'>
            &nbsp;
            <img src="${pageContext.request.contextPath}/img/bulletmenu_bco.png" alt="" width="3" height="3">
            &nbsp;
          </s:if>  
          <a href="${pageContext.request.contextPath}/service/home.xhtm" class="linkMenuSup">
            <s:property value="getText('lbl.link.home')" /></a>
        </s:if>
        </td>
        <td colspan="2">&nbsp;</td>
      <tr>
      <tr>
        <td colspan="7">&nbsp;</td>
      <tr>
      <tr>
        <td colspan="3" class="genteraLogo">
          <img src="${pageContext.request.contextPath}/img/logoGentera.png">
        </td>
        <td>&nbsp;</td>
        <td colspan="3" class="genteraFrase">
          <img src="${pageContext.request.contextPath}/img/Frase.png">
        </td>
      <tr>
      </table>

    </div>
  </div>
