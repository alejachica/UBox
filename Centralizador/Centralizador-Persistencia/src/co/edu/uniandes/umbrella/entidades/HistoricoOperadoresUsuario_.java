package co.edu.uniandes.umbrella.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-23T21:06:38.892-0500")
@StaticMetamodel(HistoricoOperadoresUsuario.class)
public class HistoricoOperadoresUsuario_ {
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, Date> fecha;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, BigDecimal> idHistorico;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, BigDecimal> idOperadorDestino;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, BigDecimal> idOperadorOrigen;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, BigDecimal> idTipoOperacion;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, BigDecimal> idUsuario;
	public static volatile SingularAttribute<HistoricoOperadoresUsuario, String> numFormulario;
}
