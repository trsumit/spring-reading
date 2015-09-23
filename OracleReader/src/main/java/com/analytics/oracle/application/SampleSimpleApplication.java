package com.analytics.oracle.application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.analytics.oracle.model.TrackingOracle;
import com.analytics.oracle.service.OracleDataService;

public class SampleSimpleApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleSimpleApplication.class);

	public static void main(String[] args) throws Exception {

		LOGGER.debug("Starting message");
		Writer fileWriter = new BufferedWriter(new FileWriter("c:/test/recordId.txt"));

		ApplicationContext context = new ClassPathXmlApplicationContext("OracleDataSource.xml");

		// OracleDataBaseService

		OracleDataService oracleDataService = context.getBean(OracleDataService.class);

		System.out.println(oracleDataService.getMinIdFromDB());

		Long minId = oracleDataService.getMinIdFromDB();

		LOGGER.debug("DataBase Min Id : " + minId);

		List<TrackingOracle> trackings = null;

		trackings = oracleDataService.geTrackingsFromAboveRecordId(49381L , 100);
		LOGGER.debug("DataBase Record : " + trackings);

		trackings.forEach(tracking -> {
			
			JSONObject xmlJSONObj = XML.toJSONObject(tracking.getData());
			
			System.out.println(" main Message " + xmlJSONObj );
			
			JSONObject messageJSONObj = (JSONObject)xmlJSONObj.get("Message");
			messageJSONObj.keySet().forEach(x -> {
				if (!x.equalsIgnoreCase("EventType")){
					System.out.println(( (JSONObject)messageJSONObj.get(x)).keySet());
				}
			});
			
			xmlJSONObj.put("RecordId",tracking.getRecordId() );
		});

		LOGGER.debug("DataBase Record : " + trackings);
		fileWriter.flush();
		fileWriter.close();

	

	}

}