package query.annotation.springdatajpa.queryandmodifyingannotationspringdataJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /*@Query annotation is used to perform the select operation in jpa.
    @Query annotation support both jpql and native query approach.
    @Query annotation it is possible to use pagination and sorting using jpql only not for the native query approach.
    by default @Query annotation uses jpql format if you want to use native sql queries just set nativeQuery attribute
    to true "nativeQuery = true"
    Passing method parameters to query method as index based and named parameter
    * in index based passing the drawback is we cant change the order of method parameter they appearing
    * but in named parameter we can resolve that using named parameter passing by replacing that placeholder
    * and Annoting our method parameter with @Param annotation*

    @Query Method return one or more result :
    for one result you can have return type
    1.entity  - return Entity object or null
    2.basic types - return some value or null
    3.Optional<> - return found object or empty optional

    and for more than one result :
    1.List<> - return List or empty list
    2. Stream<> - return stream or empty Stream
    /
     */

    @Query("select s from Student s where s.name = ?1")
    List<Student> getStudentByName(String name);

    @Query("select s.name from Student s")
    List<String> findAllStudentNamesOnly();

    //@Query("select s from Student s where s.schoolName = :schoolName")
    @Query("select s from Student s where s.schoolName like %:schoolName%")
    List<Student> getStudentBySchoolName(@Param("schoolName") String schoolName);

    @Modifying
    @Query("update Student s set s.name = :name where s.id = :id")
    void updateStudentName(@Param("name") String name,@Param("id") Long id);

}
