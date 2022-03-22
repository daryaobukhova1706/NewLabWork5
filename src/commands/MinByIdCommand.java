package commands;
import collectionClass.Route;
import dao.InterfaceDao;

import java.util.List;
public class MinByIdCommand implements InterfaceCommand{
    private InterfaceDao interfaceDao;
    private List<Route> routes;
    long minId;
    String element;
    public MinByIdCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;
    }
    @Override
    public String execute(Object object){
        if (!(object instanceof  ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        String minById;
        routes=interfaceDao.getAll();
        if (routes.isEmpty()){
            minById="Коллекция пуста, поэтому элемент с наименьшим id невозможно вывести";
        }
        else{
            minId=routes.iterator().next().getId();
            element=routes.iterator().next().toString();
            for (Route route:routes){
                if(route.getId()<minId){
                    minId= route.getId();
                    element=route.toString();
                }
            }
            minById=element;
        }
        return minById;
    }
}
