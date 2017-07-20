package rs3.persistence.DAO.daoImpl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rs3.persistence.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select b from Employee b where b.employeeName = :name")
    Employee findByName(@Param("name") String name);
}