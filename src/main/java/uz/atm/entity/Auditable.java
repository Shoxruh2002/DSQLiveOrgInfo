package uz.atm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 09:52
 */

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class Auditable implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonIgnore
    @Column(name = "created_at", columnDefinition = "TIMESTAMP default NOW()")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date createdAt = new Date();

}
