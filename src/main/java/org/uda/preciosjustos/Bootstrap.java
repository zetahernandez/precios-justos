package org.uda.preciosjustos;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.uda.preciosjustos.dao.ProductDao;
import org.uda.preciosjustos.dao.UnitDao;
import org.uda.preciosjustos.model.Product;
import org.uda.preciosjustos.model.Unit;

@Component
public class Bootstrap {

	@Autowired
	private UnitDao unitDao;
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	@Qualifier("transactionManager")
	protected PlatformTransactionManager txManager;
	
	@PostConstruct
	public void initializeDataBase() {
		
		  TransactionTemplate tmpl = new TransactionTemplate(txManager);
	        tmpl.execute(new TransactionCallbackWithoutResult() {
	            @Override
	            protected void doInTransactionWithoutResult(TransactionStatus status) {
	            	Unit unit = null;
	        		
	        		if(unitDao.findByName("kilo") == null){
	        			unit = new Unit("kilo");
	        			unitDao.saveOrUpdate(unit);
	        		}
	        		
	        		if(productDao.findByName("manzana") == null){
	        			productDao.saveOrUpdate(new Product("manzana",unit));	
	        		}
	        		
	        		if(productDao.findByName("tomate") == null){
	        			productDao.saveOrUpdate(new Product("tomate",unit));	
	        		}
	        		
	        		if(productDao.findByName("pan") == null){
	        			productDao.saveOrUpdate(new Product("pan",unit));	
	        		}
	        		
	        		if(productDao.findByName("mandarina") == null){
	        			productDao.saveOrUpdate(new Product("mandarina",unit));	
	        		}
	        		
	        		if(productDao.findByName("pera") == null){
	        			productDao.saveOrUpdate(new Product("pera",unit));	
	        		}
	        		
	        		if(productDao.findByName("pan") == null){
	        			productDao.saveOrUpdate(new Product("tomate",unit));	
	        		}
	        		
	        		if(productDao.findByName("zanahoria") == null){
	        			productDao.saveOrUpdate(new Product("tomate",unit));	
	        		}
	        		
	        		if(productDao.findByName("asado") == null){
	        			productDao.saveOrUpdate(new Product("asado",unit));	
	        		}
	            }
	        });
		
		
	}
}
