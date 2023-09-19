package visao;

import controle.Empacotamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Pet;

public class CadastroPets extends javax.swing.JFrame {

    /**
     * Creates new form CadastroPets
     */
    public CadastroPets() {
        initComponents();
    }

    ArrayList<Object> lista = Empacotamento.lerArquivoBinario("../ProjetoFinal/Serializados/pet.ser");

    //metodo adiciona e serializa as informacoes
    public boolean adicionaPetSer() {

        Double edicao = 0.0;

        String nome = txtNome.getText().trim();
        String tipo = txtTipo.getText().trim();
        String raca = txtRaca.getText().trim();
        if (!txtPreco.getText().isEmpty()) {
            edicao = Double.valueOf(txtPreco.getText());
        }

        Pet pet = new Pet();
        pet.setNome(nome);
        pet.setTipo(tipo);
        pet.setRaca(raca);
        pet.setPreco(edicao);

        //adiciona o pet na lista
        lista.add(pet);

        //cria o arquivo pet.ser com as informacoes salvas
        Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/pet.ser");

        return true;

    }

    //metodo para buscar uma disciplina por nome
    public Pet buscaPet(String nome) {

        Pet d = null;

        for (Object dis : lista) {

            if (((Pet) dis).getNome().equals(nome)) {

                d = (Pet) dis;
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

    //metodo busca e seta as informacoes do livro nos campos
    public void exibePet(String nome) {

        Pet usu = buscaPet(nome);
        if (usu == null) {
            System.out.println("Pet nao cadastrado");
            JOptionPane.showMessageDialog(null, "Pet nao encontrado");
        } else {

            txtNome.setText(usu.getNome());
            txtTipo.setText(usu.getTipo());
            txtRaca.setText(usu.getRaca());
            txtPreco.setText(usu.getPreco().toString());

            for (int i = 0; i < lista.size(); i++) {
                Pet dis = (Pet) lista.get(i);

                DefaultTableModel tbl = (DefaultTableModel) tblPet.getModel();
                Object[] dados = {dis.getTipo()};
                tbl.addRow(dados);
            }

        }
    }

    //Metodo para remover uma disciplina
    public boolean remover(String nome) {

        nome = JOptionPane.showInputDialog("Digite o nome do pet");

        Pet usu = buscaPet(nome);
        if (lista.remove(usu)) {
            Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/pet.ser");
            return true;
        }

        return false;
    }

    //metodo para editar
    public void edita() {

        String nome = JOptionPane.showInputDialog("Digite o nome do pet");

        //String nome = txtDisciplina.getText();
        Pet usu = buscaPet(nome);

        if (usu != null) {

            Double edicao = 0.0;

            String nomes = txtNome.getText().trim();
            String tipo = txtTipo.getText().trim();
            String raca = txtRaca.getText().trim();
            if (!txtPreco.getText().isEmpty()) {
                edicao = Double.valueOf(txtPreco.getText());
            }

            usu.setNome(nomes);
            usu.setTipo(tipo);
            usu.setRaca(raca);
            usu.setPreco(edicao);

            Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/pet.ser");
            JOptionPane.showMessageDialog(null, "alterado com sucesso");

        } else {

            JOptionPane.showMessageDialog(null, "erro");

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtRaca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPet = new javax.swing.JTable();
        txtPreco = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Pet");
        setResizable(false);

        jLabel1.setText("Nome:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Raça:");

        jLabel4.setText("Preço:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Pet");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        tblPet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo"
            }
        ));
        jScrollPane1.setViewportView(tblPet);

        try {
            txtPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnPesquisar)
                        .addGap(59, 59, 59)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(200, 200, 200))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRaca, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(txtPreco))))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnPesquisar)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(737, 618));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //funcionalidade botao salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        //Validacao no JFormattedTextField
        if (txtNome.getText().isEmpty() || txtNome.getText().equals(" ") || txtNome.getText().length() <= 4
                || txtTipo.getText().isEmpty() || txtTipo.getText().equals(" ") || txtTipo.getText().length() <= 4
                || txtRaca.getText().isEmpty() || txtRaca.getText().equals(" ") || txtRaca.getText().length() <= 4
                || txtPreco.getText().equals("  .  ")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Vazio!");
        } else if (adicionaPetSer() == true) {
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
            txtNome.setText("");
            txtTipo.setText("");
            txtRaca.setText("");
            txtPreco.setText("");
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    //funcionalidade botao pesquisar
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        String nome = JOptionPane.showInputDialog("Digite o nome do pet");

        exibePet(nome);


    }//GEN-LAST:event_btnPesquisarActionPerformed

    //funcionalidade botao remover
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed

        if (remover(txtNome.getText()) == true) {
            JOptionPane.showMessageDialog(null, "Pet Removido Com Sucesso");
            txtNome.setText("");
            txtTipo.setText("");
            txtRaca.setText("");
            txtPreco.setText("");

        } else {

            JOptionPane.showMessageDialog(null, "nao foi possivel remover o pet");
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
            java.util.logging.Logger.getLogger(CadastroPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPet;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtPreco;
    private javax.swing.JTextField txtRaca;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
