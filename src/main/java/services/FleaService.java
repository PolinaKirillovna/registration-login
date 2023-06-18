package services;

import entitities.Flea;
import repositories.FleaRepository;

import java.util.List;
import java.util.Optional;


public class FleaService {
    private final FleaRepository fleaRepository;

    public FleaService(FleaRepository fleaRepository) {
        this.fleaRepository = fleaRepository;
    }
    public List<Flea> findAll() {
        return fleaRepository.findAll();
    }

    public Optional<Flea> findById(long id) {
        return fleaRepository.findById(id);
    }


    public Flea saveFlea(Flea flea) {
        return fleaRepository.save(flea);
    }

    public Optional<Flea> updateFlea(long id, Flea updatedFlea) {
        return fleaRepository.findById(id)
                .map(flea -> {
                    flea.setName(updatedFlea.getName());
                    flea.setId(updatedFlea.getId());
                    flea.setCat(updatedFlea.getCat());
                    return fleaRepository.save(flea);
                });
    }
    public void deleteById(long id) {
        fleaRepository.deleteById(id);
    }

}
