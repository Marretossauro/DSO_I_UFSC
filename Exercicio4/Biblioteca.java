import java.util.ArrayList;

public class Biblioteca {
    
    private ArrayList<Livro> livros;
    
    public Biblioteca() {
        
        this.livros = new ArrayList<>();
        
    }
    
    public void incluirLivro(Livro livro) {
        
        if (livro != null){
            if(!this.livros.isEmpty()) {        
                for (Livro l : this.livros) {
                    if (l.getCodigo() != livro.getCodigo()) {
                        this.livros.add(livro);
                        break;
                    }
                }
            } else {
                this.livros.add(livro);
            }
        }
    }
    
    public void excluirLivro(Livro livro) {
        
        if(livro != null){
            if(!this.livros.isEmpty()) {        
                for (Livro l : this.livros) {
                    if (l.getCodigo() == livro.getCodigo()) {
                        this.livros.remove(livro);
                        break;
                    }
                }
            }    
        }
    }
    
}
