package com.analytics.mongodb.application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.analytics.mongodb.model.Tracking;
import com.analytics.mongodb.service.TrackingService;
import com.analytics.oracle.model.TrackingOracle;
import com.analytics.oracle.service.OracleDataService;

public class SampleSimpleApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleSimpleApplication.class);

	public static void main(String[] args) throws Exception {

		LOGGER.debug("Starting message");

		LOGGER.debug("Starting message");
		Writer fileWriter = new BufferedWriter(new FileWriter("c:/test/recordId.txt"));

		ApplicationContext context = new ClassPathXmlApplicationContext("MongoDBApp.xml");
		TrackingService trackingService = context.getBean(TrackingService.class);
		OracleDataService oracleDataService = context.getBean(OracleDataService.class);
		System.out.println(trackingService.getMaxTrackingId());

		List <TrackingOracle> trackingOracles = null;
		
		
		Long currentDbId = trackingService.getMaxTrackingId();
		
		
		do {
			
			LOGGER.debug("Current DB Id " +currentDbId );
			trackingOracles =oracleDataService.geTrackingsFromAboveRecordId(currentDbId, 100);
			
			if (trackingOracles!=null && trackingOracles.size()>0){
				trackingOracles.forEach(oracledb-> {
					LOGGER.debug("Adding object with Id " +oracledb.getRecordId() );
					 Tracking  tracking = new Tracking();
					tracking.setCreated(oracledb.getCreated());
					tracking.setRecordId(oracledb.getRecordId());
					tracking.setData(oracledb.getData());
					tracking.setEntityId(oracledb.getEntityId());
					tracking.setEventType(oracledb.getEventType());
					trackingService.createTracking(tracking);
					try {
						fileWriter.write(tracking.getRecordId() + "\n");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					LOGGER.debug("object Added Id " +oracledb.getRecordId() );
				});
				
				currentDbId = trackingService.getMaxTrackingId();
			
				LOGGER.debug("Updated DB Id " +currentDbId );
			}
			
		
		} while(trackingOracles!=null && trackingOracles.size()>0);
		fileWriter.flush();
		
		fileWriter.close();
		
		
		LOGGER.debug("End message");
		
	}

}