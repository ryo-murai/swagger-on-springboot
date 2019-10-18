package com.example.swaggerspringboot.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.swaggerspringboot.api.models.Pets;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PetsController implements PetsApi {
	@Override
	public ResponseEntity<Pets> listPets(@Valid Integer limit) {
		log.info("limit param value:{}", limit);
		return PetsApi.super.listPets(limit);
	}
}
