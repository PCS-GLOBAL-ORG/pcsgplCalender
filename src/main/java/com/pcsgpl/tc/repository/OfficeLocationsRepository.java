package com.pcsgpl.tc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pcsgpl.tc.entity.OfficeLocationsEntity;

@Repository
public interface OfficeLocationsRepository extends JpaRepository<OfficeLocationsEntity,Integer> {

	//public List<OfficeLocationsEntity>lov(); 
}
