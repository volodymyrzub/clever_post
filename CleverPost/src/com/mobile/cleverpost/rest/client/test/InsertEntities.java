package com.mobile.cleverpost.rest.client.test;

import java.util.Date;

import com.mobile.cleverpost.rest.client.RestClient;
import com.mobile.cleverpost.rest.constants.Path;
import com.mobile.cleverpost.rest.persistence.entities.DeliveryArea;
import com.mobile.cleverpost.rest.persistence.entities.Discount;
import com.mobile.cleverpost.rest.persistence.entities.Ingredient;
import com.mobile.cleverpost.rest.persistence.entities.Order;
import com.mobile.cleverpost.rest.persistence.entities.Parameter;
import com.mobile.cleverpost.rest.persistence.entities.ParameterGroup;
import com.mobile.cleverpost.rest.persistence.entities.PriceWeight;
import com.mobile.cleverpost.rest.persistence.entities.Product;
import com.mobile.cleverpost.rest.persistence.entities.Restaurant;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Discarder;

public class InsertEntities {
	public static void main(String[] args) {
		RestClient rest = new RestClient(Path.URI);

		// DeliveryArea d = new DeliveryArea();
		// d.setCost(100d);
		// d.setMinOrder(60d);
		// d.setName("asdfadsf");
		// d.setName("AAAAAAAAAA");
		//
		// rest.insert(d);
		//
		// Discount d1 = new Discount();
		// d1.setName("aaaaaaaaaaaasfadsfas");
		// d1.setPicture("adsfsadgdsfgdfs");
		// rest.insert(d1);
		//
		// Ingredient i = new Ingredient();
		// i.setIsHit(true);
		// i.setIsNew(true);
		// i.setName("sadfasdfasdf");
		// i.setPicture("sadfadsf");
		// i.setPrice(324d);
		// i.setWeight(3463d);
		// rest.insert(i);

//		IngredientGroup ig = new IngredientGroup();
//		ig.setName("adsfasdfadsf");
//		ig.setPicture("dfsgsdf");
//		rest.insert(ig);

		// Parameter p = new Parameter();
		// p.setName("sdafadsf");
		// p.setMeasurements("sadfsadfas");
		// p.setPicture("sdafaaaaaaaaaaaaaaaa");
		// p.setValue(234324d);
		// rest.insert(p);
		//
		// ParameterGroup pg = new ParameterGroup();
		// pg.setName("dasfaas");
		// pg.setPicture("aaaaaaaaaaa");
		// rest.insert(pg);
		//
		// PriceWeight pw = new PriceWeight();
		// pw.setPrice(2131d);
		// pw.setWeight(2134d);
		// rest.insert(pw);
		//
		// Product pp = new Product();
		// pp.setAbout("dasfdasf");
		// pp.setIsEditable(true);
		// pp.setIsFavourite(false);
		// pp.setIsNew(true);
		// pp.setIsHit(true);
		// pp.setName("asdfadsfasdfsadf");
		// rest.insert(pp);
		//
		// Restaurant r = new Restaurant();
		// r.setAddress("aaaaaaaaaaa");
		// r.setName("sssssssssssss");
		// r.setStartTime(new Date());
		// rest.insert(r);
		//
		// SavedIngridientOrder sio = new SavedIngridientOrder();
		// sio.setCount(10);
		// rest.insert(sio);
		//
		// SavedOrder s = new SavedOrder();
		// rest.insert(s);
	}
}
