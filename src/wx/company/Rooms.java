package wx.company;

import java.util.HashMap;

public class Rooms {
    public String description;
    public Rooms northExit;
    public Rooms southExit;
    public Rooms westExit;
    public Rooms eastExit;
    public Rooms(String description){
        this.description=description;
    }

    @Override
    public String toString() {
        return description;
    }
    public void setExit(Rooms north,Rooms east,Rooms south,Rooms west){
        if (north!=null){
            northExit=north;
        }
        if (east!=null){
            eastExit=east;
        }
        if (south!=null){
            southExit=south;
        }
        if (west!=null){
            westExit=west;
        }
    }
}
