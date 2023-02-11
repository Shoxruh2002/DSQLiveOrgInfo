package uz.atm.entity.juridicInfo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 23/08/22
 * Time: 11:35
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Accountant {

    @Column(name = "accountant_last_name")
    private String lastName;

    @Column(name = "accountant_first_name")
    private String firstName;

    @Column(name = "accountant_middle_name")
    private String middleName;

    @Column(name = "accountant_gender")
    private Integer gender;

    @Column(name = "accountant_country_code")
    private String countryCode;

    @Column(name = "accountant_passport_series")
    private String passportSeries;

    @Column(name = "accountant_passport_number")
    private String passportNumber;

    @Column(name = "accountant_pinfl")
    private Long pinfl;

    @Column(name = "accountant_tin")
    private Long tin;
}
