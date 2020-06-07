package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.PetType;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceImpl extends AbstractMapService<PetType,Long> implements PetTypeService{
}
