package com.orderfilter.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderfilter.models.OrderHeader;

@Service
public class FileOperations {

	private static final Logger log = LoggerFactory.getLogger(FileOperations.class);

	public void generateFile(List<OrderHeader> filteredOrderList, String fileName) {
		log.debug("generating filtered file at "+Constants.FILE_LOCATION_OUTPUT + fileName);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String result = mapper.writeValueAsString(filteredOrderList);
			BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.FILE_LOCATION_OUTPUT + fileName));
			writer.write(result);
			writer.close();
		} catch (IOException e) {
			log.error(e.getLocalizedMessage());
		}
	}

	public ResponseEntity<Resource> downloadFile(File outputFile, String fileName) {
		InputStreamResource resource;
		try {
			resource = new InputStreamResource(new FileInputStream(outputFile));
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
					.contentLength(outputFile.length())
					.contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
		} catch (FileNotFoundException e) {
			log.error(e.getLocalizedMessage());
		}
		return null;

	}

}
