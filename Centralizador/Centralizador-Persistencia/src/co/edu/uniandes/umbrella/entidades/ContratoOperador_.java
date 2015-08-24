package co.edu.uniandes.umbrella.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-23T21:06:45.054-0500")
@StaticMetamodel(ContratoOperador.class)
public class ContratoOperador_ {
	public static volatile SingularAttribute<ContratoOperador, Long> idOperador;
	public static volatile SingularAttribute<ContratoOperador, BigDecimal> estado;
	public static volatile SingularAttribute<ContratoOperador, Date> fechaFin;
	public static volatile SingularAttribute<ContratoOperador, Date> fechaInicio;
	public static volatile SingularAttribute<ContratoOperador, BigDecimal> nroContrato;
}
