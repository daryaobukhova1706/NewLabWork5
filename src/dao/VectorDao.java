package dao;

import java.util.List;
import java.util.Vector;
import collectionClass.*;
import exceptions.NotFoundIdException;
import others.*;

/**
 * Класс VectorDao - наследник интерфейса DAO,
 * реализующий его методы
 * и инициализирующий саму коллекцию
 */
public class VectorDao implements InterfaceDao {
    private InterfaceInformationCollection interfaceInformationCollection;
    public VectorDao(InterfaceInformationCollection interfaceInformationCollection){
        this.interfaceInformationCollection=interfaceInformationCollection;

    }

    /**
     * Инициализация коллекции Vector
     */
    private final Vector<Route> collection=new Vector<>();

    /**
     * Метод, добавляющий элемент в коллекцию
     * то есть увеличивающий её размер на 1
     * @param route
     */
    @Override
    public void create(Route route){
        interfaceInformationCollection.setSize(interfaceInformationCollection.getSize()+1);
        collection.add(route);
    }

    /**
     * Этот метод обновляет (переопределяет)
     * все поля класса Route
     * @param route
     * @throws NotFoundIdException В случае пустой ссылки - выкидывает ошибку
     */
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

    /**
     * Метод удаляет элемент из коллекции по id
     * уменьшает размер коллекции на 1
     * @param id
     * @throws NotFoundIdException
     */
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

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Route get(Long id){
        for (Route route: collection){
            if (route.getId()==id){
                return route;
            }
        }
        return null;
    }

    /**
     * Метод выводит все элементы коллекции
     * @return
     */
    @Override
    public List<Route> getAll(){
        return collection;
    }

    /**
     * Метод, выводящий информацию о коллекции
     * @return
     */
    public String getInfo(){
        return interfaceInformationCollection.toString();
    }

    /**
     * Метод очищает коллекцию
     * то есть делает её размер = 0
     */
    public void deleteAll(){
        collection.clear();
        interfaceInformationCollection.setSize(0);
    }




}

