package uz.atm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 11/28/22 10:49 AM
 **/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tins {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tin;

    private String name;

    private Integer status;

    @Column(columnDefinition = "boolean default false")
    private Boolean isJuridicDone = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean isFoundersDone = false;

    public Tins( String longValue ) {
        this.tin = longValue;
    }
}
