package rs3.persistence.DAO.daoImpl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rs3.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select b from User b where b.name = :name")
    User findByName(@Param("name") String name);
}