package rs3.persistence.DAO.daoImpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rs3.persistence.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("select b from Department b where b.departmentName = :name")
    Department findByName(@Param("name") String name);
}