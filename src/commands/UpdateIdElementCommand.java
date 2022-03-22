package commands;

import builder.RouteBuilder;
import collectionClass.Coordinates;
import collectionClass.LocationFrom;
import collectionClass.LocationTo;
import dao.InterfaceDao;
import exceptions.NotFoundIdException;
import others.InterfaceInformationCollection;
import collectionClass.Route;

import java.io.FileNotFoundException;

public class UpdateIdElementCommand implements InterfaceCommand{
    private InterfaceDao interfaceDao;
    private InterfaceInformationCollection interfaceInformationCollection;
    public UpdateIdElementCommand(InterfaceDao interfaceDao, InterfaceInformationCollection interfaceInformationCollection){
        this.interfaceDao=interfaceDao;
        this.interfaceInformationCollection=interfaceInformationCollection;
    }
    @Override
    public String execute(Object object) {
        if(!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        if (interfaceInformationCollection.getSize()==0){
            return "Коллекция пуста, поэтому обновить элемент невозможно";
        }
        if (!(object instanceof ArgumentInterface)) {
            return "Невозможно выполнить данную команду";
        }
        ArgumentUpdate argumentUpdate=(ArgumentUpdate) object;
        try {
            Route route=new RouteBuilder().fixId(argumentUpdate.id).
                    fixCoordinates(new Coordinates(argumentUpdate.coordinatesX, argumentUpdate.coordinatesY)).
                    fixLocationFrom(new LocationFrom(argumentUpdate.fromX, argumentUpdate.fromY, argumentUpdate.fromZ, argumentUpdate.name)).
                    fixLocationTo(new LocationTo(argumentUpdate.toX, argumentUpdate.toY, argumentUpdate.toZ )).
                    fixDistance(argumentUpdate.distance).build();
            interfaceDao.update(route);
            return "Элемент, соответствующий данному id, обновлен";
        } catch(NotFoundIdException e){
            return "Человека с таким id не существует";
        }
    }
}
