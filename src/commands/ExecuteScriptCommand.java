package commands;
import exceptions.NumbersWordsException;
import others.Interactive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ExecuteScriptCommand implements InterfaceCommand{
    private Executor executor;
    public ExecuteScriptCommand(Executor executor){
        this.executor=executor;
    }
    @Override
    public String execute(Object object) {
        ArgumentScript argumentScript = (ArgumentScript) object;
        try{
            Scanner scanner = new Scanner (new File(argumentScript.fileName));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.equals("help")) {
                    System.out.println(executor.executeHelp());}
                else if (line.equals("show")) {
                    System.out.println(executor.executeShow());}
                else if (line.equals("info")) {
                    System.out.println(executor.executeInfo());}
                else if (line.equals("add")) {
                    System.out.println(executor.executeAddElement(readName(scanner), readCoordinatesX(scanner), readCoordinatesY(scanner), readFromLocationX(scanner), readFromLocationY(scanner), readFromLocationZ(scanner), readFromLocationName(scanner), readToLocationX(scanner), readToLocationY(scanner), readToLocationZ(scanner), readDistance(scanner)));
                }
            }
        }
        catch (FileNotFoundException e){
            return "Такого файла не найдена";
        }
        return "Скрипт выполенен";
    }
    public String readName(Scanner scanner){
        String name=scanner.nextLine();
        if(name.isEmpty()){
            System.out.println("Поле name не может быть пустым");
        }
        return name;
    }
    public Long readDistance(Scanner scanner){
        long distance=scanner.nextLong();
        if(distance<1){
            System.out.println("Поле distance должно быть больше 1");
        }
        return distance;
    }

    public Double readCoordinatesX(Scanner scanner) {
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            System.out.println("Поле X не может быть пустым! Пожалуйста,введите координату Х еще раз: ");
        }
        double x;
        try {
            x = Double.parseDouble(line);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Поле X неправильное, оно должно быть дробным или целым числом!");
        }
        return x;
    }
    public float readCoordinatesY(Scanner scanner){
        String line=scanner.nextLine();
        float y;
        try{
            y=Float.parseFloat(line);
        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Поле Y неправильное, оно должно быть дробным числом");
        }
        return y;
    }
    public Float readFromLocationX(Scanner scanner){
        String line= scanner.nextLine();
        float fromX;
        if (line.isEmpty()) {
            System.out.println("Поле X не может быть пустым! Пожалуйста, введите координату X LocationFrom еще раз:");
        }
        try {
            fromX = Float.parseFloat(line);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Поле X введено неправльно, оно должно быть дробным или целым числом! Пожалуйста введите координату X еще раз:");
        }
        return fromX;

    }
    public Long readFromLocationY(Scanner scanner){
        String line= scanner.nextLine();
        if (line.isEmpty()) {
            System.out.println("Поле Y не может быть пустым! Пожалуйста, введите координату Y LocationFrom еще раз:");
        }
        long y;
        try {
            y = Long.parseLong(line);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Поле Y введено неправильно, оно должно быть целым числом! Пожалуйста, введите координату Y LocationFrom еще раз:");
        }
        return y;
    }
    public float readFromLocationZ(Scanner scanner){
        String line=scanner.nextLine();
        long z;
        try {
            z = Long.parseLong(line);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Поле Z введено неправильно, оно должно быть целым числом! Пожалуйста, введите координату Z LocationFrom еще раз:");

        }
        return z;
    }
    public String readFromLocationName(Scanner scanner){
        String line=scanner.nextLine();
        if(line.isEmpty()){
            return null;
        }
        try {
            char[] l = line.toCharArray();
            for (int i = 0; i < l.length; i++) {
                if (Character.isDigit(l[i])) {
                    i = l.length;
                    throw new NumbersWordsException("Поле name введено неправильно, name должно состоять из букв!");
                }
            }
        } catch (NumbersWordsException e) {
            System.out.println(e.getMessage());
        }
        if (line.length() > 737) {
            System.out.println("Длина поля name не должно быть больше 737!");
        }
        return line;
    }
    public Integer readToLocationX(Scanner scanner){
        String line=scanner.nextLine();
        if (line.isEmpty()) {
            System.out.println("Поле X не может быть пустым! Пожалуйста, введите координату X LocationTo еще раз:");
        }
        int x;
        try {
            x = Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Поле X введено неправильно, оно должно быть целым числом! Пожалуйста, введите координату X LocationTo еще раз:");
        }
        return x;
    }
    public int readToLocationY(Scanner scanner){
        String line= scanner.nextLine();
        int y;
        try {
            y = Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Поле Y введено неправильно, оно должно быть целым числом! Пожалуйста, введите координату Y LocationTo еще раз:");
        }
        return y;
    }
    public Long readToLocationZ(Scanner scanner){
        String line=scanner.nextLine();
        if (line.isEmpty()) {
            System.out.println("Поле Z не может быть пустым! Пожалуйста, введите координу Z LocationTo еще раз:");
        }
        long z;
        try {
            z = Long.parseLong(line);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Поле Z введено неправильно, оно должно быть целым числом! Пожалуйста введите координату Z LocationTo еще раз:");
        }
        return z;
    }
}


