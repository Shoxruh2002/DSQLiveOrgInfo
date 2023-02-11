package uz.atm.entity.juridicInfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 23/08/22
 * Time: 11:43
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Column(name = "company_tin")
    private Long tin;//

    @Column(columnDefinition = "TEXT")
    private String name;//

    private String shortName;//

    private String opf;//

    private String kfs;//

    private String soogu;//

    private String sooguRegistrator;//

    private String oked;//

    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING)
    private Date registrationDate;//

    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING)
    private Date licenseBeginDate;//

    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING)
    private Date licenseEndDate;//

    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING)
    private Date reregistrationDate;//

    private String registrationNumber;//

    private String status;//

    private String statusUpdated;//

    private String taxStatus;//

    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING)
    private Date liquidationDate;//

    private String liquidationReason;//

    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING)
    private Date suspensionDate;//

    private String suspensionReason;//

    private Double vatNumber;//

    private String taxpayerType;//

    private String activityType;//

    private String businessType;//

    private String individualEntrepreneurType;//

    private String businessFundCurrency;//

    private Double businessFund;//

    private Integer businessStructure;//


}
