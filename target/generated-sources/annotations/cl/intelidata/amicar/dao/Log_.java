package cl.intelidata.amicar.dao;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-02T12:52:46")
@StaticMetamodel(Log.class)
public class Log_ { 

    public static volatile SingularAttribute<Log, Integer> idVendedor;
    public static volatile SingularAttribute<Log, Integer> idCliente;
    public static volatile SingularAttribute<Log, Date> fechaLog;
    public static volatile SingularAttribute<Log, Integer> idlog;
    public static volatile SingularAttribute<Log, Integer> idEjecutivo;

}