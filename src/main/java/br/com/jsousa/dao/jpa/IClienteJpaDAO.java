package br.com.jsousa.dao.jpa;

import br.com.jsousa.dao.generic.jpa.IGenericJpaDAO;
import br.com.jsousa.domain.jpa.Persistente;

public interface IClienteJpaDAO<T extends Persistente> extends IGenericJpaDAO<T, Long> {

}
