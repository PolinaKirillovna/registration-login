package services;


import entitities.Owner;
import org.springframework.stereotype.Service;
import repositories.OwnerRepository;

import java.util.List;
import java.util.Optional;


@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Optional<Owner> findById(long id) {
        return ownerRepository.findById(id);
    }

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Optional<Owner> updateOwner(long id, Owner updatedOwner) {
        return ownerRepository.findById(id)
                .map(owner -> {
                    owner.setName(updatedOwner.getName());
                    owner.setId(updatedOwner.getId());
                    owner.setBirthdate(updatedOwner.getBirthdate());
                    return ownerRepository.save(owner);
                });
    }

    public void deleteById(long id) {
        ownerRepository.deleteById(id);
    }
}

