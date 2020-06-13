package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;
    final Long ownerId =1L;
    final String ownerLastName="Warner";
    @BeforeEach
    void setUp() {
        ownerServiceMap=new OwnerServiceMap(new PetServiceMap(new PetTypeServiceMap()));
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(ownerLastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet=ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner=ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(null,ownerServiceMap.findById(ownerId));
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner foundOwner=ownerServiceMap.findByLastName(ownerLastName);
        assertEquals(ownerId,foundOwner.getId());
    }

    @Test
    void saveNoID() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void saveExistingID(){
        Owner owner2=Owner.builder().id(2L).build();
        Owner savedOwner=ownerServiceMap.save(owner2);
        assertEquals(owner2.getId(),savedOwner.getId());
    }
}