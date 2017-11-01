package mx.com.nttdata.dao;

import java.util.List;
import mx.com.nttdata.beans.SiteMessage;

/**
 * Interfaz que modela el comportamiento del DAO de mensajes
 * @version 1.0.0
 */
public interface IMessagesDAO {

  int create( SiteMessage record, String user ) throws Exception;

  int delete( Integer id ) throws Exception;

  SiteMessage getCurrentMessage() throws Exception;

  List<SiteMessage> list() throws Exception;

  SiteMessage read( Integer id ) throws Exception;

  int update( SiteMessage record, String user ) throws Exception;
  
  boolean truncate() throws Exception;

}
