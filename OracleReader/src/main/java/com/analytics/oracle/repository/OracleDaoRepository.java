package com.analytics.oracle.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.analytics.oracle.model.TrackingOracle;

public interface OracleDaoRepository extends CrudRepository<TrackingOracle, Long> {

	@Query("SELECT max(p.recordId) FROM TrackingOracle as p")
	public Long getMaxEventId();
	
	
	@Query("SELECT min(p.recordId) FROM TrackingOracle as p")
	public Long getMinEventId();
	
	
	
	@Query(" FROM TrackingOracle as p where p.recordId > :id")
	public List<TrackingOracle>  geTrackingsByRecordId(@Param("id") Long id , Pageable pageable  );

	@Query(" FROM TrackingOracle as p where p.recordId BETWEEN  :minId and :maxId")
	public List<TrackingOracle>  geTrackingsByBetweenId(@Param("minId") Long minId , @Param("maxId") Long maxId  , Pageable pageable  );

	
	//53450
	
}
