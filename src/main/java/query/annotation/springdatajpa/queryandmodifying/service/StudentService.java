package query.annotation.springdatajpa.queryandmodifying.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import query.annotation.springdatajpa.queryandmodifying.model.Student;
import query.annotation.springdatajpa.queryandmodifying.repository.StudentRepository;

import java.util.List;


@Service
@Transactional
public class StudentService {

    @Autowired
    private  StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudents(Student student) {
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

    public void updateStudent(String name, Long id) {
        studentRepository.updateStudentName(name, id);
    }
    public Integer deleteStudentById(Long id){
        return studentRepository.deleteStudentById(id);
    }

}
