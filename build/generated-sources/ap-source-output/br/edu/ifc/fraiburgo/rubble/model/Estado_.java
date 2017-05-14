package br.edu.ifc.fraiburgo.rubble.model;

import br.edu.ifc.fraiburgo.rubble.model.Cidade;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-18T15:00:22")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile ListAttribute<Estado, Cidade> cidadeList;
    public static volatile SingularAttribute<Estado, String> uf;
    public static volatile SingularAttribute<Estado, Long> idEstado;
    public static volatile SingularAttribute<Estado, String> nome;

}