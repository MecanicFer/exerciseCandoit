package exercise.candoit.exerciseCandoit.response;

public class UserRegister {

	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserRegister(Long id, String nombre, String apellido, String email, String password, String role) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public UserRegister(String nombre, String apellido, String email, String password, String role) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public UserRegister(String email) {
		super();
		this.email = email;
	}

	public UserRegister() {

	}

}
