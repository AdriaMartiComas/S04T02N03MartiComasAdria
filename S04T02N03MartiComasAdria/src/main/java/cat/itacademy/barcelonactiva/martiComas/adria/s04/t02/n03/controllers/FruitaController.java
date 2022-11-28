package cat.itacademy.barcelonactiva.martiComas.adria.s04.t02.n03.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.martiComas.adria.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.martiComas.adria.s04.t02.n03.model.service.FruitaService;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

	@Autowired
	private FruitaService fruitaService;

	// Crear nova fruita - http://localhost:8080/fruita/add
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Fruita fruita) {

		return ResponseEntity.status(HttpStatus.CREATED).body(fruitaService.save(fruita));

	}

	// Actualitzar fruita - http://localhost:8080/fruita/update
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Fruita fruita) {

		return ResponseEntity.status(HttpStatus.CREATED).body(fruitaService.save(fruita));

	}

	// Mostrar Fruita - http://localhost:8080/fruita/getOne/{id}
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long fruitaId) {
		Optional<Fruita> oFruita = fruitaService.findById(fruitaId);

		if (!oFruita.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(oFruita);
		}

	}

	// Mostrar fruites - http://localhost:8080/fruita/getAll
	@GetMapping("/getAll")
	public Iterable<Fruita> getAll() {
		Iterable<Fruita> fruites = fruitaService.findAll();
		return fruites;
	}

	// Eliminar fruita - http://localhost:8080/fruita/delete/{id}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long fruitaId) {

		if (!fruitaService.findById(fruitaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		fruitaService.deleteById(fruitaId);
		return ResponseEntity.ok().build();
	}

}
