package cl.intelidata.amicar.dao;

import cl.intelidata.amicar.dao.Ejecutivos;
import cl.intelidata.amicar.dao.Vendedores;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-10T18:18:54")
@StaticMetamodel(Locales.class)
public class Locales_ { 

    public static volatile ListAttribute<Locales, Vendedores> vendedoresList;
    public static volatile ListAttribute<Locales, Ejecutivos> ejecutivosList;
    public static volatile SingularAttribute<Locales, Integer> idLocal;
    public static volatile SingularAttribute<Locales, String> nombreLocal;

}