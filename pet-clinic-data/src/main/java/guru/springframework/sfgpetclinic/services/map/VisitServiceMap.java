package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;

public class VisitServiceMap extends AbstractMapService<Visit,Long> implements VisitService {
    @Override
    public Visit save(Visit object){
        if(object.getPet()==null||object.getPet().getId()==null||object.getPet().getPetType()==null||
                object.getPet().getOwner()==null||object.getPet().getOwner().getId()==null){
            throw new RuntimeException("Invalid Data");
        }
        else{
            return super.save(object);
        }

    }
}
