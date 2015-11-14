package co.edu.uniandes.umbrella.interfaces;

import java.util.List;

import co.edu.uniandes.umbrella.entidades.ZonaGeografica;

public interface ZonaGeograficaEJBRemote {
	List<ZonaGeografica> getZonasGeograficas();
	List<ZonaGeografica> buscarZonaGeograficaPorDepartamento(int idZonaGeografica);
	ZonaGeografica buscarCiudad(int idZonaGeografica);
	List<ZonaGeografica> buscarTodosDepartamento();
}
