package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long>{

}
