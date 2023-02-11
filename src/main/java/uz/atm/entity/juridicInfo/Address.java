package uz.atm.entity.juridicInfo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.atm.entity.Auditable;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Author: Bekpulatov Shoxruh
 * Date: 23/08/22
 * Time: 11:46
 */

@Entity(name = "addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "addresses" )
public class Address extends Auditable {

    private String countryCode;

    private String soatoCode;

    private String village;

    private String sectorCode;

    private String streetName;

    private String house;

    private String flat;

    private Integer postcode;

    private String cadastreNumber;

}
