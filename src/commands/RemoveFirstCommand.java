package commands;
import collectionClass.Route;
import dao.InterfaceDao;
import exceptions.NotFoundIdException;

import java.util.Collections;
import java.util.List;
public class RemoveFirstCommand implements InterfaceCommand {
    private InterfaceDao interfaceDao;
    private List<Route> routes;

    public RemoveFirstCommand(InterfaceDao interfaceDao) {
        this.interfaceDao = interfaceDao;
    }

    @Override
    public String execute(Object object){
        if (!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        String removeFirst;
        routes = interfaceDao.getAll();
        if (routes.isEmpty()){
            return "Коллекция пуста";
        }
        try {
            Collections.sort(routes);
            interfaceDao.delete(routes.iterator().next().getId());
            removeFirst = "Первый элемент коллекции успешно удален";
        }catch(NotFoundIdException exception){
            removeFirst = "Коллекция пуста, поэтому первый элемент коллекции удалить невозможно";
            }
        return removeFirst;
    }
}
