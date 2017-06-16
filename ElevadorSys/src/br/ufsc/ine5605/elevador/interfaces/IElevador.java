package br.ufsc.ine5605.elevador.interfaces;

public interface IElevador {

    public int getCapacidade();
    public int getTotalPessoas();
    public String descer();
    public String entraPessoa();
    public String saiPessoa();
    public String subir();
    public void setTotalAndaresPredio(int totalAndaresPredio);
    public int getTotalAndaresPredio();
    public int getAndarAtual();
    
}

