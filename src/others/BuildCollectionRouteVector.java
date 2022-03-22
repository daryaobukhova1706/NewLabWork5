package others;

import builder.RouteBuilder;
import collectionClass.*;
import dao.VectorDao;

public class BuildCollectionRouteVector implements InterfaceBuildCollection {
    private InterfaceInformationCollection interfaceInformationCollection;
    private VectorDao vectorDao;
    public BuildCollectionRouteVector(InterfaceInformationCollection interfaceInformationCollection, VectorDao vectorDao){
        this.interfaceInformationCollection=interfaceInformationCollection;
        this.vectorDao=vectorDao;
    }
    public Route dateConversion(String line) {
        String[] fields = line.split(",");
        Route route = new RouteBuilder().fixId(Long.parseLong(fields[0])).fixName(fields[1])
                .fixCoordinates(new Coordinates(Double.parseDouble(fields[2]), Float.parseFloat(fields[3])))
                .fixCreationDate(fields[4])
                .fixLocationFrom(new LocationFrom(Float.parseFloat(fields[5]), Long.parseLong(fields[6]), Float.parseFloat(fields[7]), fields[8]))
                .fixLocationTo(new LocationTo(Integer.parseInt(fields[9]), Integer.parseInt(fields[10]),Long.parseLong(fields[11])))
                .fixDistance(Long.parseLong(fields[12])).build();
        vectorDao.create(route);
        return route;
    }
}

