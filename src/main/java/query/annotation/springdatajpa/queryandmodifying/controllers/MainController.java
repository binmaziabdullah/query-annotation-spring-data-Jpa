package query.annotation.springdatajpa.queryandmodifying.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import query.annotation.springdatajpa.queryandmodifying.model.Employee;
import query.annotation.springdatajpa.queryandmodifying.model.Student;
import query.annotation.springdatajpa.queryandmodifying.service.EmployeeService;
import query.annotation.springdatajpa.queryandmodifying.service.StudentService;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private final StudentService studentService;

    @Autowired
    private final EmployeeService employeeService;

    public MainController(StudentService studentService, EmployeeService employeeService) {
        this.studentService = studentService;
        this.employeeService = employeeService;
    }

    @PostMapping("/addStudents")
    public String addStudents(@RequestBody Student student){
        studentService.addStudents(student);
        return "Students record saved";
    }

    @GetMapping("/getStudentByName/{name}")
    public List<Student> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/findALlNames")
    public List<String> findAllStudentNamesOnly(){
        return studentService.findAllStudentNamesOnly();
    }

    @GetMapping("/getStudentBySchoolName/{schoolName}")
    public List<Student> getStudentBySchoolName(@PathVariable String schoolName){
        return studentService.getStudentBySchoolName(schoolName);
    }
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/updateStudent/{name}/{id}")
    public String updateStudent(@PathVariable String name,@PathVariable Long id){
        studentService.updateStudent(name,id);
        return "Student updated";
    }

    @DeleteMapping("deleteStudentById/{id}")
    public String deleteStudentById(@PathVariable Long id){
        int i = studentService.deleteStudentById(id);
        return i+" "+"Student deleted";
    }

    /*----------------------------Employee---------------------------------------*/

    @GetMapping("/findByEmpName/{empName}")
    public List<Employee> findByEmpName(@PathVariable String empName){
        return employeeService.findByEmpName(empName);
    }

    @GetMapping("/findAllEmployeeAsc/{empName}")
    public List<Employee> findAllEmployeeNameContainsInAsc(@PathVariable String empName){
        return employeeService.findAllEmployeeNameContainInAsc(empName);
    }

    @GetMapping("/findAllEmployeeDesc/{empName}")
    public List<Employee> findAllEmployeeNameContainsInDesc(@PathVariable String empName){
        return employeeService.findAllEmployeeNameContainInDesc(empName);
    }

    @GetMapping("/findAllEmployeeEndingWith/{empName}")
    public List<Employee> findAllEmployeeEndingWith(@PathVariable String empName){
        return employeeService.findAllEmployeeEndingWith(empName);
    }
    @GetMapping("/findAllEmployeeStartingWith/{empName}")
    public List<Employee> findAllEmployeeStartingWith(@PathVariable String empName){
        return employeeService.findAllEmployeeStartingWith(empName);
    }

    @GetMapping("findAllEmployeeByNameContaining/{empName}")
    public List<Employee> findAllEmployeeByNameContaining(@PathVariable String empName){
        return employeeService.findAllEmployeeByEmpNameContaining(empName);
    }

    @GetMapping("findAllEmployeeByNameNotContaining/{empName}")
    public List<Employee> findAllEmployeeByNameNotContaining(@PathVariable String empName){
        return employeeService.findEmployeeByNameNotContaining(empName);
    }

    @DeleteMapping("/deleteEmpById/{empId}")
    public String deleteEmpById(@PathVariable Long empId){
        Long status = employeeService.deleteEmpById(empId);
        return status+" "+"Employee is deleted";
    }
    @GetMapping("findByEmpNameAndSalary/{empName}/{empSurname}")
    public List<Employee> findByEmpNameAndSalary(@PathVariable String empName, @PathVariable String empSurname){
        return employeeService.findByNameAndEmpSurname(empName,empSurname);
    }
    @GetMapping("/findTop3EmployeeMaxAge")
    public List<Employee> findTop3EmployeeMaxAge(){
        return employeeService.findTop3EmployeeMaxAge();
    }
    @GetMapping("/findTop3EmployeeMaxSal")
    public List<Employee> findTop3EmployeeMaxSal(){
        return employeeService.findTop3EmployeeMaxSal();
    }
    @GetMapping("/findLimitedEmployeeUsingFirstKeyword")
    public List<Employee> findLimitedEmployeeByFirstKeyword(){
        return employeeService.findLimitedEmployeeByFirstKeyword();
    }

}
