package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Student")
public class Student {
    @Id
    private int student_id;
    private String name;
    private String birth;
    private String major;
    private String email;
}