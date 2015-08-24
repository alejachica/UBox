package co.edu.uniandes.umbrella.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-23T21:05:06.879-0500")
@StaticMetamodel(Operador.class)
public class Operador_ {
	public static volatile SingularAttribute<Operador, Long> idOperador;
	public static volatile SingularAttribute<Operador, String> direccion;
	public static volatile SingularAttribute<Operador, String> email;
	public static volatile SingularAttribute<Operador, String> nit;
	public static volatile SingularAttribute<Operador, String> razonSocial;
	public static volatile SingularAttribute<Operador, BigDecimal> telefono;
}
