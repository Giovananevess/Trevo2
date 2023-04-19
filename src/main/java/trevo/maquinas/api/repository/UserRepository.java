package trevo.maquinas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trevo.maquinas.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByLogin(String login);
    User findByLogin(String login);



}
