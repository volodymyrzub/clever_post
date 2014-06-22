package com.mobile.cleverpost.rest.persistence.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.SimpleExpression;

import com.mobile.cleverpost.rest.persistence.SessionAction;
import com.mobile.cleverpost.rest.persistence.SessionExecuter;
import com.mobile.cleverpost.rest.persistence.entities.Entity;

public class DAOManager {

	public static List<?> find(final String query, final Object[] objs)
			throws Exception {
		final Query queryObject[] = { null };
		SessionExecuter.execute(new SessionAction() {

			@Override
			public void execute(Session session) throws Exception {
				queryObject[0] = session.createQuery(query);
				if (objs != null) {
					for (int i = 0; i < objs.length; i++) {
						queryObject[0].setParameter(i, objs[i]);
					}
				}
			}
		});
		return queryObject[0].list();
	}

	public static void save(final Entity entity) throws Exception {
		SessionExecuter.execute(new SessionAction() {

			@Override
			public void execute(Session session) throws Exception {
				if (session.contains(entity)) {
					session.merge(entity);
				} else {
					session.saveOrUpdate(entity);
				}
			}
		});
	}

	public static void save(final Entity object, Long currentUser)
			throws Exception {
		SessionExecuter.execute(new SessionAction() {

			@Override
			public void execute(Session session) throws Exception {
				if (session.contains(object)) {
					session.merge(object);
				} else {
					session.saveOrUpdate(object);
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public static <T> T get(final Class<T> clazz, final Criterion[] criterions)
			throws Exception {
		final Criteria criteria[] = { null };
		SessionExecuter.execute(new SessionAction() {

			@Override
			public void execute(Session session) throws Exception {
				criteria[0] = session.createCriteria(clazz);
				if (criterions != null) {
					for (Criterion crit : criterions) {
						criteria[0].add(crit);
					}
				}
			}
		});
		return (T) criteria[0].uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public static <T extends Entity> T get(final Class<T> clazz,
			final Serializable id) throws Exception {
		final Entity entity[] = { null };
		SessionExecuter.execute(new SessionAction() {
			@Override
			public void execute(Session session) throws Exception {
				if (id == null || String.valueOf(id).isEmpty()) {
					entity[0] = (T) clazz.newInstance();
				} else {
					entity[0] = (T) session.get(clazz,
							Long.parseLong(String.valueOf(id)));
				}
			}
		});
		return (T) entity[0];
	}

	public static <T> T get(Class<T> clazz, SimpleExpression expression)
			throws Exception {
		return get(clazz, new Criterion[] { expression });
	}

	public static <T extends Entity> List<T> load(Class<T> clazz)
			throws Exception {
		return load(clazz, null);
	}

	public static List<Long> loadIds(Class<?> clazz, Criterion[] criterions)
			throws Exception {
		return loadIds(clazz, "id", criterions);
	}

	@SuppressWarnings("unchecked")
	public static List<Long> loadIds(final Class<?> clazz,
			final String idField, final Criterion[] criterions)
			throws Exception {
		final Criteria criteria[] = { null };
		SessionExecuter.execute(new SessionAction() {

			@Override
			public void execute(Session session) throws Exception {
				criteria[0] = session.createCriteria(clazz);
				criteria[0].setProjection(Projections.property(idField));
				if (criterions != null) {
					for (Criterion crit : criterions) {
						criteria[0].add(crit);
					}
				}

			}
		});
		return criteria[0].list();
	}

	public static <T extends Entity> List<T> load(Class<T> clazz,
			Criterion[] criterions) throws Exception {
		return load(clazz, criterions, null);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Entity> List<T> load(final Class<T> clazz,
			final Criterion[] criterions, final Integer maxResult)
			throws Exception {
		final List<Entity> list = new ArrayList<Entity>();
		SessionExecuter.execute(new SessionAction() {

			@Override
			public void execute(Session session) throws Exception {
				Criteria criteria = session.createCriteria(clazz);
				if (maxResult != null) {
					criteria.setMaxResults(maxResult);
				}
				if (criterions != null) {
					for (Criterion crit : criterions) {
						criteria.add(crit);
					}
				}
				for (Object object : criteria.list()) {
					list.add((Entity) object);
				}
			}
		});
		return (List<T>) list;
	}

	public static <T> void remove(final T object) throws Exception {
		SessionExecuter.execute(new SessionAction() {

			@Override
			public void execute(Session session) throws Exception {
				session.delete(object);
			}
		});
	}

	public static <T extends Entity> void remove(Class<T> clazz, Serializable id)
			throws Exception {
		remove(get(clazz, id));
	}

}
