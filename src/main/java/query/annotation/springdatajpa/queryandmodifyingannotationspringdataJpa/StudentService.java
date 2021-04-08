package query.annotation.springdatajpa.queryandmodifyingannotationspringdataJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudents(Student student){
        studentRepository.save(student);
    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }
    public List<String> findAllStudentNamesOnly() {
        return studentRepository.findAllStudentNamesOnly();
    }

    public List<Student> getStudentBySchoolName(String schoolName) {
        return studentRepository.getStudentBySchoolName(schoolName);
    }
    /*public void updateStudent(Student student){
        studentRepository.updateStudent(student.getId());
    }*/
}
