package commands;
import collectionClass.Route;
import dao.InterfaceDao;

import java.util.List;

public class FilterContainsNameCommand implements InterfaceCommand{
    private InterfaceDao interfaceDao;
    public FilterContainsNameCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;
    }
    private List<Route> routes;
    @Override
    public String execute(Object object) {
        if(!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        routes = interfaceDao.getAll();
        if (routes.isEmpty()){
            return "Коллекция пуста, поэтому элементов, содержащих данную пожстроку, нет";
        }
        ArgumentName argumentName = (ArgumentName) object;
        for (Route route : routes) {
            if (route.getName().contains(argumentName.name)) {
                return route.toString();
            }
        }
        return "Элементов, содержащих заданную подстроку, нет" ;
    }

}
