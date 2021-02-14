package ejercicio;


public class Libro {
    
	private String isbn;
	
	private String titulo;
	
	private String editorial;
	
	private int codigo_autor;

	public Libro(String isbn, String titulo, String editorial, int codigo_autor) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.codigo_autor = codigo_autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public int getCodigo_autor() {
		return codigo_autor;
	}


}
