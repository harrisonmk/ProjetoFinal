package visao;

import controle.Empacotamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Livro;

public class CadastroLivros extends javax.swing.JFrame {

    /**
     * Creates new form CadastroLivros
     */
    public CadastroLivros() {
        initComponents();
    }
    Livro l = new Livro();
    ArrayList<Object> lista = Empacotamento.lerArquivoBinario("../ProjetoFinal/Serializados/livro.ser");

    //metodo adiciona e serializa as informacoes
    public boolean adicionaLivroSer() {

        Integer edicao = null;

        String nome = txtNome.getText().trim();
        String editora = txtEditora.getText().trim();
        String texto = txtEdicao.getText().trim();
        // if (!texto.isEmpty()) {
        //    edicao = Integer.parseInt(texto);
        //}
        if (!texto.isEmpty()) { // Verifica se o campo de texto não está vazio

            edicao = Integer.valueOf(texto); // Tenta converter a String em int

        }
        String area = txtArea.getText().trim();

        Livro livro = new Livro();
        livro.setNome(nome);
        livro.setEditora(editora);
        livro.setEdicao(edicao);
        livro.setArea(area);

        lista.add(livro);

        Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/livro.ser");

        return true;

    }

    //metodo para buscar uma disciplina por nome
    public Livro buscaLivro(String nome) {

        Livro d = null;

        for (Object dis : lista) {

            if (((Livro) dis).getNome().equals(nome)) {

                d = (Livro) dis;
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
    public void exibeLivro(String nome) {

        Livro usu = buscaLivro(nome);
        if (usu == null) {
            System.out.println("Livro nao cadastrado");
            JOptionPane.showMessageDialog(null, "Livro nao encontrado");
        } else {

            txtNome.setText(usu.getNome());
            txtEditora.setText(usu.getEditora());
            txtEdicao.setText(usu.getEdicao().toString());
            txtArea.setText(usu.getArea());

            for (int i = 0; i < lista.size(); i++) {
                Livro dis = (Livro) lista.get(i);

                DefaultTableModel tbl = (DefaultTableModel) tabelaLivros.getModel();
                Object[] dados = {dis.getEditora()};
                tbl.addRow(dados);
            }

        }
    }

    //Metodo para remover uma disciplina
    public boolean remover(String nome) {

        nome = JOptionPane.showInputDialog("Digite o nome do livro");

        Livro usu = buscaLivro(nome);
        if (lista.remove(usu)) {
            Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/livro.ser");
            return true;
        }

        return false;
    }

    //metodo para editar   
    public void edita() {

        String nome = JOptionPane.showInputDialog("Digite o nome do livro");

        //String nome = txtDisciplina.getText();
        Livro usu = buscaLivro(nome);

        if (usu != null) {

            Integer edicao = 0;

            String nomes = txtNome.getText().trim();
            String editora = txtEditora.getText().trim();
            if (!txtEdicao.getText().isEmpty()) {
                edicao = Integer.valueOf(txtEdicao.getText());
            }
            String area = txtArea.getText().trim();

            usu.setNome(nomes);
            usu.setEditora(editora);
            usu.setEdicao(edicao);
            usu.setArea(area);

            Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/livro.ser");
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
        txtEditora = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        txtEdicao = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Livro");
        setResizable(false);

        jLabel1.setText("Nome:");

        jLabel2.setText("Editora:");

        jLabel3.setText("Edicao:");

        jLabel4.setText("area:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Livro");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
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

        try {
            txtEdicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtEdicao.setToolTipText("");

        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Editora"
            }
        ));
        jScrollPane1.setViewportView(tabelaLivros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtArea))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEdicao))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEditora))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnSalvar)
                        .addGap(52, 52, 52)
                        .addComponent(btnPesquisar)
                        .addGap(40, 40, 40)
                        .addComponent(btnEditar)
                        .addGap(62, 62, 62)
                        .addComponent(btnRemover)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 197, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemover)
                            .addComponent(btnEditar)
                            .addComponent(btnPesquisar)
                            .addComponent(btnSalvar))
                        .addGap(60, 60, 60))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //funcionalidade botao salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        //Validacao no JFormattedTextField
        if (txtNome.getText().isEmpty() || txtNome.getText().equals(" ") || txtNome.getText().length() <= 4 || txtEditora.getText().isEmpty() || txtEditora.getText().equals(" ") || txtEditora.getText().length() <= 4
                || txtEdicao.getText().isEmpty() || txtEdicao.getText().equals(" ") || txtEdicao.getText().equals("  ")
                || txtArea.getText().isEmpty() || txtArea.getText().equals(" ") || txtArea.getText().length() <= 4) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Vazio!");
        } else if (adicionaLivroSer() == true) {
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
            txtNome.setText("");
            txtEditora.setText("");
            txtEdicao.setText("");
            txtArea.setText("");
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    //funcionalidade botao pesquisar
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        String nome = JOptionPane.showInputDialog("Digite o nome do livro");

        exibeLivro(nome);


    }//GEN-LAST:event_btnPesquisarActionPerformed

    //funcionalidade botao remover
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed

        if (remover(txtNome.getText()) == true) {
            JOptionPane.showMessageDialog(null, "Livro Removido Com Sucesso");
            txtNome.setText("");
            txtEditora.setText("");
            txtEdicao.setText("");
            txtArea.setText(null);

        } else {

            JOptionPane.showMessageDialog(null, "nao foi possivel remover o livro");
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
            java.util.logging.Logger.getLogger(CadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroLivros().setVisible(true);
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
    private javax.swing.JTable tabelaLivros;
    private javax.swing.JTextField txtArea;
    private javax.swing.JFormattedTextField txtEdicao;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
