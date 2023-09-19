package visao;

import controle.Empacotamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Disciplina;

public class CadastroDisciplinas extends javax.swing.JFrame {

    /**
     * Creates new form CadastroDisciplinas
     */
    public CadastroDisciplinas() {
        initComponents();
    }

    ArrayList<Object> lista = Empacotamento.lerArquivoBinario("../ProjetoFinal/Serializados/disciplina.ser");

    //metodo adiciona e serializa as informacoes
    public boolean adicionaDisciplinaSer() {

        Double[] vetor = new Double[4];
        String disciplinas;
        Disciplina di = new Disciplina();

        try {

            double valor1 = 0;
            double valor2 = 0;
            double valor3 = 0;
            double valor4 = 0;

            //verifica se os atributos nao estao vazio         
            if (!txtNota1.getText().isEmpty()) {
                valor1 = Double.parseDouble(getTxtNota1().getText());
            } 
            if (!txtNota2.getText().isEmpty()) {
                valor2 = Double.parseDouble(getTxtNota2().getText());
            }
            if (!txtNota3.getText().isEmpty()) {
                valor3 = Double.parseDouble(getTxtNota3().getText());
            }
            if (!txtNota4.getText().isEmpty()) {
                valor4 = Double.parseDouble(getTxtNota4().getText());
            }

            vetor[0] = valor1;
            vetor[1] = valor2;
            vetor[2] = valor3;
            vetor[3] = valor4;

            disciplinas = txtDisciplina.getText().trim();
            di.setNome(disciplinas);

            di.setNota(vetor);

            lista.add(di);

            Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/disciplina.ser");

        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        return true;

    }

    //metodo para buscar uma disciplina por nome
    public Disciplina buscaDisciplina(String nome) {

        Disciplina d = null;

        for (Object dis : lista) {

            if (((Disciplina) dis).getNome().equals(nome)) {

                d = (Disciplina) dis;
                break;
            } else {
                d = null;
            }
        }

        if (d == null) {
            return null;
        }

        return d;
    }

    //metodo para editar
    public void edita() {

        String nome = JOptionPane.showInputDialog("Digite o nome da disciplina");

        //String nome = txtDisciplina.getText();
        Disciplina usu = buscaDisciplina(nome);

        if (usu != null) {

            Double[] vetor = new Double[4];

            double valor1 = 0;
            double valor2 = 0;
            double valor3 = 0;
            double valor4 = 0;

            if (!txtNota1.getText().isEmpty()) {
                valor1 = Double.parseDouble(getTxtNota1().getText());
            }
            if (!txtNota2.getText().isEmpty()) {
                valor2 = Double.parseDouble(getTxtNota2().getText());
            }
            if (!txtNota3.getText().isEmpty()) {
                valor3 = Double.parseDouble(getTxtNota3().getText());
            }
            if (!txtNota4.getText().isEmpty()) {
                valor4 = Double.parseDouble(getTxtNota4().getText());
            }

            vetor[0] = valor1;
            vetor[1] = valor2;
            vetor[2] = valor3;
            vetor[3] = valor4;

            usu.setNome(txtDisciplina.getText());

            usu.setNota(vetor);

            Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/disciplina.ser");
            JOptionPane.showMessageDialog(null, "alterado com sucesso");

        } else {

            JOptionPane.showMessageDialog(null, "erro");

        }

    }

    //metodo busca e seta as disciplinas nos campos
    public void exibeDisciplina(String nome) {

        Double[] vetor = null;
        int i;

        Disciplina usu = buscaDisciplina(nome);
        if (usu == null) {
            System.out.println("Disciplina nao cadastrada");
            JOptionPane.showMessageDialog(null, "Disciplina nao encontrada");
        } else {

            txtDisciplina.setText(usu.getNome());

            for (i = 0; i < usu.nota.length; i++) {

                txtNota1.setText(usu.nota[0].toString());
                txtNota2.setText(usu.nota[1].toString());
                txtNota3.setText(usu.nota[2].toString());
                txtNota4.setText(usu.nota[3].toString());

            }

            for (int j = 0; j < lista.size(); j++) {
                Disciplina dis = (Disciplina) lista.get(j);

                DefaultTableModel tbl = (DefaultTableModel) tblDisciplina.getModel();

                Object[] dados = {dis.getNome(), dis.calculaMedia()};
                tbl.addRow(dados);

            }

        }
    }

    //Metodo para remover uma disciplina
    public boolean remover(String nome) {

        nome = JOptionPane.showInputDialog("Digite o nome da disciplina");

        Disciplina usu = buscaDisciplina(nome);
        if (lista.remove(usu)) {
            Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/disciplina.ser");
            return true;
        }

        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDisciplina = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSalvarDisciplina = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtNota1 = new javax.swing.JFormattedTextField();
        txtNota2 = new javax.swing.JFormattedTextField();
        txtNota3 = new javax.swing.JFormattedTextField();
        txtNota4 = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisciplina = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Disciplina");
        setResizable(false);

        jLabel1.setText("Disciplina:");

        jLabel2.setText("Nota 1:");

        jLabel3.setText("Nota 2:");

        jLabel4.setText("Nota 3:");

        jLabel5.setText("Nota 4:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Disciplina");

        btnSalvarDisciplina.setForeground(new java.awt.Color(255, 0, 0));
        btnSalvarDisciplina.setText("Salvar");
        btnSalvarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDisciplinaActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        try {
            txtNota1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtNota2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtNota3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtNota4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tblDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina", "Media"
            }
        ));
        jScrollPane1.setViewportView(tblDisciplina);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNota4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNota3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNota2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNota1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnSalvarDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnPesquisar)
                        .addGap(42, 42, 42)
                        .addComponent(btnEditar)
                        .addGap(50, 50, 50)
                        .addComponent(btnRemover)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNota3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNota4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarDisciplina)
                    .addComponent(btnPesquisar)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover))
                .addGap(270, 270, 270))
        );

        setSize(new java.awt.Dimension(693, 574));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //metodo que quando ao clicar no botao salvar ele vai salvar as diciplinas e suas notas
    private void btnSalvarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDisciplinaActionPerformed

        //Validacao no JFormattedTextField
        if (txtDisciplina.getText().isEmpty() || txtDisciplina.getText().equals(" ") || txtDisciplina.getText().length()<= 4 || txtNota1.getText().equals(" .  ") || txtNota2.getText().equals(" .  ") || txtNota3.getText().equals(" .  ")||txtNota4.getText().equals(" .  ")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Vazio!");
        } else if (adicionaDisciplinaSer() == true) {
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
            txtDisciplina.setText("");
            txtNota1.setText("");
            txtNota2.setText("");
            txtNota3.setText("");
            txtNota4.setText("");
        }


    }//GEN-LAST:event_btnSalvarDisciplinaActionPerformed

    //funcionalidade botao pesquisar
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        String nome = JOptionPane.showInputDialog("Digite o nome da disciplina");

        exibeDisciplina(nome);

    }//GEN-LAST:event_btnPesquisarActionPerformed

    //metodo que quando clicar no botao remover ele vai remover uma disciplina
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed

        if (remover(txtDisciplina.getText()) == true) {
            JOptionPane.showMessageDialog(null, "Disciplina Removida Com Sucesso");
            txtDisciplina.setText("");
            txtNota1.setText("");
            txtNota2.setText("");
            txtNota3.setText("");
            txtNota4.setText("");
        } else {

            JOptionPane.showMessageDialog(null, "nao foi possivel remover a disciplina");
        }

    }//GEN-LAST:event_btnRemoverActionPerformed

    //funcionalidade botao editar
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        edita();


    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroDisciplinas().setVisible(true);
            }
        });
    }

    //metodos gets
    public JTextField getTxtDisciplina() {
        return txtDisciplina;
    }

    public JTextField getTxtNota1() {
        return txtNota1;
    }

    public JTextField getTxtNota2() {
        return txtNota2;
    }

    public JTextField getTxtNota3() {
        return txtNota3;
    }

    public JTextField getTxtNota4() {
        return txtNota4;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvarDisciplina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDisciplina;
    private javax.swing.JTextField txtDisciplina;
    private javax.swing.JFormattedTextField txtNota1;
    private javax.swing.JFormattedTextField txtNota2;
    private javax.swing.JFormattedTextField txtNota3;
    private javax.swing.JFormattedTextField txtNota4;
    // End of variables declaration//GEN-END:variables
}
