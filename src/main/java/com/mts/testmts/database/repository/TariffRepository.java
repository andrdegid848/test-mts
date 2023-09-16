package com.mts.testmts.database.repository;

import com.mts.testmts.database.entity.Tariff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Integer> {
    Page<Tariff> findAll(Pageable pageable);
    Tariff findByTitle(String title);
}
