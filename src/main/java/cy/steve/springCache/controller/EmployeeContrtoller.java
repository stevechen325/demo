package cy.steve.springCache.controller;

import cy.steve.springCache.entity.Employee;
import cy.steve.springCache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Steve
 */
@RestController
public class EmployeeContrtoller {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee findEmpById(@PathVariable("id") Integer id) {
        return employeeService.findEmpById(id);
    }

    /**
     * 傳入參數要注意大小寫
     * http://localhost:8080/emp?id=1&lastName=%E5%8F%B2%E5%B8%9D%E5%A4%AB&email=%E5%8F%B2%E5%B8%9D%E5%A4%AB@mail.com&gender=1&dId=10
     *
     * @param employee
     * @return
     */
    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {
        return employeeService.updateEmp(employee);
    }

    /**
     * 刪除 http://localhost:8080/delemp?id=1
     *
     * @param id
     */
    @GetMapping("/delemp")
    public void deleteEmpById(Integer id) {
        employeeService.deleteEmpById(id);
    }
}
