package co.edu.uniandes.umbrella.interfaces;

import java.util.List;

import co.edu.uniandes.umbrella.entidades.ListaValor;

public interface ListaValorEJBLocal {
	ListaValor buscarListaValorPorCodigoExterno(int idLista, String codigoExterno);
	ListaValor buscarLista(int idLista);
}
