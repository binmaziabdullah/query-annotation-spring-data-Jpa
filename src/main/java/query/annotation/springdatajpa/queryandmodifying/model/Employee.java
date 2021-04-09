package query.annotation.springdatajpa.queryandmodifying.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private Long empId;
    private String empName;
    private String empSurname;
    private Integer empAge;
    private Integer empSal;


}
