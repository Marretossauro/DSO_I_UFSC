import java.util.ArrayList;
import java.util.List;

public class Livro {
    
    private int codigo;
    private String titulo;
    private int ano;
    private Editora editora;
    private ArrayList<Autor> autores;
    private ArrayList<Capitulo> capitulos;
    
    public Livro(int codigo, String titulo, int ano, Editora editora, Autor autor, int numeroCapitulo, String tituloCapitulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.ano = ano;
        this.editora = editora;
        this.autores = new ArrayList<>();
        this.capitulos = new ArrayList<>();
        incluirAutor(autor);
        incluirCapitulo(numeroCapitulo, tituloCapitulo);
    }
    
    public int getCodigo() {
        
        return this.codigo;
        
    }
    
    public String getTitulo() {
        
        return this.titulo;
        
    }
    
    public int getAno() {
        
        return this.ano;
        
    }
    
    public Editora getEditora() {
        
        return this.editora;
        
    }
    
    public List<Autor> getAutores() {
        
        return this.autores;
        
    }
    
    public void setCodigo(int codigo) {
        
        this.codigo = codigo;
        
    }
    
    public void setTitulo(String titulo) {
        
        this.titulo = titulo;
        
    }
    
    public void setAno(int ano) {
        
        this.ano = ano;
        
    }
    
    public void setEditora(Editora editora) {
        
        this.editora = editora;
        
    }
    
    public void incluirAutor(Autor autor) {
        
        if(autor != null){
            if(!this.autores.isEmpty()) {
                for (Autor a : this.autores) {
                    if (a.getCodigo() != autor.getCodigo()) {
                        this.autores.add(autor);
                        break;
                    }
                }
            } else {
                this.autores.add(autor);
            }
        }

    }
    
    public void excluirAutor(Autor autor) {
        
        if(autor != null){
            if(!this.autores.isEmpty()) {        
                for (Autor a : this.autores) {
                    if (a.getCodigo() == autor.getCodigo()) {
                        this.autores.remove(autor);
                        break;
                    }
                }
            }    
        }
        
    }
    
    public void incluirCapitulo(int numero, String tituloCapitulo) {
        
        Capitulo capitulo = new Capitulo(numero, tituloCapitulo);
        
        if(capitulo != null){
            if (!this.capitulos.isEmpty()) {
                for (Capitulo c : this.capitulos) {
                    if (!c.getTitulo().equals(tituloCapitulo)) {
                        this.capitulos.add(capitulo);
                        break;
                    }
                }
            } else {
                this.capitulos.add(capitulo);
            }
        }
        
    }
    
    public void excluirCapitulo(String tituloCapitulo) {
        
        Capitulo capitulo = findCapituloByTitulo(tituloCapitulo);
        
        if(capitulo != null){
            if(!this.capitulos.isEmpty()) {        
                for (Capitulo c : this.capitulos) {
                    if (c.getNumero() == capitulo.getNumero()) {
                        this.capitulos.remove(capitulo);
                        break;
                    }
                }
            }  
        }
                                                
    }
    
    public Capitulo findCapituloByTitulo(String capTitulo) {
        
        for (Capitulo capitulo : this.capitulos) {
            if (capitulo.getTitulo().equals(capTitulo)) {
                return capitulo;
            }
        }
        return null;
        
    }
    
}
