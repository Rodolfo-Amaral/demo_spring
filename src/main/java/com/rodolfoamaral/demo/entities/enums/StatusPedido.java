package com.rodolfoamaral.demo.entities.enums;

public enum StatusPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	DESPACHADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int cod;
	
	private StatusPedido(int cod) {
		this.cod = cod;
	}
	
	public int getCod() {
		return cod;
	}
	
	public static StatusPedido valueOf(int cod) {
		for (StatusPedido valor : StatusPedido.values()) {
			if (valor.getCod() == cod) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Código de Status do Pedido inválido");
	}
	 

}
