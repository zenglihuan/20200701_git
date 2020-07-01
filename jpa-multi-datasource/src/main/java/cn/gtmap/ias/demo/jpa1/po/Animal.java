package cn.gtmap.ias.demo.jpa1.po;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zenglihuan
 * @version 1.0.0
 * @since 2020/5/11 15:33
 **/
@Data
@Entity
@Table(name = "demo_animal")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(unique = true, nullable = false, updatable = false, length = 32)
    private String id;

    private String name;

    private String age;

}

