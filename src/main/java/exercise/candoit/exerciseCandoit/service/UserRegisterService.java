package exercise.candoit.exerciseCandoit.service;

import java.util.List;
import exercise.candoit.exerciseCandoit.entity.User;
import exercise.candoit.exerciseCandoit.response.UserRegister;

public interface UserRegisterService {
	
	public User save(UserRegister userRegister);
	
	public List<User> listarUsuarios(); //listUsers
	
	public void eliminarUsuarioPorId(Long id); //deleteUserbyId
	
	public User obtenerUsuarioPorId(Long id); //getUserbyID
	
	public User actualizarUsuario(User user); //updateUserbyid

}
