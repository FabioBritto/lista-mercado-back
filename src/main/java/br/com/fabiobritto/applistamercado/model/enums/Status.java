package br.com.fabiobritto.applistamercado.model.enums;

public enum Status {

	CONCLUIDO(1),
	NAO_CONCLUIDO(2);
	
	
	private int code;
	
	private Status(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Status valueOf(int code) {
		for(Status s : Status.values()) {
			if(s.getCode() == code) {
				return s;
			}
		}
		throw new IllegalArgumentException("Código de Status Inválido");	}
}
