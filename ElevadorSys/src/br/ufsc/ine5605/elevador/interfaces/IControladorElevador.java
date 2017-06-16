package br.ufsc.ine5605.elevador.interfaces;

import br.ufsc.ine5605.elevador.objects.Elevador;

public interface IControladorElevador {

	/**
	 * Faz o elevador subir um andar. Se nao for possivel subir, retorna
	 * mensagem de erro
	 * 
	 * @return Mensagem de erro, caso nao seja possivel realizar a operacao
	 */
	public String subir();

	/**
	 * Faz o elevador descer um andar. Se nao for possivel descer, retorna
	 * mensagem de erro
	 * 
	 * @return Mensagem de erro, caso nao seja possivel realizar a operacao
	 */
	public String descer();

	/**
	 * Entra uma pessoa no Elevador. Se nao for possivel permitir a entrada da
	 * pessoa, retorna mensagem de erro
	 * 
	 * @return Mensagem de erro, caso nao seja possivel realizar a operacao
	 */
	public String entraPessoa();

	/**
	 * Sai uma pessoa no Elevador. Se nao for possivel permitir a saida da
	 * pessoa, retorna mensagem de erro
	 * 
	 * @return Mensagem de erro, caso nao seja possivel realizar a operacao
	 */
	public String saiPessoa();

	/**
	 *
	 * @return Elevador
	 */
	public Elevador getElevador();

	/**
	 *
	 * @param andarAtual
	 *            andar atual do elevador
	 * @param totalAndaresPredio
	 *            total de andares do predio
	 * @param capacidade
	 *            capacidade maxima do elevador
	 * @param totalPessoas
	 *            total de pessoas atual do elevador
	 * @return retorna o Elevador instanciado como um IElevador
	 */
	public IElevador inicializarElevador(int andarAtual, int totalAndaresPredio, int capacidade, int totalPessoas);

}
