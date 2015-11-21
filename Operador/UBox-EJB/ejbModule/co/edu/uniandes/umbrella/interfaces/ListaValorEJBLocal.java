package co.edu.uniandes.umbrella.interfaces;

import java.util.List;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.entidades.ListaValor;

@Local
public interface ListaValorEJBLocal {
	ListaValor buscarListaValorPorCodigoExterno(int idLista, String codigoExterno);
	List<ListaValor> buscarLista(int idLista);
}
