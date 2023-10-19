package exercise.candoit.exerciseCandoit.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import exercise.candoit.exerciseCandoit.entity.Rol;
import exercise.candoit.exerciseCandoit.entity.User;
import exercise.candoit.exerciseCandoit.repository.UserRepository;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User usuario = userRepository.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario o password invalidos");
		}

		return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(),
				mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
		Collection<GrantedAuthority> authorities = roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
		return authorities;
	}
}