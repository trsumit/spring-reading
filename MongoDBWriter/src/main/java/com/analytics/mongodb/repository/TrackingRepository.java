package com.analytics.mongodb.repository;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.analytics.mongodb.model.Tracking;

public interface TrackingRepository extends PagingAndSortingRepository<Tracking, BigInteger>  {
 
//	//{ 'sort' : { '_id':-1}, 'limit' : 1}}
//	public Tracking findTrackingWithMaxId();
//	
    
}