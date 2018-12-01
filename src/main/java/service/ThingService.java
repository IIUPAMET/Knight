package service;

import model.dao.DAOThing;
import model.dao.daoImpl.DAOThingImpl;
import model.dto.KnightDTO;
import model.entity.Thing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ThingService {

    private final DAOThing daoThing = new DAOThingImpl();
    public List<Thing> getAll(){
        return daoThing.getAll();
    }

    public List<Thing> getInPriceDiapason(Integer minPrice, Integer maxPrice){
        return daoThing.getInPriceDiapason(minPrice, maxPrice);
    }

    public void create(Thing thing){
        daoThing.create(thing);
    }

    public Integer sumWeight(List<Thing> thing){
        return thing.stream().collect(Collectors.toMap(p->p.getName(), t->t.getPrice())).values().stream().mapToInt(i->i).sum();
    }

    public List<Thing> sortThingByPrice(List<Thing> things){
        return things.stream().sorted(Comparator.comparing(x -> x.getPrice(),Comparator.reverseOrder())).collect(Collectors.toList());
    }

    public KnightDTO equipKnight(Integer id, KnightDTO knight){
        knight.addEquipmentThings(daoThing.getEntityById(id));
        return knight;
    }
}
