package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl extends AbstractMapService<Pet,Long> implements PetService{
    private final PetTypeService petTypeService;

    public PetServiceImpl(PetTypeService petTypeService) {
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
