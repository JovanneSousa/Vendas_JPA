package br.com.jsousa.jpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ClienteJpaDAO2BancosTest.class, ClienteJpaDAO3BancosTest.class,
	ClienteJpaDAOTest.class, ProdutoJpaDAOTest.class, VendaJpaDAOTest.class
})
public class AllTests {

}
