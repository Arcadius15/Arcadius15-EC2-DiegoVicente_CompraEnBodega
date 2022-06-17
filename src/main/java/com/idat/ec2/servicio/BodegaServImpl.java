package com.idat.ec2.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2.dto.BodegaReq;
import com.idat.ec2.dto.BodegaRes;
import com.idat.ec2.modelo.Bodega;
import com.idat.ec2.repositorio.BodegaRepositorio;
import com.idat.ec2.utilitarios.ModelMapperConfig;

@Service
public class BodegaServImpl implements BodegaServ {
	
	@Autowired
	private BodegaRepositorio repositorio;
	
	@Autowired
	private ModelMapperConfig mapper;

	@Override
	public void registrar(BodegaReq bod) {
		Bodega b = mapper.modelMapper().map(bod, Bodega.class);
		repositorio.save(b);
	}

	@Override
	public void editar(BodegaReq bod) {
		Bodega b = mapper.modelMapper().map(bod, Bodega.class);
		repositorio.saveAndFlush(b);
	}

	@Override
	public void eliminar(int id) {
		repositorio.deleteById(id);
	}

	@Override
	public BodegaRes obtenerId(int id) {
		Bodega b = repositorio.findById(id).orElse(null);
		BodegaRes res = new BodegaRes();
		if (b!=null) {
			res = mapper.modelMapper().map(b, BodegaRes.class);
		}
		return res;
	}

	@Override
	public List<BodegaRes> listar() {
		List<BodegaRes> res = new ArrayList<BodegaRes>();
		List<Bodega> b = repositorio.findAll();
		if (b!=null) {
			for (Bodega bodega : b) {
				BodegaRes r = new BodegaRes();
				r = mapper.modelMapper().map(bodega, BodegaRes.class);
				res.add(r);
			}
		}
		return res;
	}

}
