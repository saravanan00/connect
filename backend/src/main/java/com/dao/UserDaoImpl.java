package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
private SessionFactory sessionFactory;
	@Override
	public void registerUser(User user) {
		System.out.println("registeruser in dao" +user);
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
	}
	@Override
	public boolean isEmailUnique(String email) {
		Session session=sessionFactory.getCurrentSession();
	User user =(User)session.get(User.class,email);
	if(user==null)
		return true;
	else
		return false;
	}
	@Override
	public User login(User user) {
	
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=? and password=?");
		query.setString(0, user.getEmail());
		query.setString(1, user.getPassword());
		return (User)query.uniqueResult();
		
	}
	@Override
	public void update(User validUser) {
		Session session=sessionFactory.getCurrentSession();
		session.update(validUser);
		
	}
	@Override
	public User getUser(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		return user;
	}
	@Override
	public Void updateUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.update(user);
		return null;
	}
	@Override
	public List<User> searchUser(String name) {
		System.out.println(name);
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User u where u.firstname like ? or u.lastname like ? or u.email like ? or u.phonenumber like ?");
		query.setString(0,"%"+name+ "%");
		query.setString(1,"%"+name+ "%");
		query.setString(2,"%"+name+ "%");
		List<User>users=query.list();
		return users;
	}
	
	

}
