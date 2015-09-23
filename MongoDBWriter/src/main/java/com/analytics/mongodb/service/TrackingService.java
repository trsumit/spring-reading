package com.analytics.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.analytics.mongodb.model.Tracking;
import com.analytics.mongodb.repository.TrackingRepository;

@Component
public class TrackingService{


	@Autowired
	private TrackingRepository repository;

	public void createTracking(Tracking tracking) {
		repository.save(tracking);

	}
	

	public Long getMaxTrackingId() {
		
		Sort sort  = new Sort(Direction.DESC  , "_id");
		
		
		Pageable pageable = new PageRequest(0, 1,sort);
		
		List<Tracking> trackings = repository.findAll(pageable).getContent();

		if (trackings.size()>0){
			return trackings.get(0).getRecordId() ;	
		} else {
			return 0l;
		}
		
		

	}

}