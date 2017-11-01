<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div align="center">

  <br><br>
  <h3>La aplicaci\u00f3n se comporta inesperadamente</h3>
  <br>
  
  <div align="left" style="padding-left: 28px">
    Por favor contacte a soporte t\u00e9cnico y proporcione la siguiente informaci\u00f3n:
    <br><br> 
  </div>
  <br>
  <table>
  <tr>
    <td>
      <b>Tipo de excepci\u00f3n:<b>            
    </td>    
    <td>
      <s:property value="exception" />
    </td>    
  </tr>    
  <tr>
    <td>
      <b>Detalles:</b>
    </td>    
    <td>
      <s:property value="exceptionStack" />
    </td>    
  </tr>    
  </table>

</div>