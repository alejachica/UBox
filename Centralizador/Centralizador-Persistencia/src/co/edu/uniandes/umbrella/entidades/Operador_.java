package co.edu.uniandes.umbrella.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-24T16:10:58.902-0500")
@StaticMetamodel(Operador.class)
public class Operador_ {
	public static volatile SingularAttribute<Operador, Integer> idOperador;
	public static volatile SingularAttribute<Operador, String> direccion;
	public static volatile SingularAttribute<Operador, String> email;
	public static volatile SingularAttribute<Operador, String> nit;
	public static volatile SingularAttribute<Operador, String> razonSocial;
	public static volatile SingularAttribute<Operador, String> telefono;
	public static volatile ListAttribute<Operador, HistoricoOperadoresUsuario> historicoOperadoresUsuarios1;
	public static volatile ListAttribute<Operador, HistoricoOperadoresUsuario> historicoOperadoresUsuarios2;
	public static volatile ListAttribute<Operador, Usuario> usuarios;
}
