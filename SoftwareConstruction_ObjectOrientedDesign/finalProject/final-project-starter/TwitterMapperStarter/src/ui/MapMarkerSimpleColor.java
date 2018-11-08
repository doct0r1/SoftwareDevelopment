package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MapMarkerSimpleColor extends MapMarkerSimple implements Observer {

    private Color color = Color.red;

    public MapMarkerSimpleColor(Layer layer, Coordinate statusCoordinate) {
        super(layer, statusCoordinate);
        setBackColor(color);
    }

    // TODO: observer pattern does not work!!!
    // TODO: check it latter;

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("basic")) {
            color = Color.blue;
        } else if (arg.equals("and")) {
            color = Color.yellow;
        } else {
            color = Color.MAGENTA;
        }
    }
}
