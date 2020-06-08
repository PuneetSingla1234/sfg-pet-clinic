package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl extends AbstractMapService<Owner,Long> implements OwnerService{
    private final PetService petService;

    public OwnerServiceImpl(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
    @Override
    public Owner save(Owner object){
        if(object!=null){
            if(object.getPets().size()!=0){
                object.getPets().forEach(pet->{
                    Pet savedPet = petService.save(pet);
                });
            }
            return super.save(object);
        }
        else
            return null;
    }
}
