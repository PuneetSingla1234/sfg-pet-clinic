package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
    protected Map<Long,T> map=new HashMap<>();

    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }
    public T findById(ID id){
        return map.get(id);
    }
    public T save(T object){
        if(object!=null){
            if(object.getId()==null){
                object.setId(getNextID());
            }
            map.put(object.getId(),object);
        }
        return object;
    }
    public void deleteById(ID id){
        map.remove(id);
    }
    public void delete(T object){
        map.entrySet().removeIf(entry->entry.getValue().equals(object));
    }
    private Long getNextID(){
        Long nextId=null;
        try{
            nextId=Collections.max(map.keySet())+1;
        }
        catch (Exception e){
            nextId=1L;
        }
        return nextId;
    }
}
