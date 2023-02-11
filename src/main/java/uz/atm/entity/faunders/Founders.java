package uz.atm.entity.faunders;

import lombok.*;
import uz.atm.entity.Auditable;

import javax.persistence.*;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 12/27/22 10:01 AM
 **/
@Entity( name = "founders" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(  name = "founders" )
public class Founders extends Auditable {

    private String dsqId;

    @Embedded
    private FounderIndividual founderIndividual;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "founder_legal_id" )
    private FounderLegal founderLegal;

    @Embedded
    private FounderContact founderContact;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "founder_address_id" )
    private FounderAddress founderAddress;

    private Double budgetPercent;

    private Integer budgetLevelId;

    @Data
    @Embeddable
    public static class FounderContact {

        private String phone;

        private String email;

    }

}
