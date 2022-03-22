package builder;

import collectionClass.Coordinates;
import collectionClass.LocationFrom;
import collectionClass.LocationTo;
import collectionClass.Route;
import java.lang.*;


/**
 * Класс для создания объектов
 */
public class RouteBuilder implements InterfaceBuilder {
    private static long idCount;
    public RouteBuilder(){}
    public RouteBuilder(long idCount){
        this.idCount=idCount;
    }
    private String creationDate;
    private Long id;
    private String name;
    private Coordinates coordinates;
    private LocationFrom from;
    private LocationTo to;
    private Long distance;


    /**
     * Метод для генерации Id элемента коллекции
     * @return
     */
    @Override
    public InterfaceBuilder generationId() {
        id=idCount;
        idCount++;
        return this;
    }
    @Override
    public InterfaceBuilder fixCreationDate(String creationDate){
        this.creationDate=creationDate;
        return this;
    }
    @Override
    public InterfaceBuilder fixId(Long id){
        this.id=id;
        return this;
    }

    @Override
    public InterfaceBuilder fixName(String name) {
        this.name = name;
        return this;
    }


    @Override
    public InterfaceBuilder fixCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    @Override
    public InterfaceBuilder fixLocationFrom(LocationFrom from) {
        this.from = from;
        return this;
    }

    @Override
    public InterfaceBuilder fixLocationTo(LocationTo to) {
        this.to = to;
        return this;
    }

    @Override
    public InterfaceBuilder fixDistance(Long distance) {
        this.distance = distance;
        return this;
    }


    @Override
    public Route build() {
        Route route = new Route(id, name, coordinates, from, to, distance);
        id=null;
        name=null;
        coordinates=null;
        from=null;
        to=null;
        distance=null;

        return route;
    }
}
