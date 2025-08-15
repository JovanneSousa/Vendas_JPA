package br.com.jsousa.services.generic.jpa;

import java.io.Serializable;
import java.util.Collection;

import br.com.jsousa.dao.generic.jpa.IGenericJpaDAO;
import br.com.jsousa.domain.jpa.Persistente;
import br.com.jsousa.exceptions.DAOException;
import br.com.jsousa.exceptions.MaisDeUmRegistroException;
import br.com.jsousa.exceptions.TableException;
import br.com.jsousa.exceptions.TipoChaveNaoEncontradaException;

public class GenericJpaService <T extends Persistente, E extends Serializable> implements IGenericJpaSerivce<T, E> {

	protected IGenericJpaDAO<T,E> dao;
	
	public GenericJpaService(IGenericJpaDAO<T, E> dao) {
		this.dao = dao;
	}
	
	@Override
	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(T entity) throws DAOException {
		this.dao.excluir(entity);
	}

	@Override
	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.alterar(entity);
	}

	@Override
	public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
		return this.dao.consultar(valor);
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		return this.dao.buscarTodos();
	}

}
