package cy.steve.springCache.repo;

import cy.steve.springCache.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Steve
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    public Employee findEmpById(Integer id);

    @Modifying
    @Query("UPDATE Employee e SET e.lastName=:lastName,e.email=:email,e.gender=:gender,e.dId=:dId WHERE e.id=:id")
    public void updateEmp(@Param("id") Integer id, @Param("lastName") String lastName, @Param("email") String email, @Param("gender") Integer gender, @Param("dId") Integer dId);

    @Query("DELETE FROM Employee WHERE id=:id")
    public void deleteEmpById(@Param("id") Integer id);

    @Modifying
    @Query(value = "INSERT INTO employee(lastName,email,gender,d_id) values (:lastName, :email,:gender,:dId)", nativeQuery = true)
    public void insertEmployee(@Param("lastName") String lastName, @Param("email") String email, @Param("gender") Integer gender, @Param("dId") Integer dId);
}
