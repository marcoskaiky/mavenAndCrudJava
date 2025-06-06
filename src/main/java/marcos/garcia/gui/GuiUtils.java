package marcos.garcia.gui;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GuiUtils {

    public GridBagConstraints montarConstraints(int x, int y) {
        var constraint = new GridBagConstraints();
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.gridx = x;
        constraint.gridy = y;
        return constraint;
    }


}
