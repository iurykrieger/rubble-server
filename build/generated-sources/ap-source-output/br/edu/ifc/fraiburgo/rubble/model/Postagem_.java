package br.edu.ifc.fraiburgo.rubble.model;

import br.edu.ifc.fraiburgo.rubble.model.Comentario;
import br.edu.ifc.fraiburgo.rubble.model.Status;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-18T15:00:22")
@StaticMetamodel(Postagem.class)
public class Postagem_ { 

    public static volatile SingularAttribute<Postagem, String> tipo;
    public static volatile SingularAttribute<Postagem, Long> idPostagem;
    public static volatile SingularAttribute<Postagem, Date> data;
    public static volatile SingularAttribute<Postagem, String> foto;
    public static volatile ListAttribute<Postagem, Status> statusList;
    public static volatile SingularAttribute<Postagem, Integer> numComentarios;
    public static volatile ListAttribute<Postagem, Comentario> comentarioList;
    public static volatile SingularAttribute<Postagem, Double> latitude;
    public static volatile SingularAttribute<Postagem, Usuario> idUsuario;
    public static volatile SingularAttribute<Postagem, Integer> vizualizacoes;
    public static volatile SingularAttribute<Postagem, String> descricao;
    public static volatile SingularAttribute<Postagem, Double> longitude;

}