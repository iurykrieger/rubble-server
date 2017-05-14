package br.edu.ifc.fraiburgo.rubble.model;

import br.edu.ifc.fraiburgo.rubble.model.Bugreport;
import br.edu.ifc.fraiburgo.rubble.model.Cidade;
import br.edu.ifc.fraiburgo.rubble.model.Comentario;
import br.edu.ifc.fraiburgo.rubble.model.Conquista;
import br.edu.ifc.fraiburgo.rubble.model.Marcacao;
import br.edu.ifc.fraiburgo.rubble.model.Postagem;
import br.edu.ifc.fraiburgo.rubble.model.RedeSocial;
import br.edu.ifc.fraiburgo.rubble.model.Status;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-18T15:00:22")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, Marcacao> marcacaoList;
    public static volatile SingularAttribute<Usuario, Integer> numComentarios;
    public static volatile ListAttribute<Usuario, Conquista> conquistaList;
    public static volatile SingularAttribute<Usuario, Long> idUsuario;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, Cidade> idCidade;
    public static volatile ListAttribute<Usuario, RedeSocial> redeSocialList;
    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile ListAttribute<Usuario, Bugreport> bugreportList;
    public static volatile ListAttribute<Usuario, Status> statusList;
    public static volatile SingularAttribute<Usuario, Integer> numPostagens;
    public static volatile ListAttribute<Usuario, Comentario> comentarioList;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile ListAttribute<Usuario, Postagem> postagemList;

}