package com.mobile.cleverpost.rest.client.test;

import javax.ws.rs.core.MediaType;

import com.mobile.cleverpost.rest.constants.Path;
import com.mobile.cleverpost.rest.persistence.entities.Order;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RestTest {
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(Path.URI);

		long id = 4;
		Order message = service.path("rest").path("SavedOrder")
				.path(String.valueOf(id)).accept(MediaType.APPLICATION_XML)
				.get(Order.class);
		System.out.println("Message with ID = " + id);
		System.out.println(message);

		// GenericType<List<SavedOrder>> genericType = new
		// GenericType<List<SavedOrder>>() {
		// };
		// List<SavedOrder> messages = service.path("rest").path("saved-order")
		// .accept(MediaType.APPLICATION_XML).get(genericType);
		//
		// for (SavedOrder temp : messages) {
		// System.out.println(temp);
		// }

		// SavedOrder savedOrder = new SavedOrder(2, 1003500, false);
		// savedOrder.setId(1l);
		// ClientResponse response = service.path("rest").path("saved-order")
		// .path(savedOrder.getId().toString())
		// .accept(MediaType.APPLICATION_XML)
		// .put(ClientResponse.class, savedOrder);
		// Form form = new Form();
		// form.add("product_id", "1");
		// form.add("count", "98");
		// form.add("parameter_group_id", "2");
		// form.add("date", "100500");
		// form.add("isIngridientOrdered", "false");
		// response = service.path("rest").path("saved-order")
		// .type(MediaType.APPLICATION_FORM_URLENCODED)
		// .post(ClientResponse.class, form);
		// System.out.println("Form response " +
		// response.getEntity(String.class));
		// Get the all todos, id 4 should be created
		// System.out.println(service.path("rest").path("saved-order")
		// .accept(MediaType.APPLICATION_XML).get(String.class));
	}
}
