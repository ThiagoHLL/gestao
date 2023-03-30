/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.appcontrole.telas;

import java.sql.*;
import br.com.appcontrole.dao.ModuloConexao;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pstm = null;
    ResultSet rset = null;

    /**
     * Aqui começa o desenvolvimento do CRUD - Create, Read, Update, Delete
     */
    //Construtor
    //Classe Principal
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    //CREATE - Adicionar
    public void adicionar() {

        String sql = "Insert into tbusuario(idusuario, nome, telefone, login, senha, acesso) values (?, ?, ?, ?, ?, ?)";

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, txtUsuId.getText());
            pstm.setString(2, txtUsuNome.getText());
            pstm.setString(3, txtUsuTelefone.getText());
            pstm.setString(4, txtUsuLogin.getText());
            pstm.setString(5, txtUsuSenha.getText());

            //Sempre converter itens em strinh (toString);
           pstm.setString(6, cboUsuAcesso.getSelectedItem().toString());
            //boolean adicionado = (true);
            // if (adicionado = true) {
            //Campos obrigatórios
            if (((((txtUsuId.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()) || (txtUsuLogin.getText().isEmpty()) || (txtUsuSenha.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()))))) {
                JOptionPane.showMessageDialog(null, "*Preechimento Obrigatório");
            } else {
                //Faz parte do if acima
                int cadastrado = pstm.executeUpdate();

                if (cadastrado > 0) {
                    //Limpar os campos 
                    txtUsuId.setText(null);
                    txtUsuNome.setText(null);
                    txtUsuTelefone.setText(null);
                    txtUsuLogin.setText(null);
                    txtUsuSenha.setText(null);
                    //cboUsuAcesso.setSelectedItem(null);
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //READ Consultar
    private void consultar() {
        String sql = ("select * from tbusuario where idusuario=?");
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, txtUsuId.getText());
            rset = pstm.executeQuery();

            //Estrutura de decisão
            if (rset.next()) {

                txtUsuNome.setText(rset.getString(2));

                txtUsuTelefone.setText(rset.getString(3));

                txtUsuLogin.setText(rset.getString(4));

                txtUsuSenha.setText(rset.getString(5));

                //Seleciona um item do combobox
                cboUsuAcesso.setSelectedItem(rset.getString(6));

            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado ou não possui cadastro!");

                //Limpar os campos 
                txtUsuNome.setText(null);
                txtUsuTelefone.setText(null);
                txtUsuLogin.setText(null);
                txtUsuSenha.setText(null);
                ///cboUsuAcesso.setSelectedItem(null);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //Updade - Atualizar
    private void alterar() {

        String sql = "update tbusuario set nome=?, telefone=?, login=?, senha=?, acesso=? where idusuario=?";
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, txtUsuNome.getText());
            pstm.setString(2, txtUsuTelefone.getText());
            pstm.setString(3, txtUsuLogin.getText());
            pstm.setString(4, txtUsuSenha.getText());
            pstm.setString(5, cboUsuAcesso.getSelectedItem().toString());
            pstm.setString(6, txtUsuId.getText());
            
            
            if (((((txtUsuId.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()) || (txtUsuLogin.getText().isEmpty()) || (txtUsuSenha.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()))))) {
                JOptionPane.showMessageDialog(null, "*Preechimento Obrigatório");
            } else {
                //Faz parte do if acima
                int cadastrado = pstm.executeUpdate();

                if (cadastrado > 0) {
                    //Limpar os campos 
                    txtUsuId.setText(null);
                    txtUsuNome.setText(null);
                    txtUsuTelefone.setText(null);
                    txtUsuLogin.setText(null);
                    txtUsuSenha.setText(null);

                    //Pode causar problemas a limpesa do combobox
                    //cboUsuAcesso.setSelectedItem(null);
                    JOptionPane.showMessageDialog(null, "Dados de usuário atualizados com sucesso!");
                }

            }
            
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

        }
    }

    
    
     //Delete - Excluir
     private void excluir() {

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o registro?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirma==JOptionPane.YES_OPTION) {
        String sql = "delete from tbusuario where idusuario = ?";
        try {
           pstm= conexao.prepareStatement(sql);
           pstm.setString(1,txtUsuId.getText());
           int excluido = pstm.executeUpdate();
           if(excluido>0) {
                           JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                //Limpar os campos
                txtUsuId.setText(null);
                txtUsuNome.setText(null);
                txtUsuTelefone.setText(null);
                txtUsuLogin.setText(null);
                txtUsuSenha.setText(null);   
           }
           
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
  }
          
    }

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuId = new javax.swing.JTextField();
        txtUsuNome = new javax.swing.JTextField();
        txtUsuLogin = new javax.swing.JTextField();
        txtUsuSenha = new javax.swing.JTextField();
        btnUsuAdicionar = new javax.swing.JButton();
        btnUsuProcurar = new javax.swing.JButton();
        btnUsuAtualizar = new javax.swing.JButton();
        btnUsuExcluir = new javax.swing.JButton();
        txtUsuTelefone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboUsuAcesso = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(662, 478));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("* ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("* Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("* Login");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("* Senha");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("* Acesso");

        txtUsuId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuIdActionPerformed(evt);
            }
        });

        btnUsuAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/appcontrole/icones/adicionar.png"))); // NOI18N
        btnUsuAdicionar.setToolTipText("Adicionar");
        btnUsuAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUsuAdicionar.setPreferredSize(new java.awt.Dimension(80, 75));
        btnUsuAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuAdicionarActionPerformed(evt);
            }
        });

        btnUsuProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/appcontrole/icones/procurar.png"))); // NOI18N
        btnUsuProcurar.setToolTipText("Procurar");
        btnUsuProcurar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnUsuProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuProcurarActionPerformed(evt);
            }
        });

        btnUsuAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/appcontrole/icones/atualizar.png"))); // NOI18N
        btnUsuAtualizar.setToolTipText("Atualizar");
        btnUsuAtualizar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnUsuAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuAtualizarActionPerformed(evt);
            }
        });

        btnUsuExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/appcontrole/icones/excluir.png"))); // NOI18N
        btnUsuExcluir.setToolTipText("Excluir");
        btnUsuExcluir.setPreferredSize(new java.awt.Dimension(50, 50));
        btnUsuExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuExcluirActionPerformed(evt);
            }
        });

        txtUsuTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuTelefoneActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("* Telefone");

        cboUsuAcesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "usuario" }));
        cboUsuAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUsuAcessoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("* Obrigatório");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnUsuAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                                        .addComponent(btnUsuProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(24, 24, 24))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txtUsuSenha)
                                                        .addGap(61, 61, 61)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(12, 12, 12)
                                                        .addComponent(btnUsuAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(34, 34, 34)
                                                        .addComponent(btnUsuExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel5))
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtUsuTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(11, 11, 11))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(69, 69, 69))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                                                .addComponent(jLabel6))
                                            .addComponent(txtUsuNome, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(cboUsuAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(43, 43, 43))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnUsuAdicionar, btnUsuAtualizar, btnUsuExcluir, btnUsuProcurar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboUsuAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnUsuAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnUsuAdicionar, btnUsuAtualizar, btnUsuExcluir, btnUsuProcurar});

        setBounds(0, 0, 662, 478);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuIdActionPerformed

    private void btnUsuProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuProcurarActionPerformed
        // chamar o método consultar

        consultar();
    }//GEN-LAST:event_btnUsuProcurarActionPerformed

    private void txtUsuTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuTelefoneActionPerformed

    private void btnUsuAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuAdicionarActionPerformed
        // TODO add your handling code here:
        // chamar o método adicionar
        adicionar();
        
    }//GEN-LAST:event_btnUsuAdicionarActionPerformed

    private void btnUsuAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuAtualizarActionPerformed
        // TODO add your handling code here:
        //Chamar o método atualizar
        alterar();
    }//GEN-LAST:event_btnUsuAtualizarActionPerformed

    private void btnUsuExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuExcluirActionPerformed
        // TODO add your handling code here:
        //chamar o método excluir
        excluir();
        
    }//GEN-LAST:event_btnUsuExcluirActionPerformed

    private void cboUsuAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUsuAcessoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboUsuAcessoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuAdicionar;
    private javax.swing.JButton btnUsuAtualizar;
    private javax.swing.JButton btnUsuExcluir;
    private javax.swing.JButton btnUsuProcurar;
    private javax.swing.JComboBox<String> cboUsuAcesso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtUsuId;
    private javax.swing.JTextField txtUsuLogin;
    private javax.swing.JTextField txtUsuNome;
    private javax.swing.JTextField txtUsuSenha;
    private javax.swing.JTextField txtUsuTelefone;
    // End of variables declaration//GEN-END:variables

    private Object getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
