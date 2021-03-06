package com.idat.ec2.servicio;

import java.util.List;

import com.idat.ec2.dto.BodegaReq;
import com.idat.ec2.dto.BodegaRes;


public interface BodegaServ {

	public void registrar(BodegaReq bod);
	public void editar(BodegaReq bod);
	public void eliminar(int id);
	public BodegaRes obtenerId(int id);
	public List<BodegaRes> listar();
}
