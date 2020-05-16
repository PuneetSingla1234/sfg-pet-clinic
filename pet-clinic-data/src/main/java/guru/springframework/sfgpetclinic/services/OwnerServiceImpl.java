package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

public class OwnerServiceImpl extends AbstractMapService<Owner,Long> implements OwnerService{
    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
