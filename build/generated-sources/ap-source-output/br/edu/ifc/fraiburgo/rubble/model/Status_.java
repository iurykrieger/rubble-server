package br.edu.ifc.fraiburgo.rubble.model;

import br.edu.ifc.fraiburgo.rubble.model.Postagem;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-18T15:00:22")
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile SingularAttribute<Status, Long> idStatus;
    public static volatile SingularAttribute<Status, Boolean> ativo;
    public static volatile SingularAttribute<Status, Postagem> idPostagem;
    public static volatile SingularAttribute<Status, Date> data;
    public static volatile SingularAttribute<Status, Usuario> idUsuario;
    public static volatile SingularAttribute<Status, String> status;

}