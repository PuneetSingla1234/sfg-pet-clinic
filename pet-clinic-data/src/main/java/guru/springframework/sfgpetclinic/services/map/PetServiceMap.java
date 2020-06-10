package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})

public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService {
    private final PetTypeService petTypeService;

    public PetServiceMap(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public Pet save(Pet object){
        if(object==null)
            return null;
        if(object.getPetType()==null){
            throw new RuntimeException("Pet Type Required");
        }
        if(object.getPetType().getId()==null)
            petTypeService.save(object.getPetType());
        return super.save(object);
    }
}
