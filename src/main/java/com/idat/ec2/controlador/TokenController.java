package com.idat.ec2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ec2.dto.TokenRes;
import com.idat.ec2.dto.UsuarioReq;
import com.idat.ec2.seguridad.UserDetailService;
import com.idat.ec2.utilitarios.JwtUtil;

@RestController
public class TokenController {

	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserDetailService service;
	
	@PostMapping("/crearToken")
	public ResponseEntity<?> crearToken(@RequestBody UsuarioReq dto){
		UserDetails detail = service.loadUserByUsername(dto.getUsuario());
		return ResponseEntity.ok(new TokenRes(util.generateToken(detail.getUsername())));
	}
}
