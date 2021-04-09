package query.annotation.springdatajpa.queryandmodifyingannotationspringdataJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private  StudentService studentService;

    public Controller(StudentService studentService) {
        this.studentService = studentService;
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
}
