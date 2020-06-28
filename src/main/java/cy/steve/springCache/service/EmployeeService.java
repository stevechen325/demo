package cy.steve.springCache.service;

import cy.steve.springCache.entity.Employee;
import cy.steve.springCache.repo.EmployeeRepo;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steve
 */
@Service
public class EmployeeService implements Serializable {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Cacheable(cacheNames = "emp")
    public Employee findEmpById(Integer id) {
        System.out.printf("查詢%s號員工%n", id);
        return employeeRepo.findEmpById(id);
    }

    @CachePut(value = "emp", key = "#employee.id")
    @Transactional
    public Employee updateEmp(Employee employee) {
        System.out.println("更新" + employee.getId() + "號員工");
        employeeRepo.updateEmp(employee.getId(), employee.getLastName(), employee.getEmail(), employee.getGender(),
                employee.getDId());
        return employee;
    }

    @CacheEvict(value = "emp", key = "#id", allEntries = true)
    public void deleteEmpById(Integer id) {
        System.out.println("刪除" + id + "號員工");
    }
}
