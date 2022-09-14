package tech.ravendev.employeemanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false)
    private Long id;
    private  String name;
    private  String email;
    private  String jobTitle;
    private  String phone;
    private  String imageUrl;
    @Column(updatable = false,nullable = false)
    private  String employeeCode;


}
