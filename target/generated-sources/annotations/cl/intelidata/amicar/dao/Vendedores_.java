package cl.intelidata.amicar.dao;

import cl.intelidata.amicar.dao.Locales;
import cl.intelidata.amicar.dao.Proceso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-02T12:52:46")
@StaticMetamodel(Vendedores.class)
public class Vendedores_ { 

    public static volatile SingularAttribute<Vendedores, Integer> idVendedor;
    public static volatile ListAttribute<Vendedores, Proceso> procesoList;
    public static volatile SingularAttribute<Vendedores, String> nombreVendedor;
    public static volatile SingularAttribute<Vendedores, String> rutVendedor;
    public static volatile SingularAttribute<Vendedores, Locales> localesidLocal;

}