package hpd_incidentinterface_create_ws;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.6.10
 * 2017-05-27T00:40:57.453-05:00
 * Generated source version: 2.6.10
 *
 */

public class HPDIncidentIHPDIncident_Server{

    protected HPDIncidentIHPDIncident_Server() throws java.lang.Exception {

        System.out.println("Starting Server");
        // Object implementor = new HPDIncidentInterfaceCreateWSPortTypePortTypeImpl();
        String address = "http://localhost:9010/HPD_IncidentInterface_Create_WS";

        Object implementor = new IncidentServer();
        Endpoint.publish( address, implementor );
    }

    public static void main(String args[]) throws java.lang.Exception {

        new HPDIncidentIHPDIncident_Server();
        System.out.println("incident Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}