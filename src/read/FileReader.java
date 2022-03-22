package read;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import others.*;

/**
 * Класс для чтения данных из файла
 */
public class FileReader implements InterfaceRead {
    private String fileName;
    private InformationCollectionRoute informationCollectionRoute;
    private BuildCollectionRouteVector buildCollection;

    public FileReader(String arg, BuildCollectionRouteVector buildCollection){
        this.buildCollection=buildCollection;
        fileName=arg;

    }

    /**
     * Метод для чтения данных из файла
     * @return
     */
    @Override
    public String read(){
        Path path=Paths.get(fileName);
        try {
            Scanner scanner = new Scanner(path);
            while(scanner.hasNext()){
                String line=scanner.next();
                buildCollection.dateConversion(line);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Ошибка доступа к файлу");
        }
        return "";
    }


}
