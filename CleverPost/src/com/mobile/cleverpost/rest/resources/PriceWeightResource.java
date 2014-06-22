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
import com.mobile.cleverpost.rest.persistence.entities.PriceWeight;

@Path(com.mobile.cleverpost.rest.constants.Path.PRICE_WEIGHT)
public class PriceWeightResource {
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public PriceWeight get(@PathParam("id") long id) {
		PriceWeight item = null;
		try {
			item = DAOManager.get(PriceWeight.class, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<PriceWeight> getList() {
		List<PriceWeight> list = null;
		try {
			list = DAOManager.load(PriceWeight.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = -1;
		try {
			count = DAOManager.load(PriceWeight.class).size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(count);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void create(JAXBElement<PriceWeight> item) {
		try {
			DAOManager.save(item.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
