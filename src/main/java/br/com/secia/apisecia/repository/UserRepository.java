package br.com.secia.apisecia.repository;

import br.com.secia.apisecia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String email);
}
