package services;


import entitities.Cat;
import repositories.CatRepository;

import java.util.List;
import java.util.Optional;


public class CatService {
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    public Optional<Cat> findById(long id) {
        return catRepository.findById(id);
    }

    public Cat saveCat(Cat cat) {
        return catRepository.save(cat);
    }
    public Optional<Cat> updateCat(long id, Cat updatedCat) {
        return catRepository.findById(id)
                .map(cat -> {
                    cat.setName(updatedCat.getName());
                    cat.setId(updatedCat.getId());
                    cat.setBirthdate(updatedCat.getBirthdate());
                    cat.setBreed(updatedCat.getBreed());
                    cat.setColor(updatedCat.getColor());
                    cat.setOwner(updatedCat.getOwner());
                    return catRepository.save(cat);
                });
    }
    public void deleteById(long id) {
        catRepository.deleteById(id);
    }

}

