package uz.atm.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.atm.dto.DataDto;
import uz.atm.entity.Tins;
import uz.atm.entity.faunders.Founders;
import uz.atm.entity.juridicInfo.JuridicInfo;
import uz.atm.repository.TinsRepository;
import uz.atm.service.FoundersService;
import uz.atm.service.JuridicInfoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shoxruh Bekpulatov
 * Time : 11/02/23
 */
@RestController
@RequestMapping("/live/org-info")
public class BaseController {


    private final JuridicInfoService juridicInfoService;

    private final FoundersService foundersService;

    private final TinsRepository tinsRepository;

    public BaseController( JuridicInfoService juridicInfoService, FoundersService foundersService, TinsRepository tinsRepository ) {
        this.juridicInfoService = juridicInfoService;
        this.foundersService = foundersService;
        this.tinsRepository = tinsRepository;
    }

    @GetMapping("/fill-database")
    public ResponseEntity<Boolean> start() {
        Long countByIsJuridicDoneFalse = tinsRepository.countByIsJuridicDoneFalseAndIsFoundersDoneFalse();

        List<Thread> threads = new ArrayList<>();
        for ( int i = 0; i < 100; i++ ) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                List<Tins> tins =
                        tinsRepository.findAllByIsFoundersDoneFalseAndIsJuridicDoneFalse(PageRequest.of(finalI, (int) ( countByIsJuridicDoneFalse / 100 )));
                for ( Tins tin : tins ) {
                    DataDto<JuridicInfo> dataDto =
                            juridicInfoService.getJuridicEntityInfo(Long.valueOf(tin.getTin()));
                    if ( dataDto.success ) {
                        juridicInfoService.save(dataDto.body);
                        tinsRepository.updateIsJuridicDone(tin.getTin());
                    }
                    DataDto<List<Founders>> dto = foundersService.getFounders(tin.getTin());
                    if ( dto.success ) {
                        foundersService.saveAll(dto.body);
                        tinsRepository.updateIsFoundersDone(tin.getTin());
                    }
                }
            });
            threads.add(thread);
        }
        for ( Thread thread : threads ) {
            thread.start();
        }
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @GetMapping("/test/{tin}")
    public ResponseEntity<?> test( @PathVariable("tin") Long tin ) {
        DataDto<JuridicInfo> dataDto =
                juridicInfoService.getJuridicEntityInfo(tin);
        if ( dataDto.success ) {
            juridicInfoService.save(dataDto.body);
            tinsRepository.updateIsJuridicDone(tin.toString());
        }
        DataDto<List<Founders>> dto = foundersService.getFounders(tin.toString());
        if ( dto.success ) {
            foundersService.saveAll(dto.body);
            tinsRepository.updateIsFoundersDone(tin.toString());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("juridic", dataDto.body);
        map.put("founders", dto.body);
        return ResponseEntity.ok(map);
    }
}
