package query.annotation.springdatajpa.queryandmodifying.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import query.annotation.springdatajpa.queryandmodifying.model.Employee;
import query.annotation.springdatajpa.queryandmodifying.repository.EmployeeRepository;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findByEmpName(String empName) {
        return employeeRepository.findByEmpName(empName);
    }

    public List<Employee> findAllEmployeeNameContainInAsc(String empName) {
        return employeeRepository.findEmployeeByEmpNameContainsOrderByEmpNameAsc(empName);
    }

    public List<Employee> findAllEmployeeNameContainInDesc(String empName) {
        return employeeRepository.findEmployeeByEmpNameContainsOrderByEmpNameDesc(empName);
    }

    public List<Employee> findAllEmployeeEndingWith(String empName) {
        return employeeRepository.findEmployeeByEmpNameEndingWith(empName);
    }

    public List<Employee> findAllEmployeeStartingWith(String empName) {
        return employeeRepository.findEmployeeByEmpNameStartingWith(empName);
    }

    public List<Employee> findAllEmployeeByEmpNameContaining(String empName) {
        return employeeRepository.findEmployeeByEmpNameContaining(empName);
    }

    public Long deleteEmpById(Long empId) {
        return employeeRepository.deleteByEmpId(empId);
    }
    public List<Employee> findByNameAndEmpSurname(String empName, String empSurname){
        return employeeRepository.findByEmpNameAndEmpSurname(empName,empSurname);
    }
    public List<Employee> findLimitedEmployeeByAge(Integer empAge){
        return employeeRepository.findTop3ByEmpAge(empAge);
    }
}
