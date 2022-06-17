package com.idat.ec2.servicio;

import java.util.List;

import com.idat.ec2.dto.UsuarioReq;
import com.idat.ec2.dto.UsuarioRes;



public interface UsuarioServ {

	public void registrar(UsuarioReq user);
	public void editar(UsuarioReq user);
	public void eliminar(int id);
	public UsuarioRes obtenerId(int id);
	public List<UsuarioRes> listar();
}
