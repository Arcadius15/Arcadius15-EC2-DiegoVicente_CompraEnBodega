package com.idat.ec2.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ec2.dto.ClienteReq;
import com.idat.ec2.dto.ClienteRes;
import com.idat.ec2.servicio.ClienteServ;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
    private ClienteServ repository;

    @GetMapping
    public ResponseEntity<List<ClienteRes>> getAll() {
        try {
            List<ClienteRes> items = new ArrayList<ClienteRes>();

            repository.listar().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteRes> getById(@PathVariable("id") int id) {
    	ClienteRes item = repository.obtenerId(id);

        if (item!=null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ClienteReq item) {
        try {
            repository.registrar(item);
            return new ResponseEntity<>( HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody ClienteReq item) {
        ClienteRes existingItem = repository.obtenerId(id);
        if (existingItem!=null) {
            repository.editar(item);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        try {
            repository.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
	
}
