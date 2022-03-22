package commands;

import dao.InterfaceDao;
import collectionClass.Route;
import java.util.List;
public class FilterLessThanDistanceCommand implements InterfaceCommand{
    private InterfaceDao interfaceDao;
    private List<Route> routes;
    public FilterLessThanDistanceCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;
    }
    @Override
    public String execute(Object object){
        if(!(object instanceof  ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        ArgumentDistance argumentDistance=(ArgumentDistance) object;
        routes=interfaceDao.getAll();
        if (routes.isEmpty()){
            return "Коллекция пуста, поэтому элементов, значение distance которых меньше заданного нет";
        }
        for (Route route: routes){
            if (route.getDistance()<argumentDistance.distance){
                return route.toString();
            }
        }
        return "Элементов, значение поля distance которых меньше заданного, нет";
    }
}
