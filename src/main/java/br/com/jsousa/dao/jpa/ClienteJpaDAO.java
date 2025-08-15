package br.com.jsousa.dao.jpa;

import br.com.jsousa.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.jsousa.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}
}
