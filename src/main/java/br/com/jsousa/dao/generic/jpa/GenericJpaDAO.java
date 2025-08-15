package br.com.jsousa.dao.generic.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jsousa.domain.jpa.Persistente;
import br.com.jsousa.exceptions.DAOException;
import br.com.jsousa.exceptions.MaisDeUmRegistroException;
import br.com.jsousa.exceptions.TableException;
import br.com.jsousa.exceptions.TipoChaveNaoEncontradaException;

public class GenericJpaDAO <T extends Persistente, E extends Serializable> implements IGenericJpaDAO<T,E>{

	private static final String PERSISTENCE_UNIT_NAME = "Postgre1";
	
	protected EntityManagerFactory entityManagerFactory;
	
	protected EntityManager entityManager;
	
	private Class<T> persistenteClass;
	
	private String persistenteUnitName;
	
	public GenericJpaDAO(Class<T> persistenteClass, String persistenteUnitName) {
		this.persistenteClass = persistenteClass;
		this.persistenteUnitName = persistenteUnitName;
	}
	
	@Override
	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		openConnection();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		closeConnection();
		return entity;
	}

	
	@Override
	public void excluir(T entity) throws DAOException {
		openConnection();
		entity = entityManager.merge(entity);
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
		closeConnection();
	}

	@Override
	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		openConnection();
		entity = entityManager.merge(entity);
		entityManager.getTransaction().commit();
		closeConnection();
		return entity;
	}

	@Override
	public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException {
		openConnection();
		T entity = entityManager.find(persistenteClass, id);
		entityManager.getTransaction().commit();
		closeConnection();
		return entity;
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		openConnection();
		List<T> list =
				entityManager.createQuery(getSelectSql(), this.persistenteClass).getResultList();
		closeConnection();
		return list;
	}

	protected void closeConnection() {
		entityManager.close();
		entityManagerFactory.close();
	}

	private String getPersistenceUnitName() {
		if (persistenteUnitName != null && !"".equals(persistenteUnitName)) {
			return persistenteUnitName;
		} else {
			return PERSISTENCE_UNIT_NAME;
		}
		
	}

	protected void openConnection() {
		entityManagerFactory = 
				Persistence.createEntityManagerFactory(getPersistenceUnitName());
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	

	private String getSelectSql() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT obj FROM ");
		sb.append(this.persistenteClass.getSimpleName());
		sb.append(" obj");
		return sb.toString();
	}
}
