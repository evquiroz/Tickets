package ctm_people_getinfo_ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import ctm_people_getinfo_ws.OutputMapping3.GetListValues;

@WebService(targetNamespace = "urn:CTM_People_GetInfo_WS", name = "CTM_People_WSPortTypePortType")
public class PeopleInfoServer implements CTMPeopleWSPortTypePortType {

  @WebResult(name = "getListValues", targetNamespace = "urn:CTM_People_GetInfo_WS")
  @RequestWrapper(localName = "CTM_GetPeopleInfo", targetNamespace = "urn:CTM_People_GetInfo_WS", className = "ctm_people_getinfo_ws.InputMapping3")
  @WebMethod(operationName = "CTM_GetPeopleInfo", action = "urn:CTM_People_GetInfo_WS/CTM_GetPeopleInfo")
  @ResponseWrapper(localName = "CTM_GetPeopleInfoResponse", targetNamespace = "urn:CTM_People_GetInfo_WS", className = "ctm_people_getinfo_ws.OutputMapping3")
  @Override
  public List<GetListValues> ctmGetPeopleInfo(
         @WebParam(name = "Qualification", targetNamespace = "urn:CTM_People_GetInfo_WS")
         String qualification,
         @WebParam(name = "startRecord", targetNamespace = "urn:CTM_People_GetInfo_WS")
         String startRecord,
         @WebParam(name = "maxLimit", targetNamespace = "urn:CTM_People_GetInfo_WS")
         String maxLimit ) {

    GetListValues listValues = new GetListValues();
    listValues.setNombreS( "Centro" );
    listValues.setApellidoS("Comandos");
    listValues.setCorreoElectronico("centrocomandos@compartamos.mx");

    List<GetListValues> result = new ArrayList<>();
    result.add( listValues );

    return result;
  }


}
