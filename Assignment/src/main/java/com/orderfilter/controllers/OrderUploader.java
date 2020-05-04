package com.orderfilter.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.orderfilter.models.OrderHeader;
import com.orderfilter.service.OrderFilter;
import com.orderfilter.utilities.Constants;
import com.orderfilter.utilities.FileOperations;

/*
 * Controller is responsible for providing api for uploading json file containing list of orders
 */

@Controller
public class OrderUploader {

	@Autowired
	OrderFilter orderFilter;

	@Autowired
	FileOperations fileOperations;

	private static final Logger log = LoggerFactory.getLogger(OrderUploader.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String uploadPage() {
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> uploadOrderJSON(@RequestParam("file") MultipartFile file) {
		log.info("received file for filtering processing..");
		try {
			if (file != null && file.getSize() > 0) {

				// fetch filename
				String fileName = StringUtils.cleanPath(file.getOriginalFilename());
				String outPutFileName = fileName = Constants.FILE_NAME_OUTPUT_APPEND + fileName;

				// process input file
				OrderHeader[] orderArray = orderFilter.processInputFileStream(file.getInputStream());

				// filter orders
				List<OrderHeader> filteredOrderList = orderFilter.filterOrders(orderArray);

				// generate filtered orders' file
				fileOperations.generateFile(filteredOrderList, outPutFileName);

				// download generated file
				File outputFile = new File(Constants.FILE_LOCATION_OUTPUT + outPutFileName);
				log.info("downloading processed file");
				return fileOperations.downloadFile(outputFile, outPutFileName);

			}
		} catch (IOException e) {
			log.error(e.getLocalizedMessage());

		}
		return null;
	}
}
