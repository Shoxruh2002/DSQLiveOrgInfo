package uz.atm.entity.juridicInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
/**
 * Author: Bekpulatov Shoxruh
 * Date: 23/08/22
 * Time: 11:40
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyExtraInfo {

    private Double monthlyNumberEmployees;

    private Double avgNumberEmployees;
}
