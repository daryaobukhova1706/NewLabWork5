package dao;

import java.util.List;
import java.util.Vector;
import collectionClass.*;
import exceptions.NotFoundIdException;
import others.*;

public class VectorDao implements InterfaceDao {
    private InterfaceInformationCollection interfaceInformationCollection;
    public VectorDao(InterfaceInformationCollection interfaceInformationCollection){
        this.interfaceInformationCollection=interfaceInformationCollection;

    }
    private final Vector<Route> collection=new Vector<>();
    @Override
    public void create(Route route){
        interfaceInformationCollection.setSize(interfaceInformationCollection.getSize()+1);
        collection.add(route);
    }
    @Override
    public void update(Route route) throws NotFoundIdException{
        Route existedRoute= get(route.getId());
        if (existedRoute!=null){
            existedRoute.setName(route.getName());
            existedRoute.setCoordinate(route.getCoordinate());
            existedRoute.setDistance(route.getDistance());
            existedRoute.setFrom(route.getFrom());
        }
        else{
            throw new NotFoundIdException("Человек с таким id не существует");
        }
    }
    @Override
    public void delete(Long id) throws NotFoundIdException{
        Route existedRoute=get(id);
        if (existedRoute!=null){
            collection.remove(existedRoute);
            interfaceInformationCollection.setSize(interfaceInformationCollection.getSize()-1);
        }
        else {
            throw new NotFoundIdException("Человека с таким id не существует");
        }
    }
    @Override
    public Route get(Long id){
        for (Route route: collection){
            if (route.getId()==id){
                return route;
            }
        }
        return null;
    }
    @Override
    public List<Route> getAll(){
        return collection;
    }
    public String getInfo(){
        return interfaceInformationCollection.toString();
    }
    public void deleteAll(){
        collection.clear();
        interfaceInformationCollection.setSize(0);
    }




}

