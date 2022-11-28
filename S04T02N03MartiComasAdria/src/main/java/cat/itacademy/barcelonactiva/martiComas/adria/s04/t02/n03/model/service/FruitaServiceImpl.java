package cat.itacademy.barcelonactiva.martiComas.adria.s04.t02.n03.model.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.martiComas.adria.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.martiComas.adria.s04.t02.n03.model.repository.FruitaRepository;

@Service
public class FruitaServiceImpl implements FruitaService {

	// injeccio dependencies
	@Autowired
	private FruitaRepository fruitaRepository;

	// Implementacio de metodes
	@Override
	@Transactional(readOnly = true)
	public Iterable<Fruita> findAll() {
		return fruitaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Fruita> findAll(Pageable pageable) {

		return fruitaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Fruita> findById(Long id) {
		return fruitaRepository.findById(id);
	}

	@Override
	@Transactional
	public Fruita save(Fruita fruita) {

		return fruitaRepository.save(fruita);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		fruitaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void fruitaUpdate(Optional<Fruita> oFruita, Fruita fruita) {
		oFruita.get().setNom(fruita.getNom());
		oFruita.get().setQuantitatQuilos(fruita.getQuantitatQuilos());
		
	}


}