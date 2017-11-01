<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

  <div id="header">
    <div align="center">

      <table class="headerTable">
      <tr>
        <td colspan="4"></td>
        <td class="menuSup">
        <s:if test="#session.appLoginName != null">
          <a href="${pageContext.request.contextPath}/logout.jsp" class="linkMenuSup">
            <s:property value="getText('lbl.link.logout')" /></a>
          &nbsp;
          <img src="${pageContext.request.contextPath}/img/bulletmenu_bco.png" alt="" width="3" height="3">
          &nbsp;
        </s:if>
          <a href="https://www.gentera.com.mx/" class="linkMenuSup">
            <s:property value="getText('lbl.link.home')" /></a>
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
