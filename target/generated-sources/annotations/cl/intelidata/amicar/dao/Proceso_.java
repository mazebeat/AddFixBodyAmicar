package cl.intelidata.amicar.dao;

import cl.intelidata.amicar.dao.Clientes;
import cl.intelidata.amicar.dao.Ejecutivos;
import cl.intelidata.amicar.dao.Vendedores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-10T18:18:54")
@StaticMetamodel(Proceso.class)
public class Proceso_ { 

    public static volatile SingularAttribute<Proceso, Date> fechaEnvio;
    public static volatile SingularAttribute<Proceso, Integer> idProceso;
    public static volatile SingularAttribute<Proceso, Date> fechaClickLink;
    public static volatile SingularAttribute<Proceso, Date> fechaAperturaMail;
    public static volatile SingularAttribute<Proceso, Vendedores> vendedoresidVendedor;
    public static volatile SingularAttribute<Proceso, Clientes> clientesidCliente;
    public static volatile SingularAttribute<Proceso, Ejecutivos> ejecutivosidEjecutivo;

}