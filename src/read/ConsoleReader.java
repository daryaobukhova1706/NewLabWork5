package read;

import java.util.*;
public class ConsoleReader implements InterfaceRead {
    @Override
    public String read(){
        Scanner scanner= new Scanner(System.in);
        String input=scanner.nextLine().trim();
        return input;
    }

}
