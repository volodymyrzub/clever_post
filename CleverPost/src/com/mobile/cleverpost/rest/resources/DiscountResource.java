package com.mobile.cleverpost.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.Discount;

@Path(com.mobile.cleverpost.rest.constants.Path.DISCOUNT)
public class DiscountResource {
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Discount get(@PathParam("id") long id) {
		Discount item = null;
		try {
			item = DAOManager.get(Discount.class, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Discount> getList() {
		List<Discount> list = null;
		try {
			list = DAOManager.load(Discount.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * Method retuns the number of discounts
	 */
	// Use http://localhost:8080/restservice/rest/discount/count
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = -1;
		try {
			count = DAOManager.load(Discount.class).size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(count);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void create(JAXBElement<Discount> item) {
		try {
			DAOManager.save(item.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
