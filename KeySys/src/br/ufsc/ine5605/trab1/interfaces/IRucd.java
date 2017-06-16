package br.ufsc.ine5605.trab1.interfaces;

public interface IRucd {

	public void cadastrar(Object o) throws Exception;

	public String lista() throws Exception;

	public void excluir(String verificador) throws Exception;

}
