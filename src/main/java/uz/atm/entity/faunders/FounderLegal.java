package uz.atm.entity.faunders;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.atm.entity.Auditable;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 23/08/22
 * Time: 14:26
 */
@Entity( name = "founder_legal" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "founder_legal" )
public class FounderLegal extends Auditable {

    @Column( name = "dsq_id" )
    private String dsqId;

    private Long tin;

    private String shortName;

    private String name;

    private String registrationDate;

    private String registrationNumber;

    private String reregistrationDate;

    private Long businessFund;

    private Integer businessType;

    private Integer kfs;

    private String oked;

    private Long opf;

    private String soato;

    private String soogu;

    private String sooguRegistrator;

    private Integer status;

    private String statusUpdated;

    private Integer taxMode;

    private Integer taxpayerType;

    private String vatNumber;

    private String liquidationDate;

    private String liquidationReason;

    private Integer businessStructure;

    private String created;

    private String updated;

    private Integer regCountry;

    private Integer founderSharePercent;

    private Long founderShareSum;

    private String stateTin;

    private Integer countTotalFounders;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "director_id" )
    private FounderDirAcc director;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "accountant_id" )
    private FounderDirAcc accountant;

    @Embedded
    private BusinessStructureDetail businessStructureDetail;

    @Embedded
    private StatusDetail statusDetail;

    @Embedded
    private SooguDetail sooguDetail;

    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn( name = "founder_legal_id" )
    private List<ActivityTypes> activityTypes;

    @Embedded
    private OpfDetail opfDetail;

    @Embedded
    private OkedDetail okedDetail;


}
