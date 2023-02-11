package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.entity.juridicInfo.JuridicInfo;

/**
 * @author Shoxruh Bekpulatov
 * Time : 11/02/23
 */
public interface JuridicInfoRepository extends JpaRepository<JuridicInfo, Long> {
}
