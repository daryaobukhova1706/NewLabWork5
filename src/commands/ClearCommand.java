package commands;

import dao.InterfaceDao;
import others.InterfaceInformationCollection;

public class ClearCommand implements InterfaceCommand{
    private InterfaceDao interfaceDao;
    private InterfaceInformationCollection interfaceInformationCollection;
    public ClearCommand(InterfaceDao interfaceDao, InterfaceInformationCollection interfaceInformationCollection){
        this.interfaceDao=interfaceDao;
        this.interfaceInformationCollection=interfaceInformationCollection;
    }
    @Override
    public String execute(Object object){
        String clear;
        if (interfaceInformationCollection.getSize()==0){
            clear="Коллекция пуста";
        }
        else{
            interfaceDao.deleteAll();
            clear="Коллекия очищена";
        }
        return clear;

    }
}
