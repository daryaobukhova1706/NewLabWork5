package commands;
import dao.*;
import others.InterfaceInformationCollection;

/**
 * Класс-наследник интерфейса command
 * для команды,которая выводит информацию
 * по коллекции
 */
public class InfoCommand implements InterfaceCommand {
    private InterfaceDao interfaceDao;
    private InterfaceInformationCollection interfaceInformationCollection;
    public InfoCommand(InterfaceDao interfaceDao, InterfaceInformationCollection interfaceInformationCollection) {
        this.interfaceInformationCollection=interfaceInformationCollection;
        this.interfaceDao = interfaceDao;
    }

    /**
     * Исполнение команды
     * @param object
     * @return Результат исполнения команды
     */
    @Override
    public String execute(Object object){
        if (!(object instanceof  ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        String info;
        if (interfaceInformationCollection.getSize()==0){
            info="Коллекция пуста, поэтому информация о коллекции не может быть выведена";
        }
        else{
            info=interfaceDao.getInfo();
        }
        return info;
    }
}
