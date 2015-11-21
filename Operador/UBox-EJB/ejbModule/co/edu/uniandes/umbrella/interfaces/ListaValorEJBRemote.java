package co.edu.uniandes.umbrella.interfaces;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.entidades.ListaValor;

@Remote
public interface ListaValorEJBRemote {
	ListaValor buscarListaValorPorCodigoExterno(int idLista, String codigoExterno);
	List<ListaValor> buscarLista(int idLista);
	ListaValor buscarListaValor(int idListaValor);
}
