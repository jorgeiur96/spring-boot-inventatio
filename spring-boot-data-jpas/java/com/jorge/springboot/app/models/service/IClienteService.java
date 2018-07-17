package com.jorge.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jorge.springboot.app.models.entity.Cliente;
import com.jorge.springboot.app.models.entity.Factura;
import com.jorge.springboot.app.models.entity.Producto;

public interface IClienteService {
	

	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public  void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public  void  delete(Long id);
	
	public List<Producto> finByNombre(String term);
	
	public void saveFactur(Factura factura);
	
	public Producto findProductoById(Long id);

}
