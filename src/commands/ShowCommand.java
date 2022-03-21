package commands;

import collectionClass.Route;

import java.util.List;
import dao.*;

/**
 * Класс-наследник интерфейса command,
 * показывающий содержимое коллекции
 */
public class ShowCommand implements InterfaceCommand {
    private InterfaceDao interfaceDao;
    public ShowCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;
    }

    /**
     * Исполнение команды
     * @param object
     * @return результат исполнения команды
     */
    @Override
    public String execute(Object object) {
        if(!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        String show;
        List<Route> routes= interfaceDao.getAll();
        StringBuilder stringBuilder=new StringBuilder();
        if (routes.isEmpty()){
            show="Коллекция пуста, поэтому элементы коллекции не могут быть выведены";
        }
        else{
            for (Route route: routes){
                stringBuilder.append(route.toString()).append("\n");
            }
            show=stringBuilder.toString();

        }
        return show;
    }

}

