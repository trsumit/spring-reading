package com.analytics.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.analytics.oracle.model.TrackingOracle;
import com.analytics.oracle.repository.OracleDaoRepository;

@Service(value="OracleDataBaseService")
public class OracleDataService {
		
	
	@Autowired
	private OracleDaoRepository oracleDaoRepository;
	
	
	public Long getMaxIdFromDB(){
		return oracleDaoRepository.getMaxEventId();
	}

	public Long getMinIdFromDB(){
		return oracleDaoRepository.getMinEventId();
		
	}

	public List<TrackingOracle>  geTrackingsByRecordId(Long id){
		Sort sort = new Sort(Direction.DESC, "recordId");
		Pageable pageable = new PageRequest(1, 100 ,sort);
		return oracleDaoRepository.geTrackingsByRecordId(id, pageable);
		
	}

	public List<TrackingOracle>  geTrackingsFromAboveRecordId(Long id){
		return geTrackingsFromAboveRecordId(id, 10);
	}

	public List<TrackingOracle>  geTrackingsFromAboveRecordId(Long id , int pageSize){
		Sort sort = new Sort(Direction.ASC, "recordId");
		Pageable pageable = new PageRequest(0, pageSize ,sort);
		return oracleDaoRepository.geTrackingsByRecordId(id, pageable);
	}
	
	public List<TrackingOracle>  geTrackingsByRecordId(Long minId , Long maxId){
		Sort sort = new Sort(Direction.DESC, "recordId");
		Pageable pageable = new PageRequest(0, 10 ,sort);
		return oracleDaoRepository.geTrackingsByBetweenId( minId ,  maxId, pageable);
	}
	
	
}
