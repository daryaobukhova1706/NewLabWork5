package collectionClass;

public class LocationTo {
    private Integer x; //Поле не может быть null
    private int y;
    private Long z; //Поле не может быть null
    public LocationTo( Integer x, int y){
        this.x=x;
        this.y=y;
    }
    public void setX(Integer x){
        this.x=x;
    }
    public Integer getX(Integer x){
        return x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getY(int y){
        return y;
    }
}
