package br.edu.ifc.fraiburgo.rubble.model;

import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-18T15:00:22")
@StaticMetamodel(Bugreport.class)
public class Bugreport_ { 

    public static volatile SingularAttribute<Bugreport, Long> idBugreport;
    public static volatile SingularAttribute<Bugreport, Usuario> idUsuario;
    public static volatile SingularAttribute<Bugreport, String> report;

}