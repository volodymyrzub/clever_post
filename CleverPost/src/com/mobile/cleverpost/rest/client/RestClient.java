package com.mobile.cleverpost.rest.client;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.mobile.cleverpost.rest.constants.Path;
import com.mobile.cleverpost.rest.persistence.entities.Entity;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RestClient {
	private static WebResource service;

	public RestClient(String path) {
		if (service == null) {
			service = Client.create(new DefaultClientConfig()).resource(path);
		}
	}

	public void insert(Entity item) {
		service.path(Path.ROOT).path(item.getClass().getSimpleName())
				.accept(MediaType.APPLICATION_XHTML_XML).put(item);
	}

	public <T> List<T> getAll(final Class<T> clazz) {

		ParameterizedType parameterizedGenericType = new ParameterizedType() {
			public Type[] getActualTypeArguments() {
				return new Type[] { clazz };
			}

			public Type getRawType() {
				return List.class;
			}

			public Type getOwnerType() {
				return List.class;
			}
		};

		GenericType<List<T>> genericType = new GenericType<List<T>>(
				parameterizedGenericType) {
		};
		return service.path(Path.ROOT).path(clazz.getSimpleName())
				.accept(MediaType.APPLICATION_XML).get(genericType);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Entity get(Class clazz, Long id) {
		return service.path(Path.ROOT).path(clazz.getSimpleName())
				.path(String.valueOf(id)).accept(MediaType.APPLICATION_XML)
				.get(clazz);
	}
}
