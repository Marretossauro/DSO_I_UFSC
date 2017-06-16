package be.ufsc.ine5605.modelo;

public enum TipoCliente {

	ESPECIAL("Saldo maior que R$100.000"),
	NORMAL("Saldo Positivo"),
	DEVEDOR("Saldo Negativo");

	public String detalhes;
	
	TipoCliente(String detalhesP){
		detalhes = detalhesP;
	}
	
}
