package uz.atm.entity.faunders;

import lombok.*;
import uz.atm.entity.Auditable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 12/26/22 12:23 PM
 **/

@Entity(name = "founder_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "founder_address" )
public class FounderAddress extends Auditable {

    private String dsqId;

    private String countryCode;

    @Embedded
    private Region region;

    @Embedded
    private District district;

    private String sectorCode;

    private String village;

    private String streetName;

    private String house;

    private String flat;

    private String soatoCode;

}
