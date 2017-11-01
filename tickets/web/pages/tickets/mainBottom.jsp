<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page import="mx.com.nttdata.service.MessageService" %>

<jsp:useBean id="svcMsgs" class="mx.com.nttdata.service.MessageService" />

  <!-- Main Bottom -->

  <div align="center">

    <div id="messagesArea" class="ui-corner-all">
      <table width="100%">
      <tr>
        <td align="center">${svcMsgs.currentMessage}</td>
      </tr>
      </table>
    </div>

  </div>
