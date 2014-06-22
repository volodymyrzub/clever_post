package com.mobile.cleverpost.rest.persistence.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mobile.cleverpost.rest.helpers.PercentFormatHelper;
import com.mobile.cleverpost.rest.persistence.dao.security.entities.UserRole;
import com.mobile.cleverpost.rest.persistence.entities.Addition;
import com.mobile.cleverpost.rest.persistence.entities.AdditionCategory;
import com.mobile.cleverpost.rest.persistence.entities.DeliveryArea;
import com.mobile.cleverpost.rest.persistence.entities.Discount;
import com.mobile.cleverpost.rest.persistence.entities.GroupSocialNetwork;
import com.mobile.cleverpost.rest.persistence.entities.Ingredient;
import com.mobile.cleverpost.rest.persistence.entities.Order;
import com.mobile.cleverpost.rest.persistence.entities.OrderProduct;
import com.mobile.cleverpost.rest.persistence.entities.Parameter;
import com.mobile.cleverpost.rest.persistence.entities.ParameterCategory;
import com.mobile.cleverpost.rest.persistence.entities.ParameterGroup;
import com.mobile.cleverpost.rest.persistence.entities.Post;
import com.mobile.cleverpost.rest.persistence.entities.PriceWeight;
import com.mobile.cleverpost.rest.persistence.entities.Product;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategory;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategoryAddition;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategoryParameter;
import com.mobile.cleverpost.rest.persistence.entities.ProductIngredient;
import com.mobile.cleverpost.rest.persistence.entities.Restaurant;
import com.mobile.cleverpost.rest.persistence.entities.StatisticGroup;

@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static void addAnnotatedClasses(AnnotationConfiguration config) {
//		config.addAnnotatedClass(Addition.class);
//		config.addAnnotatedClass(AdditionCategory.class);
//		config.addAnnotatedClass(DeliveryArea.class);
//		config.addAnnotatedClass(Discount.class);
//		config.addAnnotatedClass(Ingredient.class);
//		config.addAnnotatedClass(Order.class);
//		config.addAnnotatedClass(OrderProduct.class);
//		config.addAnnotatedClass(Parameter.class);
//		config.addAnnotatedClass(ParameterCategory.class);
//		config.addAnnotatedClass(ParameterGroup.class);
//		config.addAnnotatedClass(PriceWeight.class);
//		config.addAnnotatedClass(Product.class);
//		config.addAnnotatedClass(ProductCategory.class);
//		config.addAnnotatedClass(ProductCategoryAddition.class);
//		config.addAnnotatedClass(ProductCategoryParameter.class);
//		config.addAnnotatedClass(ProductIngredient.class);
//		config.addAnnotatedClass(Restaurant.class);
		config.addAnnotatedClass(com.mobile.cleverpost.rest.persistence.dao.security.entities.User.class);
		config.addAnnotatedClass(UserRole.class);
		config.addAnnotatedClass(Post.class);
		config.addAnnotatedClass(StatisticGroup.class);
		config.addAnnotatedClass(GroupSocialNetwork.class);
		
	}

	public static synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				AnnotationConfiguration config = new AnnotationConfiguration();
				HibernateUtil.addAnnotatedClasses(config);
				config.configure();
				Map<String, String> params = new HashMap<String, String>();

				params.put(
						"host",
						String.valueOf(config.getProperties().get(
								"hibernate.connection.host")));
				params.put(
						"database",
						String.valueOf(config.getProperties().get(
								"hibernate.connection.database")));

				config.getProperties().put(
						"hibernate.connection.url",
						PercentFormatHelper.format(
								String.valueOf(config.getProperties().get(
										"hibernate.connection.url.template")),
								params));

				sessionFactory = config.buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed."
						+ ex);
				throw new ExceptionInInitializerError(ex);
			}
		}

		if (sessionFactory.isClosed()) {
			cleanFactory();
		}

		return sessionFactory;
	}

	public static void cleanFactory() {
		try {
			if (sessionFactory != null && !sessionFactory.isClosed()) {
				sessionFactory.close();
			}
			AnnotationConfiguration config = new AnnotationConfiguration();
			HibernateUtil.addAnnotatedClasses(config);
			config.configure();
			Map<String, String> params = new HashMap<String, String>();

			params.put(
					"host",
					String.valueOf(config.getProperties().get(
							"hibernate.connection.host")));
			params.put(
					"database",
					String.valueOf(config.getProperties().get(
							"hibernate.connection.database")));

			config.getProperties().put(
					"hibernate.connection.url",
					PercentFormatHelper.format(
							String.valueOf(config.getProperties().get(
									"hibernate.connection.url.template")),
							params));

			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
