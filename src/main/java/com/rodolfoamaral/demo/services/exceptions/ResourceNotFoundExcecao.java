package com.rodolfoamaral.demo.services.exceptions;

public class ResourceNotFoundExcecao extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExcecao(Object id) {
		super("ID ["+id+"] não encontrado!");
	}

}
