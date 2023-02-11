package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.entity.faunders.Founders;

/**
 * @author Shoxruh Bekpulatov
 * Time : 11/02/23
 */
public interface FoundersRepository extends JpaRepository<Founders, Long> {
}
