package commands;
import collectionClass.Route;
import dao.InterfaceDao;
import java.util.*;


public class SortCommand implements InterfaceCommand {
    private InterfaceDao interfaceDao;
    private List <Route> routes;
    public SortCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;}
    @Override
    public String execute(Object object){
        if(!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        String sort;
        routes=interfaceDao.getAll();
        if(routes.isEmpty()){
            sort="Коллекция пуста, поэтому ее невозожно отсортировать";
        }
        else{
            Collections.sort(routes);
            sort="Коллекция отсортирована";
        }
        return sort;

    }
}
