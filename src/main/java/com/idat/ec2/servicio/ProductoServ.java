package com.idat.ec2.servicio;

import java.util.List;

import com.idat.ec2.dto.ProductoReq;
import com.idat.ec2.dto.ProductoRes;


public interface ProductoServ {

	public void registrar(ProductoReq pro);
	public void editar(ProductoReq pro);
	public void eliminar(int id);
	public ProductoRes obtenerId(int id);
	public List<ProductoRes> listar();
}
