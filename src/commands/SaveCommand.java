package commands;

import dao.InterfaceDao;
import others.InterfaceWrite;

import java.util.Vector;
import java.util.List;
import collectionClass.*;
public class SaveCommand implements InterfaceCommand{
    private InterfaceWrite interfaceWrite;
    private InterfaceDao interfaceDao;
    public SaveCommand(InterfaceWrite interfaceWrite, InterfaceDao interfaceDao){
        this.interfaceWrite=interfaceWrite;
        this.interfaceDao=interfaceDao;
    }
    private List <Route> r=new Vector<>();
    @Override
    public String execute(Object object){
        if(!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        String save;
        r=interfaceDao.getAll();
        if (r.isEmpty()){
            save="Коллекция пуста,поэтому сохранять нечего";
        }
        else{
            for (Route route:r){
                interfaceWrite.writer(route);
            }
            save="коллекция сохранена в файл";
        }
        return save;

    }
}
