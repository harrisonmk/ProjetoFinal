
package visao;

import java.awt.Toolkit;


public class Principal extends javax.swing.JFrame {

   
    public Principal() {
        initComponents();
        mudaIcone();
    }

    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuDisciplinas = new javax.swing.JMenuItem();
        menuLivros = new javax.swing.JMenuItem();
        menuPets = new javax.swing.JMenuItem();
        menuBolos = new javax.swing.JMenuItem();
        menuNoticias = new javax.swing.JMenuItem();
        menuCarros = new javax.swing.JMenuItem();
        menuCelulares = new javax.swing.JMenuItem();
        menuContatos = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenuItem();
        menuClienteOficina = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema");
        setResizable(false);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cashier2_116284.png"))); // NOI18N
        jMenu1.setText("Cadastrar");

        menuDisciplinas.setText("Disciplinas");
        menuDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDisciplinasActionPerformed(evt);
            }
        });
        jMenu1.add(menuDisciplinas);

        menuLivros.setText("Livros");
        menuLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLivrosActionPerformed(evt);
            }
        });
        jMenu1.add(menuLivros);

        menuPets.setText("Pets");
        menuPets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPetsActionPerformed(evt);
            }
        });
        jMenu1.add(menuPets);

        menuBolos.setText("Bolos");
        menuBolos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBolosActionPerformed(evt);
            }
        });
        jMenu1.add(menuBolos);

        menuNoticias.setText("Noticias");
        menuNoticias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNoticiasActionPerformed(evt);
            }
        });
        jMenu1.add(menuNoticias);

        menuCarros.setText("Carros");
        menuCarros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCarrosActionPerformed(evt);
            }
        });
        jMenu1.add(menuCarros);

        menuCelulares.setText("Celulares");
        menuCelulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCelularesActionPerformed(evt);
            }
        });
        jMenu1.add(menuCelulares);

        menuContatos.setText("Contatos");
        menuContatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuContatosActionPerformed(evt);
            }
        });
        jMenu1.add(menuContatos);

        menuClientes.setText("Clientes");
        menuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesActionPerformed(evt);
            }
        });
        jMenu1.add(menuClientes);

        menuClienteOficina.setText("Clientes Oficina");
        menuClienteOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClienteOficinaActionPerformed(evt);
            }
        });
        jMenu1.add(menuClienteOficina);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //chama a tela de disciplinas
    private void menuDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDisciplinasActionPerformed
       
        CadastroDisciplinas cadastro = new CadastroDisciplinas();
        cadastro.setVisible(true);
        
        
    }//GEN-LAST:event_menuDisciplinasActionPerformed

    //chama a tela de cadastro de livros
    private void menuLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLivrosActionPerformed
       
        CadastroLivros cadastro = new CadastroLivros();
        cadastro.setVisible(true);
        
        
    }//GEN-LAST:event_menuLivrosActionPerformed

    //chama a tela de cadastro de pets
    private void menuPetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPetsActionPerformed
       
       CadastroPets pet = new CadastroPets(); 
       pet.setVisible(true);
        
    }//GEN-LAST:event_menuPetsActionPerformed

    //chama a tela de cadastro de carros
    private void menuCarrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCarrosActionPerformed
        
        CadastroCarros carros = new CadastroCarros();
        
        carros.setVisible(true);
        
        
    }//GEN-LAST:event_menuCarrosActionPerformed

    //chama a tela de cadastro de bolos
    private void menuBolosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBolosActionPerformed
        
       CadastroBolos bolo = new CadastroBolos();
       bolo.setVisible(true);
        
    }//GEN-LAST:event_menuBolosActionPerformed

    //chama a tela de cadastro de noticias
    private void menuNoticiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNoticiasActionPerformed
        
       CadastroNoticia noticia = new CadastroNoticia();
       noticia.setVisible(true);
        
    }//GEN-LAST:event_menuNoticiasActionPerformed

    //chama a tela de cadastro de celulares
    private void menuCelularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCelularesActionPerformed
       
     CadastroCelulares celular = new CadastroCelulares();
     celular.setVisible(true);
        
    }//GEN-LAST:event_menuCelularesActionPerformed

    //chama a tela de cadastro de contatos
    private void menuContatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuContatosActionPerformed
       
       CadastroContatos contatos = new CadastroContatos(); 
        contatos.setVisible(true);
        
    }//GEN-LAST:event_menuContatosActionPerformed

    //chama a tela de cadastro de clientes
    private void menuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesActionPerformed
        
       CadastrarClientes clientes = new  CadastrarClientes();
        clientes.setVisible(true);
    }//GEN-LAST:event_menuClientesActionPerformed

    //chama a tela de cadastro de clientes de oficina
    private void menuClienteOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClienteOficinaActionPerformed
       
       CadastroClientesOficina cliente = new CadastroClientesOficina();  
        cliente.setVisible(true);
        
    }//GEN-LAST:event_menuClienteOficinaActionPerformed

   
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    /**
     * metodo para trocar o icone da JFrame
     */
    private void mudaIcone() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/universidade.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuBolos;
    private javax.swing.JMenuItem menuCarros;
    private javax.swing.JMenuItem menuCelulares;
    private javax.swing.JMenuItem menuClienteOficina;
    private javax.swing.JMenuItem menuClientes;
    private javax.swing.JMenuItem menuContatos;
    private javax.swing.JMenuItem menuDisciplinas;
    private javax.swing.JMenuItem menuLivros;
    private javax.swing.JMenuItem menuNoticias;
    private javax.swing.JMenuItem menuPets;
    // End of variables declaration//GEN-END:variables
}
