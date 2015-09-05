package co.edu.uniandes.umbrella.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-08-24T16:10:58.959-0500")
@StaticMetamodel(ZonaGeografica.class)
public class ZonaGeografica_ {
	public static volatile SingularAttribute<ZonaGeografica, Integer> idZonaGeografica;
	public static volatile SingularAttribute<ZonaGeografica, String> nombre;
	public static volatile ListAttribute<ZonaGeografica, Usuario> usuarios1;
	public static volatile ListAttribute<ZonaGeografica, Usuario> usuarios2;
	public static volatile ListAttribute<ZonaGeografica, Usuario> usuarios3;
	public static volatile ListAttribute<ZonaGeografica, Usuario> usuarios4;
	public static volatile ListAttribute<ZonaGeografica, Usuario> usuarios5;
	public static volatile SingularAttribute<ZonaGeografica, ZonaGeografica> zonaGeografica;
	public static volatile ListAttribute<ZonaGeografica, ZonaGeografica> zonaGeograficas;
}
