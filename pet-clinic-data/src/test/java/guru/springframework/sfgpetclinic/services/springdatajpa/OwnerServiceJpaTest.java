package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {
    final String LAST_NAME="Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerServiceJpa ownerServiceJpa;

    Owner returnOwner;
    @BeforeEach
    void setUp() {
        returnOwner=Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(Optional.of(returnOwner));
        Owner smith=ownerServiceJpa.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,smith.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet=new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        assertEquals(2,ownerServiceJpa.findAll().size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));
        Owner owner=ownerServiceJpa.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByNoExistingId() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        Owner owner=ownerServiceJpa.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave=Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner=ownerServiceJpa.save(ownerToSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerServiceJpa.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerServiceJpa.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}