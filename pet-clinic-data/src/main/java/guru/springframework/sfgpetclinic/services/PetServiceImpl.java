package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;

public class PetServiceImpl extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long>{
    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }
}
