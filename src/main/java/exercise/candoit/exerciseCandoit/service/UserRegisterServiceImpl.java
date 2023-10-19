package exercise.candoit.exerciseCandoit.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import exercise.candoit.exerciseCandoit.entity.Rol;
import exercise.candoit.exerciseCandoit.entity.User;
import exercise.candoit.exerciseCandoit.repository.UserRepository;
import exercise.candoit.exerciseCandoit.response.UserRegister;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserRegisterServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegister userRegister) {

		User user = new User(userRegister.getNombre(), userRegister.getApellido(), userRegister.getEmail(),
				passwordEncoder.encode(userRegister.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
		return userRepository.save(user);
	}

	@Override
	public void eliminarUsuarioPorId(Long id) {
		userRepository.deleteById(id);
	}

	public User obtenerUsuarioPorId(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User actualizarUsuario(User user) {
		User existingUser = userRepository.findById(user.getId()).orElse(null);
		if (existingUser != null) {
			existingUser.setNombre(user.getNombre());
			existingUser.setApellido(user.getApellido());
			existingUser.setEmail(user.getEmail());

			String newPassword = user.getPassword();
			if (newPassword != null && !newPassword.isEmpty()) {
				existingUser.setPassword(passwordEncoder.encode(newPassword));
			}

			return userRepository.save(existingUser);
		}
		return null;
	}

	@Override
	public List<User> listarUsuarios() {
		return userRepository.findAll();
	}

}
