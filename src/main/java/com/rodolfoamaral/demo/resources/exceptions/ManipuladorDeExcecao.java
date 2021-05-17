package com.rodolfoamaral.demo.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rodolfoamaral.demo.services.exceptions.ResourceNotFoundExcecao;

@ControllerAdvice //intercepta as exceções para que esse objeto realize o tratamento
public class ManipuladorDeExcecao {
	
	@ExceptionHandler(ResourceNotFoundExcecao.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(ResourceNotFoundExcecao e, HttpServletRequest request){
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao corpoDoErro = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(corpoDoErro);
	}
		
}
