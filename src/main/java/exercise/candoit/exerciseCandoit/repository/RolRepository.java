package exercise.candoit.exerciseCandoit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import exercise.candoit.exerciseCandoit.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Long>{
	
	 public Rol findByNombre(String nombre);
}
