package collectionClass;

public class LocationFrom {
    private Float x; //Поле не может быть null
    private Long y; //Поле не может быть null
    private float z;
    private String name; //Длина строки не должна быть больше 737, Поле может быть null
    public LocationFrom( Float x, Long y){
        this.x=x;
        this.y=y;
    }
    public void setX(Float x){
        this.x=x;
    }
    public Float getX(Float x){
        return x;
    }
    public void setY(Long y){
        this.y=y;
    }
    public Long getY(Long y){
        return y;
    }

}
