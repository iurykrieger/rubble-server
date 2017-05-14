package br.edu.ifc.fraiburgo.rubble.model;

import br.edu.ifc.fraiburgo.rubble.model.Estado;
import br.edu.ifc.fraiburgo.rubble.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-18T15:00:22")
@StaticMetamodel(Cidade.class)
public class Cidade_ { 

    public static volatile SingularAttribute<Cidade, Long> area;
    public static volatile SingularAttribute<Cidade, Estado> idEstado;
    public static volatile ListAttribute<Cidade, Usuario> usuarioList;
    public static volatile SingularAttribute<Cidade, String> gentilico;
    public static volatile SingularAttribute<Cidade, Integer> codigoIbge;
    public static volatile SingularAttribute<Cidade, Long> idCidade;
    public static volatile SingularAttribute<Cidade, String> nome;
    public static volatile SingularAttribute<Cidade, Integer> populacao;
    public static volatile SingularAttribute<Cidade, Integer> densidadeDemo;

}