package dao;

import java.util.List;

import collectionClass.Route;
import exceptions.NotFoundIdException;

public interface InterfaceDao {
    void create(Route route);

    void update(Route route) throws NotFoundIdException;

    void delete(Long id) throws NotFoundIdException;

    Route get(Long id);

    List<Route> getAll();
    String getInfo();
    void deleteAll();


}
