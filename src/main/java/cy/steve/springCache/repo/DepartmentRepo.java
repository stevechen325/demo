package cy.steve.springCache.repo;

import cy.steve.springCache.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Steve
 */
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    
}
