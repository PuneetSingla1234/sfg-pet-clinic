package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.stereotype.Service;

@Service
public class VetServiceImpl extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceImpl(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object){
        if(object!=null){
            if(object.getSpecialities().size()>0){
                object.getSpecialities().forEach(speciality -> {
                    if(speciality.getId()==null){
                        specialityService.save(speciality);
                    }
                });
            }
        }
        return super.save(object);
    }

}
