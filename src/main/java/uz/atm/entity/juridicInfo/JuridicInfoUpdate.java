package uz.atm.entity.juridicInfo;

import lombok.*;
import uz.atm.entity.Auditable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 12/26/22 5:40 PM
 **/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "juridic_info_update_dsq")
public class JuridicInfoUpdate extends Auditable {

    private String sendType;

    @Embedded
    private JuridicData data;

    private String transactionId;

    private Date date;

    private Boolean success;

    private String projectType;

//    @Column(columnDefinition = "DEFAULT false")
    private Boolean updated = false;

    @Data
    @Embeddable
    public static class JuridicData {

        private Long tin;

    }

}
