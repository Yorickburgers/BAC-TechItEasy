package nl.novi.bachwtechiteasy.repositories;

import nl.novi.bachwtechiteasy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
