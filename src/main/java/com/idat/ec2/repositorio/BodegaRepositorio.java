package com.idat.ec2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ec2.modelo.Bodega;

@Repository
public interface BodegaRepositorio extends JpaRepository<Bodega, Integer> {

}
