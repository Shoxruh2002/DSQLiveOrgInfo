package uz.atm.entity.juridicInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import uz.atm.entity.Auditable;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 23/08/22
 * Time: 11:25
 */

@Entity( name = "juridic_info_responses_dsq" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties( ignoreUnknown = true )
@Table(  name = "juridic_info_responses_dsq" )
public class JuridicInfo extends Auditable {

    @Embedded
    private Company company;

    private String extraActivityTypes;

    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn( name = "juridic_info_response_id" )
    private List<CompanyBank> companyBanks;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "company_billing_address_id" )
    private Address companyBillingAddress;

    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn( name = "juridic_info_response_id" )
    private List<Address> companyShippingAddress;

    @Embedded
    private CompanyExtraInfo companyExtraInfo;

    @Embedded
    private Director director;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "director_address_id" )
    private Address directorAddress;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "director_contact_id" )
    private Contact directorContact;

    @Embedded
    private Accountant accountant;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "accountant_address_id" )
    private Address accountantAddress;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "accountant_contact_id" )
    private Contact accountantContact;

}
