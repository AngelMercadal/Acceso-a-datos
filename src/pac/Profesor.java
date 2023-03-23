package pac;



public class Profesor{


	

	
	private long id;
	
	private String nombre;
	
	private String sexo;
	
	
	
	
	
	public Profesor() {
		
	}

	public Profesor(String nombre, String sexo) {
	
		this.nombre = nombre;
		this.sexo = sexo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", sexo=" + sexo + "]";
	}
	
	
	
}
