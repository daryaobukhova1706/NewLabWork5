package commands;

import dao.InterfaceDao;
import exceptions.NotFoundIdException;
import others.InterfaceInformationCollection;

public class RemoveByIdCommand implements InterfaceCommand{
    private InterfaceDao interfaceDao;
    private InterfaceInformationCollection interfaceInformationCollection;
    public RemoveByIdCommand(InterfaceDao interfaceDao, InterfaceInformationCollection interfaceInformationCollection){
        this.interfaceDao=interfaceDao;
        this.interfaceInformationCollection=interfaceInformationCollection;
    }
    @Override
    public String execute(Object object){
        if (!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        ArgumentId argumentId=(ArgumentId) object;
        if (interfaceInformationCollection.getSize()==0){
            return "Коллекция пуста";
        }
        try{
            interfaceDao.delete(argumentId.id);
            return "Элемент, соответствующий даннаму id, успешно удален";
        }
        catch (NotFoundIdException exception){
            return "Человека с таким id не существует";
        }

    }
}
