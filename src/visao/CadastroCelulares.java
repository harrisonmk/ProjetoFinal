
package visao;

import controle.Empacotamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Celular;


public class CadastroCelulares extends javax.swing.JFrame {

   
    public CadastroCelulares() {
        initComponents();
    }

    ArrayList<Object> lista = Empacotamento.lerArquivoBinario("../ProjetoFinal/Serializados/celular.ser");

    //metodo adiciona e serializa as informacoes
    public boolean adicionaCelularSer() {

        
          
            Double preco = null;

            String fabricante = txtFabricante.getText().trim();
            String modelo = txtModelo.getText().trim();
            String nome = txtCliente.getText().trim();
         
            if(!txtPreco.getText().isEmpty()){
            preco = Double.parseDouble(txtPreco.getText());
            }

             Celular celular = new Celular();
             celular.setFabricante(fabricante);
             celular.setModelo(modelo);
             celular.setNomeCliente(nome);
             celular.setPreco(preco);
            
            

            lista.add(celular);

            

                Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/celular.ser");

            

        return true;

    }
    
    
    //metodo para buscar um celular por nome
    public Celular buscaCelular(String nome) {
       
        Celular d = null;

        for (Object dis:lista) {
            
            if (((Celular)dis).getFabricante().equals(nome)) {

                d = (Celular) dis;
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
    
    //metodo busca e seta as informacoes do celular nos campos
 public void exibeCelular(String nome) {
     
     
        Celular usu = buscaCelular(nome);
        if (usu == null) {
            System.out.println("celular nao cadastrado");
            JOptionPane.showMessageDialog(null,"celular nao encontrado");
        } else {

            txtFabricante.setText(usu.getFabricante());
            txtModelo.setText(usu.getModelo());
            txtCliente.setText(usu.getNomeCliente()); 
            txtPreco.setText(usu.getPreco().toString());
 
                 for (int i = 0; i < lista.size(); i++) {
               Celular  dis = (Celular) lista.get(i);
                
            DefaultTableModel tbl = (DefaultTableModel) tblCelular.getModel();
            Object[] dados= {dis.getFabricante()};
            tbl.addRow(dados);
            }
            
        }
    }
 
   //Metodo para remover um celular
   public boolean remover(String nome) {
        
       nome = JOptionPane.showInputDialog("Digite nome do fabricante"); 
        
       Celular usu = buscaCelular(nome);
       if (lista.remove(usu)) {
         Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/celular.ser");
         return true;
        }

  
     return false;
     } 
   
   //metodo para editar
    public void edita(){
        
       String nome = JOptionPane.showInputDialog("Digite o nome do fabricante"); 
        
        //String nome = txtDisciplina.getText();
        
       Celular usu = buscaCelular(nome);
       
       
       if(usu != null){
       
             Double preco = null;

            String fabricante = txtFabricante.getText().trim();
            String modelo = txtModelo.getText().trim();
            String nomes = txtCliente.getText().trim();
         
            if(!txtPreco.getText().isEmpty()){
            preco = Double.parseDouble(txtPreco.getText());
            }

             
             usu.setFabricante(fabricante);
             usu.setModelo(modelo);
             usu.setNomeCliente(nome);
             usu.setPreco(preco);
            

             
       
             
       Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/celular.ser"); 
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
        txtFabricante = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCelular = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Fabricante:");

        jLabel2.setText("Modelo:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Preço:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Celular");

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

        tblCelular.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fabricante"
            }
        ));
        jScrollPane1.setViewportView(tblCelular);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFabricante)
                    .addComponent(txtModelo)
                    .addComponent(txtCliente)
                    .addComponent(txtPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(28, 28, 28)
                        .addComponent(btnPesquisar)
                        .addGap(37, 37, 37)
                        .addComponent(btnEditar)
                        .addGap(42, 42, 42)
                        .addComponent(btnRemover)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(306, 306, 306))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(106, 106, 106)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnPesquisar)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover))
                .addGap(25, 25, 25))
        );

        setSize(new java.awt.Dimension(715, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //funcionalidade botao salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if(adicionaCelularSer() ==true){
            JOptionPane.showMessageDialog(null,"Cadastro Realizado com sucesso");
            txtFabricante.setText("");
            txtModelo.setText("");
            txtCliente.setText("");  
            txtPreco.setText("");
        }      
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    //funcionalidade botao pesquisar
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       
     String nome = JOptionPane.showInputDialog("Digite o nome do fabricante");
        
        exibeCelular(nome);      
        
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    //funcionalidade botao remover
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        
        if(remover(txtFabricante.getText()) == true){
           JOptionPane.showMessageDialog(null,"Celular Removido Com Sucesso");
             txtFabricante.setText("");
            txtModelo.setText("");
            txtCliente.setText("");
            txtPreco.setText("");   
            
       }else {
           
          JOptionPane.showMessageDialog(null,"nao foi possivel remover o celular"); 
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
            java.util.logging.Logger.getLogger(CadastroCelulares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCelulares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCelulares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCelulares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCelulares().setVisible(true);
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
    private javax.swing.JTable tblCelular;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
