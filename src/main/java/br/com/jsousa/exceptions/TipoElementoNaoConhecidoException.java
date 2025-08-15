package br.com.jsousa.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {

	public static final long serialVersionUID = -2268140970978666251L;
	
	public TipoElementoNaoConhecidoException(String msg) {
		this(msg, null);
	}
	
	public TipoElementoNaoConhecidoException(String msg, Throwable e) {
		super(msg, e);
	}
}
