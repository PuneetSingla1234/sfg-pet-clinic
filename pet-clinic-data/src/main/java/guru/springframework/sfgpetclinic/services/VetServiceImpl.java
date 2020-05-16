package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.stereotype.Service;

@Service
public class VetServiceImpl extends AbstractMapService<Vet,Long> implements VetService {
    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }
}
