<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ResourceBundle" %>
<%
  if ( request.getSession( false ) != null )
     request.getSession().invalidate();

  response.setHeader("cache-control","no-cache, no-store, must-revalidate");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader("Expires",0);
  response.sendRedirect( request.getContextPath() + "/" );
%>
