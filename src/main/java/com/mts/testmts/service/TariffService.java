package com.mts.testmts.service;

import com.mts.testmts.parser.TariffParser;
import com.mts.testmts.database.entity.Tariff;
import com.mts.testmts.database.repository.TariffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TariffService {

    private final TariffRepository tariffRepository;

    private final TariffParser tariffParser;

    public Page<Tariff> findAll(Pageable pageable) {
        return tariffRepository.findAll(pageable);
    }

    public void update() {
        Tariff currentTariff;
        List<Tariff> tariffs = tariffParser.parse();
        for (var tariff : tariffs) {
            currentTariff = tariffRepository.findByTitle(tariff.getTitle());
            if (currentTariff == null) {
                tariffRepository.saveAndFlush(tariff);
                continue;
            }
            currentTariff.setTitle(tariff.getTitle());
            currentTariff.setDescription(tariff.getDescription());
            currentTariff.setPrice(tariff.getPrice());
            tariffRepository.saveAndFlush(currentTariff);
        }
    }
}
