package ua.od.UserService.domain.domainrepositoryinterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByLogin(String login);
    UserEntity findByPassword(String password);
}
