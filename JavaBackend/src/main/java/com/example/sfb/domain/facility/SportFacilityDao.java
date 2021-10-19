package com.example.sfb.domain.facility;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportFacilityDao extends CrudRepository<SportFacility, Integer> {
}
