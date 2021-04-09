package query.annotation.springdatajpa.queryandmodifying.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import query.annotation.springdatajpa.queryandmodifying.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /*Derived Queries*/

    //finding employee by their name
    List<Employee> findByEmpName(String empName);

    //finding employees by their age
    List<Employee> findEmployeeByEmpNameContainsOrderByEmpNameAsc(String empName);

    //finding employees by their age
    List<Employee> findEmployeeByEmpNameContainsOrderByEmpNameDesc(String empName);

    //finding all names ends with using EndingWith keyword in of derive query method
    List<Employee> findEmployeeByEmpNameEndingWith(String empName);

    //finding all names ends with using EndingWith keyword in of derive query method
    List<Employee> findEmployeeByEmpNameStartingWith(String empName);

    List<Employee> findEmployeeByEmpNameContaining(String empName);

    /*we can also use derived query to delete the entity using deleteBy introducer(keyword) followed
    * by the criteria(entity attribute)
    * as we see that to perform insert,update,delete, and ddl operation we use @transactional annotation.
    * in case of derived delete queries also we need  @transactional annotation.
    */
    Long deleteByEmpId(Long empId);

    /*if we are we finding employee by name and email ,if email is provided null then,
    * internally it is interpreted as null*/
    List<Employee> findByEmpNameAndEmpSurname(String empName, String empSurname);

    //we can also customize the result or limit our results set using Top keyword followed by number of records
    List<Employee> findTop3ByEmpAge(Integer empAge);
}
