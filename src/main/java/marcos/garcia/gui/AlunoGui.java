package marcos.garcia.gui;

import marcos.garcia.model.Aluno;
import marcos.garcia.service.AlunoService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AlunoGui extends JFrame {

    private JLabel jlID;
    private JTextField tfID;


    private JLabel jlNome;
    private JTextField tfNome;

    private JLabel jlCpf;
    private JTextField tfCpf;

    private JLabel jlEndereco;
    private JTextField tfEndereco;

    private JButton btConfirmar;
    private JTable tbAlunos;

    public AlunoGui() {
        setTitle("Cadastro de Aluno");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(montarPainelEntrada(), BorderLayout.NORTH);
        getContentPane().add(montarPainelSaida(), BorderLayout.CENTER);
    }

    private JPanel montarPainelEntrada() {
        var jPanel = new JPanel(new GridBagLayout());
        var guiUtils = new GuiUtils();

        jlID = new JLabel("RA");
        tfID = new JTextField(20);
        tfID.setEditable(false);

        jlNome = new JLabel("Nome");
        tfNome = new JTextField(20);
        jlCpf = new JLabel("CPF");
        tfCpf = new JTextField(20);
        jlEndereco = new JLabel("Endereço");
        tfEndereco = new JTextField(20);
        btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(this::confirmar);

        jPanel.add(jlID, guiUtils.montarConstraints(0, 0));
        jPanel.add(tfID, guiUtils.montarConstraints(1, 0));
        jPanel.add(jlNome, guiUtils.montarConstraints(0, 1));
        jPanel.add(tfNome, guiUtils.montarConstraints(1, 1));
        jPanel.add(jlCpf, guiUtils.montarConstraints(0, 2));
        jPanel.add(tfCpf, guiUtils.montarConstraints(1, 2));
        jPanel.add(jlEndereco, guiUtils.montarConstraints(0, 3));
        jPanel.add(tfEndereco, guiUtils.montarConstraints(1, 3));

        jPanel.add(btConfirmar, guiUtils.montarConstraints(0, 4));

        return jPanel;
    }

    private void confirmar(ActionEvent actionEvent) {

        var servico = new AlunoService();
        var aluno = new Aluno();


        aluno.setId(tfID.getText().isEmpty() ? null : Long.valueOf(tfID.getText()));
        aluno.setNome(tfNome.getText());
        aluno.setCpf(tfCpf.getText());
        aluno.setEndereco(tfEndereco.getText());

        servico.salvar(aluno);
        limparCampos();

    }

    private void limparCampos() {
        tfID.setText(null);
        tfNome.setText(null);
        tfCpf.setText(null);
        tfEndereco.setText(null);

    }

    private JScrollPane montarPainelSaida() {

        var tableModel = new DefaultTableModel();
        tableModel.addColumn("RA");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Cpf");
        tableModel.addColumn("Endereço");

        tableModel.addRow(new Object[]{"14610", "Marcos", "10559343914", "Rua Tal"});

        tbAlunos = new JTable();
        tbAlunos.setDefaultEditor(Object.class, null);
        tbAlunos.getSelectionModel()
                .addListSelectionListener((this::selecionar));
        tbAlunos.setModel(tableModel);

        return new JScrollPane(tbAlunos);

    }

    private void selecionar(ListSelectionEvent listSelectionEvent) {




    }

}
