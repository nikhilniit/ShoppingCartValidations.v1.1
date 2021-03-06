package com.niit.ShoppingCart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.Supplier;

@EnableTransactionManagement
@Repository(value="supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	private static final Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);
	//private static final Logger log= LoggerFactory.getLogger("com.niit.ShoppingCart.dao.SupplierDAOImpl);
	@Autowired
private SessionFactory sessionFactory;
public SupplierDAOImpl(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;
}
@Transactional
public boolean save(Supplier supplier){
try {
	log.debug("starting of method save");
	sessionFactory.getCurrentSession().save(supplier);
	log.debug("ending of method save");
	return true;
} catch (Exception e) {
	log.error("exception occured in save method"+e.getMessage());
	e.printStackTrace();
return false;}

}
@Transactional
public boolean update(Supplier supplier){
	try {
		log.debug("starting of method update");
		sessionFactory.getCurrentSession().update(supplier);
		log.debug("ending of method update");
		return true;
	} catch (Exception e) {
		log.error("exception occured in update method"+e.getMessage());
		e.printStackTrace();
	
	return false;
	}	
}
@Transactional
public boolean delete(Supplier supplier){
	try {
		log.debug("starting of method delete");
		sessionFactory.getCurrentSession().delete(supplier);
		log.debug("starting of method delete");
		return true;
	} catch (Exception e) {
		log.error("exception occured in delete method"+e.getMessage());
		e.printStackTrace();
		return false;
	}
	

	
}
@Transactional
public Supplier get(String id){
	log.debug("starting of the method get");
	log.info("tryimg to get product based on id:"+id);
	String hql="from Supplier where id="+"'"+id+"'";
	log.info("the hql query is:"+hql);
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Supplier> list=  query.list();
	if(list==null||list.isEmpty()){
		log.info("no suppliers are available with this id"+id);
	return null;
	}else {
		return list.get(0);
	}	
}
@Transactional
public List<Supplier> list(){
	log.debug("starting of the method list");
	String hql="from Supplier";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	log.debug("starting of the method list");
	List<Supplier> list=  query.list();
	if(list==null||list.isEmpty()){
		log.info("no suppliers are available");
	
	}
	return list;
}
}