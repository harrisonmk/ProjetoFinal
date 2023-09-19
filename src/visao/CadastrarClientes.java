
package visao;

import controle.Empacotamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;


public class CadastrarClientes extends javax.swing.JFrame {

   //metodo construtor
    public CadastrarClientes() {
        initComponents();
    }

    //atributo que cria uma lista de objetos para salvar no arquivo cliente.ser
    ArrayList<Object> lista = Empacotamento.lerArquivoBinario("../ProjetoFinal/Serializados/cliente.ser");

    //metodo adiciona e serializa as informacoes
    public boolean adicionaClienteSer() {

        
          
            //cria atributos
            String nome = txtNome.getText().trim();
            String telefone = txtTelefone.getText().trim();
            String celular = txtCelular.getText().trim();
            String dataConsulta = txtDataConsulta.getText().trim();
            String especialidade = txtEspecialidade.getText().trim();
         
            
             //setas os atributos no objeto cliente
             Cliente cliente = new Cliente();
             cliente.setNome(nome);
             cliente.setTelefone(telefone);
             cliente.setCelular(celular);
             cliente.setDataConsulta(dataConsulta);
             cliente.setEspecialidade(especialidade);
            
            
               //adiciona na lista
            lista.add(cliente);

            
               //salva em um arquivo cliente.ser
                Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/cliente.ser");

            

        return true;

    }
    
    
    //metodo para buscar um cliente por nome
    public Cliente buscaCliente(String nome) {
       
        Cliente d = null;

        for (Object dis:lista) {
            
            if (((Cliente)dis).getNome().equals(nome)) {

                d = (Cliente) dis;
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
    
    //metodo busca e seta as informacoes do cliente nos campos
 public void exibeCliente(String nome) {
     
     
        Cliente usu = buscaCliente(nome);
        if (usu == null) {
            System.out.println("cliente nao cadastrado");
            JOptionPane.showMessageDialog(null,"cliente nao encontrado");
        } else {

            txtNome.setText(usu.getNome());
            txtTelefone.setText(usu.getTelefone());
            txtCelular.setText(usu.getCelular()); 
            txtDataConsulta.setText(usu.getDataConsulta());
            txtEspecialidade.setText(usu.getEspecialidade());
 
            
             for (int i = 0; i < lista.size(); i++) {
               Cliente  dis = (Cliente) lista.get(i);
                
             DefaultTableModel tbl = (DefaultTableModel) tblEspecialidade.getModel();
            Object[] dados= {dis.getEspecialidade()};
            tbl.addRow(dados);
            }
            
        }
    }
 
   //Metodo para remover umm cliente
   public boolean remover(String nome) {
        
       nome = JOptionPane.showInputDialog("Digite nome do cliente"); 
        
       Cliente usu = buscaCliente(nome);
       if (lista.remove(usu)) {
         Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/cliente.ser");
         return true;
        }

  
     return false;
     } 
    
   
    //metodo para editar 
     public void edita(){
        
       String nome = JOptionPane.showInputDialog("Digite o nome do cliente"); 
        
        //String nome = txtDisciplina.getText();
        
       Cliente usu = buscaCliente(nome);
       
       if(usu != null){
       
            String nomes = txtNome.getText().trim();
            String telefone = txtTelefone.getText().trim();
            String celular = txtCelular.getText().trim();
            String dataConsulta = txtDataConsulta.getText().trim();
            String especialidade = txtEspecialidade.getText().trim();
         
            

             
             usu.setNome(nomes);
             usu.setTelefone(telefone);
             usu.setCelular(celular);
             usu.setDataConsulta(dataConsulta);
             usu.setEspecialidade(especialidade);
       
             
       Empacotamento.gravarArquivoBinario(lista, "../ProjetoFinal/Serializados/cliente.ser"); 
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
        txtNome = new javax.swing.JTextField();
        txtEspecialidade = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        txtCelular = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtDataConsulta = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEspecialidade = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Cliente");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(265, 104, 32, 14);

        jLabel2.setText("Telefone:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(265, 135, 47, 14);

        jLabel3.setText("Celular:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(273, 166, 39, 14);

        jLabel4.setText("Data de Consulta:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(224, 204, 88, 14);

        jLabel5.setText("Especialidade:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(241, 245, 71, 14);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Cliente");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(321, 25, 71, 29);
        getContentPane().add(txtNome);
        txtNome.setBounds(321, 101, 175, 20);
        getContentPane().add(txtEspecialidade);
        txtEspecialidade.setBounds(322, 239, 175, 20);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(170, 500, 63, 23);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar);
        btnPesquisar.setBounds(280, 500, 80, 23);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(400, 500, 61, 23);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemover);
        btnRemover.setBounds(510, 500, 80, 23);

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        getContentPane().add(txtCelular);
        txtCelular.setBounds(320, 160, 180, 20);

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(320, 130, 180, 20);

        try {
            txtDataConsulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtDataConsulta);
        txtDataConsulta.setBounds(320, 200, 180, 20);

        tblEspecialidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Especialidade"
            }
        ));
        jScrollPane1.setViewportView(tblEspecialidade);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 280, 400, 170);

        setSize(new java.awt.Dimension(797, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //funcionalidade botao salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
       if(adicionaClienteSer() ==true){
            JOptionPane.showMessageDialog(null,"Cadastro Realizado com sucesso");
            txtNome.setText("");
            txtTelefone.setText("");
            txtCelular.setText("");  
            txtDataConsulta.setText("");
            txtEspecialidade.setText("");
        }         
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    //funcionalidade botao pesquisar
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
       String nome = JOptionPane.showInputDialog("Digite o nome do cliente");
        
        exibeCliente(nome);    
         
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    //funcionalidade botao de remover 
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
       
        if(remover(txtNome.getText()) == true){
           JOptionPane.showMessageDialog(null,"cliente Removido Com Sucesso");
            txtNome.setText("");
            txtTelefone.setText("");
            txtCelular.setText("");  
            txtDataConsulta.setText("");
            txtEspecialidade.setText(""); 
            
       }else {
           
          JOptionPane.showMessageDialog(null,"nao foi possivel remover cliente"); 
       }       
        
        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    //funcionalidade editar
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
            java.util.logging.Logger.getLogger(CadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarClientes().setVisible(true);
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
    private javax.swing.JTable tblEspecialidade;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtDataConsulta;
    private javax.swing.JTextField txtEspecialidade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
