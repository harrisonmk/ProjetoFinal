
package visao;

import controle.Empacotamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Bolo;


public class CadastroBolos extends javax.swing.JFrame {

  
    public CadastroBolos() {
        initComponents();
    }

    
    ArrayList<Object> lista = Empacotamento.lerArquivoBinario("../ProjetoFinal/Serializados/bolo.ser");

    //metodo adiciona e serializa as informacoes
    public boolean adicionaBoloSer() {

        Double edicao = 0.0;

        

            String nome = txtNome.getText().trim();
            String tipo = txtTipo.getText().trim();
             String recheio = txtRecheio.getText().trim();
            if (!txtPreco.getText().isEmpty()) {
                edicao = Double.valueOf(txtPreco.getText());
            }
            

             Bolo bolo = new Bolo();
             bolo.setNome(nome);
             bolo.setTipo(tipo);
             bolo.setRecheio(recheio);
             bolo.setPreco(edicao);
            
            

            lista.add(bolo);

            

                Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/bolo.ser");

            

        return true;

    }
    
    
    //metodo para buscar um bolo por nome
    public Bolo buscaBolo(String nome) {
       
        Bolo d = null;

        for (Object dis:lista) {
            
            if (((Bolo)dis).getNome().equals(nome)) {

                d = (Bolo) dis;
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
    
    //metodo busca e seta as informacoes do bolo nos campos
 public void exibeBolo(String nome) {
     
     
        Bolo usu = buscaBolo(nome);
        if (usu == null) {
            System.out.println("bolo nao cadastrado");
            JOptionPane.showMessageDialog(null,"bolo nao encontrado");
        } else {

            txtNome.setText(usu.getNome());
            txtTipo.setText(usu.getTipo());
            txtRecheio.setText(usu.getRecheio());
            txtPreco.setText(usu.getPreco().toString());            
 
              for (int i = 0; i < lista.size(); i++) {
               Bolo  dis = (Bolo) lista.get(i);
                
            DefaultTableModel tbl = (DefaultTableModel) tblBolo.getModel();
            Object[] dados= {dis.getRecheio()};
            tbl.addRow(dados);
            }
            
        }
    }
 
   //Metodo para remover um bolo 
   public boolean remover(String nome) {
        
       nome = JOptionPane.showInputDialog("Digite o nome do bolo"); 
        
       Bolo usu = buscaBolo(nome);
       if (lista.remove(usu)) {
         Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/bolo.ser");
         return true;
        }

  
     return false;
     } 
    
   //metodo para editar   
     public void edita(){
        
       String nome = JOptionPane.showInputDialog("Digite o nome do cliente"); 
        
        //String nome = txtDisciplina.getText();
        
       Bolo usu = buscaBolo(nome);
       Double edicao = 0.0;
       
       if(usu != null){
       
            String nomes = txtNome.getText().trim();
            String tipo = txtTipo.getText().trim();
            String recheio = txtRecheio.getText().trim();
            if (!txtPreco.getText().isEmpty()) {
                edicao = Double.valueOf(txtPreco.getText());
            }
            

             
             usu.setNome(nomes);
             usu.setTipo(tipo);
             usu.setRecheio(recheio);
             usu.setPreco(edicao);
         
            

          
       
             
       Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/bolo.ser"); 
        JOptionPane.showMessageDialog(null, "alterado com sucesso");
        
       }else {
           
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
        txtRecheio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBolo = new javax.swing.JTable();
        txtPreco = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CadastrarBolo");
        setResizable(false);

        jLabel1.setText("Nome:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Recheio:");

        jLabel4.setText("Preço:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Bolo");

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

        tblBolo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recheio"
            }
        ));
        jScrollPane1.setViewportView(tblBolo);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(205, 205, 205)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRecheio)
                                        .addComponent(txtPreco)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addGap(21, 21, 21)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(194, 194, 194)
                            .addComponent(btnSalvar)
                            .addGap(43, 43, 43)
                            .addComponent(btnPesquisar)
                            .addGap(40, 40, 40)
                            .addComponent(btnEditar)
                            .addGap(42, 42, 42)
                            .addComponent(btnRemover))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(347, 347, 347)
                            .addComponent(jLabel5))))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRecheio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnPesquisar)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover))
                .addGap(128, 128, 128))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    //funcionalidade botao salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
       
        
               //Validacao no JFormattedTextField
        if (txtNome.getText().isEmpty() || txtNome.getText().equals(" ") || txtNome.getText().length() <= 4
                || txtTipo.getText().isEmpty() || txtTipo.getText().equals(" ") || txtTipo.getText().length() <= 4
                || txtRecheio.getText().isEmpty() || txtRecheio.getText().equals(" ") || txtRecheio.getText().length() <= 4
                || txtPreco.getText().equals("  .  ")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Vazio!");
        } else if (adicionaBoloSer() == true) {
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
            txtNome.setText("");
            txtTipo.setText("");
            txtRecheio.setText("");
            txtPreco.setText(""); 
        }
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    //funcionalidade botao pesquisar
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
         String nome = JOptionPane.showInputDialog("Digite o nome do bolo");
        
        exibeBolo(nome);  
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    //funcionalidade botao remover
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
       
            if(remover(txtNome.getText()) == true){
           JOptionPane.showMessageDialog(null,"bolo Removido Com Sucesso");
            txtNome.setText("");
            txtTipo.setText("");
            txtRecheio.setText("");
            txtPreco.setText("");  
            
       }else {
           
          JOptionPane.showMessageDialog(null,"nao foi possivel remover o bolo"); 
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
            java.util.logging.Logger.getLogger(CadastroBolos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroBolos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroBolos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroBolos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroBolos().setVisible(true);
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
    private javax.swing.JTable tblBolo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtPreco;
    private javax.swing.JTextField txtRecheio;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
