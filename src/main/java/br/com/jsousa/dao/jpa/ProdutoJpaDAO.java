package br.com.jsousa.dao.jpa;

import br.com.jsousa.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.jsousa.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO{

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
