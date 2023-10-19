package exercise.candoit.exerciseCandoit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import exercise.candoit.exerciseCandoit.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

}
