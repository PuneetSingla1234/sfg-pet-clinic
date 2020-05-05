package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

public class OwnerServiceImpl extends AbstractMapService<Owner,Long> implements CrudService<Owner,Long>{
    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }
}
