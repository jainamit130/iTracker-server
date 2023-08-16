package com.accolitedigital.iTracker.JsonUtil;

import com.fasterxml.jackson.core.JsonGenerator;
import org.apache.commons.lang3.StringUtils;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;


@Component
public class JsonUtil {
	@Value("src/test/java/com/accolitedigital/iTracker/service")
	private String jsonInterviewMockPath;
	public static final String Mock="mock";
	private static final Logger logger=LoggerFactory.getLogger(JsonUtil.class);
	public byte[] getData(String packageName,String filename,String path) throws IOException{
		String filePath=StringUtils.EMPTY;
		if(Mock.equals(path)) {
			filePath= jsonInterviewMockPath +"/"+packageName+"/"+filename+".json";
		}
		//logger.info("File path is****{}",filePath);
		Path pathObj=Paths.get(filePath);
		return Files.readAllBytes(pathObj);
	}
	public JsonGenerator writeData(String packageName,String filename, String path, String interviews) throws IOException{
		String filePath=StringUtils.EMPTY;
		if(Mock.equals(path)) {
			filePath= jsonInterviewMockPath +"/"+packageName+"/"+filename+".json";
		}
		//logger.info("File path is****{}",filePath);
		Path pathObj=Paths.get(filePath);
		Files.write(pathObj, Collections.singleton(interviews));
		return null;
	}
}
