package com.mobile.cleverpost.rest.client.test;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.mobile.cleverpost.rest.persistence.entities.Order;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class SavedOrderTest {
//	public static void main(String[] args) {
//		ClientConfig config = new DefaultClientConfig();
//		Client client = Client.create(config);
//		WebResource service = client
//				.resource("http://localhost:8085/RESTService/");
//
//		GenericType<List<Order>> genericType = new GenericType<List<Order>>() {
//		};
//		List<Order> messages = service.path("rest").path("SavedOrder")
//				.accept(MediaType.APPLICATION_XML).get(genericType);
//		System.out.println("------" + messages.size() + "------");
//		for (Order temp : messages) {
//			System.out.println(temp);
//		}
//		System.out.println("-----");
//
//		long id = 4;
//		Order message = service.path("rest").path("SavedOrder")
//				.path(String.valueOf(id)).accept(MediaType.APPLICATION_XML)
//				.get(Order.class);
//		System.out.println("Message with ID = " + id);
//		System.out.println(message);
//
//		System.out.println("puttin' message");
//		message = new Order();
//		message.setCount(21);
//		message.setDate(new Date());
//		message.setIngridientOrdered(true);
//
//		service.path("rest").path("SavedOrder")
//				.accept(MediaType.APPLICATION_XHTML_XML).put(message);
//
//		messages = service.path("rest").path("SavedOrder")
//				.accept(MediaType.APPLICATION_XML).get(genericType);
//
//		for (Order temp : messages) {
//			System.out.println(temp);
//		}
//	}
}
