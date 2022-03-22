package commands;

import commands.InterfaceCommand;

import java.util.Map;
public class Executor {

    private Map<String, InterfaceCommand> commands;
    public void setCommands (Map<String, InterfaceCommand> commands){
        this.commands=commands;
    }
    public InterfaceCommand getCommands(String key){
        InterfaceCommand com=commands.get(key);
        return com;

    }
    public String executeHelp(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("help").execute(argumentEmpty);
    }
    public String executeInfo(){
        ArgumentEmpty argumentEmpty= new ArgumentEmpty();
        return commands.get("info").execute(argumentEmpty);
    }
    public String executeShow(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("show").execute(argumentEmpty);
    }
    public String executeAddElement(String name, Double coordinatesX, float coordinatesY, Float fromX,Long fromY, float fromZ, String fromName,Integer toX, int toY, Long toZ, Long distance){
        ArgumentElement argumentElement=new ArgumentElement(name, coordinatesX, coordinatesY, fromX, fromY, fromZ, fromName, toX, toY, toZ, distance);
        return commands.get("add").execute(argumentElement);
    }
    public String executeUpdateIdElement(Long id, String name, Double coordinatesX, float coordinatesY, Float fromX,Long fromY, float fromZ, String fromName,Integer toX, int toY, Long toZ, Long distance){
        ArgumentUpdate argumentUpdate=new ArgumentUpdate(id, name, coordinatesX, coordinatesY, fromX, fromY, fromZ, fromName, toX, toY, toZ, distance);
        return commands.get("update").execute(argumentUpdate);
    }
    public String executeClear(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("clear").execute(argumentEmpty);
    }
    public String executeSave(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("save").execute(argumentEmpty);
    }
    public String executeSort(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("sort").execute(argumentEmpty);
    }
    public String executeRemoveFirst(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("remove_first").execute(argumentEmpty);
    }
    public String executeMinById(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("min_by_id").execute(argumentEmpty);
    }
    public String executeRemoveById(Long id){
        ArgumentId argumentId=new ArgumentId(id);
        return commands.get("remove_by_id").execute(argumentId);
    }
    public String executeAddIfMin(String name, Double coordinatesX, float coordinatesY, Float fromX,Long fromY, float fromZ, String fromName,Integer toX, int toY, Long toZ, Long distance){
        ArgumentElement argumentElement=new ArgumentElement(name, coordinatesX, coordinatesY, fromX, fromY, fromZ, fromName, toX, toY, toZ, distance);
        return commands.get("add_if_min").execute(argumentElement);
    }
    public String executeFilterContainsName(String name){
        ArgumentName argumentName=new ArgumentName(name);
        return commands.get("filter_contains_name").execute(argumentName);
    }
    public String executeFilterLessThanDistance(Long distance){
        ArgumentDistance argumentDistance=new ArgumentDistance(distance);
        return commands.get("filter_less_than_distance").execute(argumentDistance);
    }
    public String executeScript(String fileName){
        ArgumentScript argumentScript=new ArgumentScript(fileName);
        return commands.get("execute_script").execute(argumentScript);
    }
}
