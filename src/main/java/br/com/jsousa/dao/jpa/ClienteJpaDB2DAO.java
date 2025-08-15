package br.com.jsousa.dao.jpa;

import br.com.jsousa.dao.generic.jpa.GenericJpaDB2DAO;
import br.com.jsousa.domain.jpa.ClienteJpa;

public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa>{

	public ClienteJpaDB2DAO() {
		super(ClienteJpa.class);
	}
}
