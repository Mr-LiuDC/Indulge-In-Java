package cn.alittler.sshbase.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @description: BaseDaoImpl<T>
 * @author: Mr-LiuDC
 *
 * @param <T>
 */
@SuppressWarnings({ "unchecked" })
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	// private Class<T> clazz = null; // 这是一个问题。
	private Class<T> clazz;

	// 解决问题
	public BaseDaoImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的泛型的父类类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		System.out.println("clazz-----> " + clazz);
	}

	/**
	 * 获取当前可用的Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void delete(Long id) {
		Object object = getById(id);
		if (object != null) {
			getSession().delete(object);
		}
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public T getById(Long id) {
		return getSession().get(clazz, id);
	}

	public List<T> getByIds(Long[] ids) {
		return getSession().createQuery( //
				"FROM " + clazz.getSimpleName() + "WHERE id IN (:ids)") //
				.setParameterList("ids", ids) //
				// .list() //Hibernate5.2.2不鼓励这样写
				.getResultList();
	}

	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				// .list() //
				.getResultList();
	}

}
