package com.idat.ec2.servicio;

import java.util.List;

import com.idat.ec2.dto.ClienteReq;
import com.idat.ec2.dto.ClienteRes;

public interface ClienteServ {

	public void registrar(ClienteReq cli);
	public void editar(ClienteReq cli);
	public void eliminar(int id);
	public ClienteRes obtenerId(int id);
	public List<ClienteRes> listar();
}
