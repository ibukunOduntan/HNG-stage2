package com.Zuri2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  ZuriRepo extends JpaRepository<ZuriDomain, Long> {

    @Query("SELECT z from ZuriDomain z WHERE z.name = ?1")
    ZuriDomain findByName(String name);

    @Query("SELECT z from ZuriDomain z WHERE z.id = ?1")
    ZuriDomain findPersonById(Long id);




}
