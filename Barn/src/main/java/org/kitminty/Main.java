package org.kitminty;
import com.perunlabs.jsolid.d1.Angle;
import com.perunlabs.jsolid.d3.Axis;
import com.perunlabs.jsolid.d3.Solid;
import java.io.IOException;
import java.nio.file.Paths;

import static com.perunlabs.jsolid.JSolid.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Solid solid = cuboid(45, 30, 80)
                .add(prism(regularPolygon(7, 3), 80)
                        .scale(Axis.X, 3)
                        .rotate(Axis.Z, Angle.degrees(-12))
                        .moveBy(v(18, 17.6, 0))
                .add(prism(regularPolygon(25, 3), 80)
                        .scale(Axis.X, 0.6)
                        .moveBy(v(22.5, 0.8, 0))
                        .rotate(Axis.Z, Angle.degrees(90))));
        com.perunlabs.jsolid.d3.Stl.toStl(solid, Paths.get("~/documents/Barn.stl"));
    }
}