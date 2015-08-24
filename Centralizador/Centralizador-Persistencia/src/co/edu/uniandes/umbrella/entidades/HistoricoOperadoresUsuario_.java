package co.edu.uniandes.umbrella.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-24T16:10:58.877-0500")
@StaticMetamodel(HistoricoOperadoresUsuario.class)
public class HistoricoOperadoresUsuario_ {
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, Date> fecha;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, Integer> idHistorico;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, Integer> idTipoOperacion;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, String> numFormulario;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, Operador> operador1;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, Operador> operador2;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, Usuario> usuario;
}
