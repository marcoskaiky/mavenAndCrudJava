package marcos.garcia;

import marcos.garcia.gui.AlunoGui;
import marcos.garcia.model.Aluno;
import marcos.garcia.service.AlunoService;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(Main::iniciar);

    }

    private static void iniciar() {
        var alunoGui = new AlunoGui();
        alunoGui.setVisible(true);
    }


}

