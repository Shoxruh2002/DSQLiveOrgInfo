package uz.atm.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.atm.entity.Tins;

import java.util.List;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 11/28/22 10:53 AM
 **/
public interface TinsRepository extends JpaRepository<Tins, Long> {


    List<Tins> findAllByIsJuridicDoneFalse();

    List<Tins> findAllByIsJuridicDoneFalse( Pageable pageable );

    List<Tins> findAllByIsFoundersDoneFalse();

    List<Tins> findAllByIsFoundersDoneFalse( Pageable pageable );

    List<Tins> findAllByIsFoundersDoneFalseAndIsJuridicDoneFalse();

    List<Tins> findAllByIsFoundersDoneFalseAndIsJuridicDoneFalse( Pageable pageable );

    Long countByIsJuridicDoneFalse();

    Long countByIsJuridicDoneFalseAndIsFoundersDoneFalse();

    Long countByIsFoundersDoneFalse();

    @Modifying
    @Transactional
    @Query("update Tins t set t.isJuridicDone =true where t.tin = ?1")
    void updateIsJuridicDone( @Param("inn") String inn );

    @Modifying
    @Transactional
    @Query("update Tins t set t.isFoundersDone =true where t.tin = ?1")
    void updateIsFoundersDone( @Param("inn") String inn );
}
