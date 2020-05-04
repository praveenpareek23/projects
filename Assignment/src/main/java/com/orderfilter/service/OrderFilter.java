package com.orderfilter.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderfilter.models.OrderHeader;
import com.orderfilter.utilities.DeliveryType;

/*
 * Class is responsible for processing input file and filter orders based on provided criteria
 */
@Service
public class OrderFilter {
	private static final Logger log = LoggerFactory.getLogger(OrderFilter.class);

	// method uses object mapper to convert inputstream in OrderHeader objects

	public OrderHeader[] processInputFileStream(InputStream orderInputStream) {
		log.debug("converting inputstream into OrderHeader object");
		ObjectMapper mapper = new ObjectMapper();
		InputStreamReader isReader = new InputStreamReader(orderInputStream);
		BufferedReader reader = new BufferedReader(isReader);
		StringBuffer sb = new StringBuffer();
		String str;
		try {
			while ((str = reader.readLine()) != null) {
				sb.append(str);
			}
			return mapper.readValue(sb.toString(), OrderHeader[].class);
		} catch (IOException e) {
			log.error(e.getLocalizedMessage());
		}
		return null;
	}

	// method will filter orders based on their 'Delivery Types'
	public List<OrderHeader> filterOrders(OrderHeader[] orderArray) {
		log.debug("filtering orders");
		List<OrderHeader> filteredOrderList = new ArrayList<>();
		if (orderArray.length > 0) {
			for (OrderHeader order : orderArray) {
				if (DeliveryType.EXPRESS.toString().equals(order.getDeliveryType())) {
					filteredOrderList.add(order);
				}
			}
		}
		return filteredOrderList;
	}

}
