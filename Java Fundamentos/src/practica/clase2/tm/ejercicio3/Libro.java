package practica.clase2.tm.ejercicio3;

public class Libro {

    private String titulo;
    private int isbn;
    private String autor;
    private Boolean disponible;

    public Libro(){}

    public Libro(String titulo, int isbn, String autor, Boolean disponible) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.disponible = disponible;
    }

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public Boolean prestamo(){
        if (this.disponible.equals(true)) {
            this.disponible = false;
            return true;
        } else
            return false;
    }

    public Boolean devolucion(){
        if (this.disponible.equals(false)) {
            this.disponible = true;
            return true;
        } else
            return false;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIsbn() {
        return this.isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean getDisponible() {
        return this.disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return this.titulo + ", " + this.isbn + ", " + this.autor;
    }
}
