
package visao;

import controle.Empacotamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Noticia;


public class CadastroNoticia extends javax.swing.JFrame {

   
    public CadastroNoticia() {
        initComponents();
    }
    
    
    ArrayList<Object> lista = Empacotamento.lerArquivoBinario("../ProjetoFinal/Serializados/noticia.ser");

    //metodo adiciona e serializa as informacoes
    public boolean adicionaNoticiaSer() {

        

        

            String titulo = txtTitulo.getText().trim();
            String autor = txtAutor.getText().trim();
            String data = txtData.getText().trim();
            String conteudo = txtConteudo.getText().trim();
            
            

             Noticia noticia = new Noticia();
             noticia.setTitulo(titulo);
             noticia.setAutor(autor);
             noticia.setData(data);
             noticia.setConteudo(conteudo);
            
            

            lista.add(noticia);

            

                Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/noticia.ser");

            

        return true;

    }
    
    
    //metodo para buscar uma noticia por nome
    public Noticia buscaNoticia(String nome) {
       
        Noticia d = null;

        for (Object dis:lista) {
            
            if (((Noticia)dis).getTitulo().equals(nome)) {

                d = (Noticia) dis;
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
 public void exibeNoticia(String nome) {
     
     
        Noticia usu = buscaNoticia(nome);
        if (usu == null) {
            System.out.println("noticia nao cadastrado");
            JOptionPane.showMessageDialog(null,"noticia nao encontrado");
        } else {

            txtTitulo.setText(usu.getTitulo());
            txtAutor.setText(usu.getAutor());
            txtData.setText(usu.getData());
            txtConteudo.setText(usu.getConteudo());            
 
          for (int i = 0; i < lista.size(); i++) {
               Noticia  dis = (Noticia) lista.get(i);
                
            DefaultTableModel tbl = (DefaultTableModel) tblNoticia.getModel();
            Object[] dados= {dis.getData()};
            tbl.addRow(dados);
            }  
            
        }
    }
 
   //Metodo para remover uma noticia
   public boolean remover(String nome) {
        
       nome = JOptionPane.showInputDialog("Digite o titulo da noticia"); 
        
       Noticia usu = buscaNoticia(nome);
       if (lista.remove(usu)) {
         Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/noticia.ser");
         return true;
        }

  
     return false;
     } 
    
   //metodo para editar uma noticia
   public void edita(){
        
       String nome = JOptionPane.showInputDialog("Digite o nome da noticia"); 
        
        //String nome = txtDisciplina.getText();
        
       Noticia usu = buscaNoticia(nome);
       
       if(usu != null){
       
            String titulo = txtTitulo.getText().trim();
            String autor = txtAutor.getText().trim();
            String data = txtData.getText().trim();
            String conteudo = txtConteudo.getText().trim();
            
            

             
             usu.setTitulo(titulo);
             usu.setAutor(autor);
             usu.setData(data);
             usu.setConteudo(conteudo);
       
             
       Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/noticia.ser"); 
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
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        txtConteudo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        brnEditar = new javax.swing.JButton();
        brnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNoticia = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Noticias");
        setResizable(false);

        jLabel1.setText("Titulo:");

        jLabel2.setText("Autor:");

        jLabel3.setText("Data:");

        jLabel4.setText("Conteudo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Noticia");

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

        brnEditar.setText("editar");
        brnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnEditarActionPerformed(evt);
            }
        });

        brnRemover.setText("Remover");
        brnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnRemoverActionPerformed(evt);
            }
        });

        tblNoticia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data"
            }
        ));
        jScrollPane1.setViewportView(tblNoticia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(31, 31, 31)
                        .addComponent(btnPesquisar)
                        .addGap(48, 48, 48)
                        .addComponent(brnEditar)
                        .addGap(33, 33, 33)
                        .addComponent(brnRemover)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel5)
                        .addGap(266, 266, 266))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTitulo)
                                    .addComponent(txtAutor)
                                    .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnPesquisar)
                    .addComponent(brnEditar)
                    .addComponent(brnRemover))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //funcionalidade botao salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       

       
               //Validacao no JFormattedTextField
        if (txtTitulo.getText().isEmpty() || txtTitulo.getText().equals(" ") || txtTitulo.getText().length() <= 4
                || txtAutor.getText().isEmpty() || txtAutor.getText().equals(" ") || txtAutor.getText().length() <= 4
                || txtData.getText().isEmpty() || txtData.getText().equals(" ") || txtData.getText().length() <= 4
                || txtConteudo.getText().isEmpty() || txtConteudo.getText().equals(" ") || txtConteudo.getText().length() <= 4) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Vazio!");
        } else if (adicionaNoticiaSer() == true) {
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
            txtTitulo.setText("");
            txtAutor.setText("");
            txtData.setText("");
            txtConteudo.setText(""); 
        }
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    //funcionalidade botao pesquisar
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
         String nome = JOptionPane.showInputDialog("Digite o titulo da noticia");
        
        exibeNoticia(nome);  
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    //funcionalidade botao remover
    private void brnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnRemoverActionPerformed
        
         if(remover(txtTitulo.getText()) == true){
           JOptionPane.showMessageDialog(null,"noticia Removido Com Sucesso");
            txtTitulo.setText("");
            txtAutor.setText("");
            txtData.setText("");
            txtConteudo.setText(null);    
            
       }else {
           
          JOptionPane.showMessageDialog(null,"nao foi possivel remover a noticia"); 
       }   
        
        
    }//GEN-LAST:event_brnRemoverActionPerformed

    //funcionalidade botao editar
    private void brnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnEditarActionPerformed
       edita();
    }//GEN-LAST:event_brnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroNoticia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnEditar;
    private javax.swing.JButton brnRemover;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNoticia;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtConteudo;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
