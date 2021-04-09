package query.annotation.springdatajpa.queryandmodifyingannotationspringdataJpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

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

    public void updateStudent(String name ,Long id){
        studentRepository.updateStudentName(name,id);
    }
}
