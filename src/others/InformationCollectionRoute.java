package others;

import java.time.LocalDate;

public class InformationCollectionRoute implements InterfaceInformationCollection {
    private String type;
    private String creationDate;
    private int size;
    public InformationCollectionRoute(String type, String creationDate, int numbers){
        this.type=type;
        this.size=numbers;
        this.creationDate=creationDate;
    }
    public void setType(String type){
        this.type=type;

    }
    public String getType(){
        return type;
    }
    public void setCreationDate(String  creationDate){
        this.creationDate=creationDate;

    }
    public String getCreationDate(){
        return creationDate;
    }
    public void setSize(int numbers){
        this.size=numbers;
    }
    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        return "InformationCollection{" +
                "type='" + type + '\'' +
                ", creationDate=" + creationDate +
                ", size=" + size +
                '}';
    }
}
