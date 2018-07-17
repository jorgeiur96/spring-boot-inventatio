package com.jorge.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jorge.springboot.app.models.dao.IClienteDao;
import com.jorge.springboot.app.models.dao.IFacturaDao;
import com.jorge.springboot.app.models.dao.IProductoDao;
import com.jorge.springboot.app.models.entity.Cliente;
import com.jorge.springboot.app.models.entity.Factura;
import com.jorge.springboot.app.models.entity.Producto;

@Service
public class ClienteServiceImpl implements IClienteService {

	
	@Autowired	
	private  IClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}
	@Transactional
	@Override
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.save(cliente);
		
	}
	@Transactional(readOnly=true)
	@Override
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findOne(id);
	}
	@Transactional
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		clienteDao.delete(id);
		
	}
	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}
	@Override
	public List<Producto> finByNombre(String term) {
		// TODO Auto-generated method stub
		//return productoDao.findByNombre(term);
		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");

	}
	@Override
	@Transactional
	public void saveFactur(Factura factura) {
		// TODO Auto-generated method stub
		facturaDao.save(factura);
		
	}
	@Override
	public Producto findProductoById(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findOne(id);
	}

}
