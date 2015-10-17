package co.edu.uniandes.umbrella.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-10-17T18:07:41.125-0500")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, Integer> idUsuario;
	public static volatile SingularAttribute<Usuario, String> direccionNotificacion;
	public static volatile SingularAttribute<Usuario, String> emailPersonal;
	public static volatile SingularAttribute<Usuario, Date> fechaExpediciionIdentificacion;
	public static volatile SingularAttribute<Usuario, Date> fechaNacimiento;
	public static volatile SingularAttribute<Usuario, String> genero;
	public static volatile SingularAttribute<Usuario, String> idDireccionResidencia;
	public static volatile SingularAttribute<Usuario, Integer> idEstadoCivil;
	public static volatile SingularAttribute<Usuario, Integer> idNacionalidad;
	public static volatile SingularAttribute<Usuario, Integer> idOperador;
	public static volatile SingularAttribute<Usuario, String> idTipoIdentificacion;
	public static volatile SingularAttribute<Usuario, String> nroIdentificacion;
	public static volatile SingularAttribute<Usuario, String> primerApellido;
	public static volatile SingularAttribute<Usuario, String> primerNombre;
	public static volatile SingularAttribute<Usuario, String> segundoApellido;
	public static volatile SingularAttribute<Usuario, String> segundoNombre;
	public static volatile SingularAttribute<Usuario, Integer> telefono;
	public static volatile ListAttribute<Usuario, HistoricoOperadoresUsuario> historicoOperadoresUsuarios;
	public static volatile SingularAttribute<Usuario, Operador> operador;
	public static volatile SingularAttribute<Usuario, ZonaGeografica> municipioExpedicionDoc;
	public static volatile SingularAttribute<Usuario, ZonaGeografica> municipioLaboral;
	public static volatile SingularAttribute<Usuario, ZonaGeografica> municipioNacimiento;
	public static volatile SingularAttribute<Usuario, ZonaGeografica> municipioNotificacion;
	public static volatile SingularAttribute<Usuario, ZonaGeografica> municipioResidencia;
}
