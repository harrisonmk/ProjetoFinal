
package visao;

import controle.Empacotamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Carro;


public class CadastroCarros extends javax.swing.JFrame {

   
    public CadastroCarros() {
        initComponents();
    }

    ArrayList<Object> lista = Empacotamento.lerArquivoBinario("../ProjetoFinal/Serializados/carro.ser");

    //metodo adiciona e serializa as informacoes
    public boolean adicionaCarroSer() {

        
            Double quilometragem = null;
            Double preco = null;

            String fabricante = txtFabricante.getText().trim();
            String modelo = txtModelo.getText().trim();
            String ano = txtAno.getText().trim();
            if(!txtQuilometragem.getText().isEmpty()){
             quilometragem = Double.parseDouble(txtQuilometragem.getText());
            }
            if(!txtPreco.getText().isEmpty()){
            preco = Double.parseDouble(txtPreco.getText());
            }

             Carro carro = new Carro();
             carro.setFabricante(fabricante);
             carro.setModelo(modelo);
             carro.setAno(ano);
             carro.setQuilometragem(quilometragem);
             carro.setPreco(preco);
            
            

            lista.add(carro);

            

                Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/carro.ser");

            

        return true;

    }
    
    
    //metodo para buscar uma noticia por nome
    public Carro buscaCarro(String nome) {
       
        Carro d = null;

        for (Object dis:lista) {
            
            if (((Carro)dis).getFabricante().equals(nome)) {

                d = (Carro) dis;
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
    
    //metodo busca e seta as informacoes da noticia nos campos
 public void exibeCarro(String nome) {
     
     
        Carro usu = buscaCarro(nome);
        if (usu == null) {
            System.out.println("carro nao cadastrado");
            JOptionPane.showMessageDialog(null,"carro nao encontrado");
        } else {

            txtFabricante.setText(usu.getFabricante());
            txtModelo.setText(usu.getModelo());
            txtAno.setText(usu.getAno());
            txtQuilometragem.setText(usu.getQuilometragem().toString());  
            txtPreco.setText(usu.getPreco().toString());
 
            for (int i = 0; i < lista.size(); i++) {
               Carro  dis = (Carro) lista.get(i);
                
            DefaultTableModel tbl = (DefaultTableModel) tblCarro.getModel();
            Object[] dados= {dis.getFabricante()};
            tbl.addRow(dados);
            }
            
        }
    }
 
   //Metodo para remover uma disciplina
   public boolean remover(String nome) {
        
       nome = JOptionPane.showInputDialog("Digite nome do fabricante"); 
        
       Carro usu = buscaCarro(nome);
       if (lista.remove(usu)) {
         Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/carro.ser");
         return true;
        }

  
     return false;
     } 
   
   //metodo edita
     public void edita(){
        
       String nome = JOptionPane.showInputDialog("Digite o nome do fabricante"); 
        
        //String nome = txtDisciplina.getText();
        
       Carro usu = buscaCarro(nome);
       Double edicao = 0.0;
       
       if(usu != null){
       
            Double quilometragem = null;
            Double preco = null;

            String fabricante = txtFabricante.getText().trim();
            String modelo = txtModelo.getText().trim();
            String ano = txtAno.getText().trim();
            if(!txtQuilometragem.getText().isEmpty()){
             quilometragem = Double.parseDouble(txtQuilometragem.getText());
            }
            if(!txtPreco.getText().isEmpty()){
            preco = Double.parseDouble(txtPreco.getText());
            }

             
             usu.setFabricante(fabricante);
             usu.setModelo(modelo);
             usu.setAno(ano);
             usu.setQuilometragem(quilometragem);
             usu.setPreco(preco);
            

             
       
             
       Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/carro.ser"); 
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFabricante = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        txtQuilometragem = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Carros");
        setResizable(false);

        jLabel1.setText("Fabricante:");

        jLabel2.setText("Modelo:");

        jLabel3.setText("Ano:");

        jLabel4.setText("Quilometragem:");

        jLabel5.setText("Preço:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Carro");

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

        tblCarro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fabricante"
            }
        ));
        jScrollPane1.setViewportView(tblCarro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFabricante)
                                    .addComponent(txtModelo)
                                    .addComponent(txtAno, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(59, 59, 59)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtQuilometragem)
                                    .addComponent(txtPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel6)))
                .addContainerGap(204, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 146, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnSalvar)
                        .addGap(33, 33, 33)
                        .addComponent(btnPesquisar)
                        .addGap(32, 32, 32)
                        .addComponent(btnEditar)
                        .addGap(39, 39, 39)
                        .addComponent(btnRemover))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnPesquisar)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(702, 736));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
   //funcionalidade botao salvar 
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       
        if(adicionaCarroSer() ==true){
            JOptionPane.showMessageDialog(null,"Cadastro Realizado com sucesso");
            txtFabricante.setText("");
            txtModelo.setText("");
            txtAno.setText("");
            txtQuilometragem.setText("");   
            txtPreco.setText("");
        }     
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    //funcionalidade botao pesquisar
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
       String nome = JOptionPane.showInputDialog("Digite o nome do fabricante");
        
        exibeCarro(nome);   
        
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    //funcionalidade botao remover
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
       
        if(remover(txtFabricante.getText()) == true){
           JOptionPane.showMessageDialog(null,"carro Removido Com Sucesso");
             txtFabricante.setText("");
            txtModelo.setText("");
            txtAno.setText("");
            txtQuilometragem.setText("");   
            txtPreco.setText("");   
            
       }else {
           
          JOptionPane.showMessageDialog(null,"nao foi possivel remover o carro"); 
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
            java.util.logging.Logger.getLogger(CadastroCarros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCarros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCarros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCarros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCarros().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCarro;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuilometragem;
    // End of variables declaration//GEN-END:variables
}
