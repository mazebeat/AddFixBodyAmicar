package cl.intelidata.amicar.dao;

import cl.intelidata.amicar.dao.Proceso;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-02T12:52:46")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> rutCliente;
    public static volatile ListAttribute<Clientes, Proceso> procesoList;
    public static volatile SingularAttribute<Clientes, String> fonoCliente;
    public static volatile SingularAttribute<Clientes, Date> fecha;
    public static volatile SingularAttribute<Clientes, String> emailCliente;
    public static volatile SingularAttribute<Clientes, String> automovilCliente;
    public static volatile SingularAttribute<Clientes, Integer> idCliente;
    public static volatile SingularAttribute<Clientes, Integer> idGrupo;
    public static volatile SingularAttribute<Clientes, String> nombreCliente;
    public static volatile SingularAttribute<Clientes, String> sexoCliente;
    public static volatile SingularAttribute<Clientes, Integer> idBody;

}