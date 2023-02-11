package uz.atm.entity.faunders;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 1/20/23 3:12 PM
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class FounderIndividual {

    private String lastName;//

    private String firstName;//

    private String middleName;//

    private Integer gender;//

    private Integer nationality;

    private Integer citizenship;

    private String passportSeries;

    private String passportNumber;

    private Long pinfl;//

    private Long tin;//

    private String birthDate;

    private String founderSharePercent;

    private Long founderShareSum;

    private Long countTotalFounders;

    private Integer liveState;

}
