package com.example.swaggerspringboot.api.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.swaggerspringboot.api.models.Pet;
import com.example.swaggerspringboot.api.models.Pets;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PetsController implements PetsApi {
	
	@Override
	public ResponseEntity<Pets> listPets(@Valid Integer limit) {
		log.info("limit param value:{}", limit);
		List<Pet> pets = LongStream.range(0, 5)
			.mapToObj(n -> new Pet().id(n).name("pet" + n))
			.collect(Collectors.toList());

		Pets response = new Pets();
		response.addAll(pets);
		return ResponseEntity.ok(response);
	}
}
