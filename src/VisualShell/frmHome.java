/**
 *
 * @author Edson Gregório
 */
package VisualShell;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;

public class frmHome extends JFrame
{

    public frmHome()
    {
        super("Gerenciador de Sistema (Linux)");
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnTask = new javax.swing.JButton();
        btnHard = new javax.swing.JButton();
        btnCMD = new javax.swing.JButton();
        btnNet = new javax.swing.JButton();
        btnDir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnUsers = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor de Sistemas Linux - v0.1 (alpha)");
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(null);

        btnTask.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        btnTask.setForeground(new java.awt.Color(1, 1, 1));
        btnTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/imgTask.png"))); // NOI18N
        btnTask.setText(" Processos");
        btnTask.setToolTipText("Gerenciar Processos e Programas");
        btnTask.setAlignmentY(0.0F);
        btnTask.setBorder(null);
        btnTask.setFocusable(false);
        btnTask.setIconTextGap(5);
        btnTask.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTaskActionPerformed(evt);
            }
        });
        getContentPane().add(btnTask);
        btnTask.setBounds(70, 200, 150, 60);

        btnHard.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        btnHard.setForeground(new java.awt.Color(1, 1, 1));
        btnHard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/imgHardware.png"))); // NOI18N
        btnHard.setText(" Hardware   ");
        btnHard.setToolTipText("Informações do Hardware");
        btnHard.setAlignmentY(0.0F);
        btnHard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnHard.setFocusable(false);
        btnHard.setIconTextGap(5);
        btnHard.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHardActionPerformed(evt);
            }
        });
        getContentPane().add(btnHard);
        btnHard.setBounds(600, 200, 150, 60);

        btnCMD.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        btnCMD.setForeground(new java.awt.Color(1, 1, 1));
        btnCMD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/imgTerminal.png"))); // NOI18N
        btnCMD.setText(" Terminal  ");
        btnCMD.setToolTipText("Prompt de Comandos Shell");
        btnCMD.setActionCommand("");
        btnCMD.setAlignmentY(0.0F);
        btnCMD.setBorder(null);
        btnCMD.setFocusable(false);
        btnCMD.setIconTextGap(5);
        btnCMD.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCMDActionPerformed(evt);
            }
        });
        getContentPane().add(btnCMD);
        btnCMD.setBounds(340, 330, 150, 60);

        btnNet.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        btnNet.setForeground(new java.awt.Color(1, 1, 1));
        btnNet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/imgNetwork.png"))); // NOI18N
        btnNet.setText(" Rede");
        btnNet.setToolTipText("Gerenciar Redes e Usuários");
        btnNet.setActionCommand("");
        btnNet.setAlignmentY(0.0F);
        btnNet.setBorder(null);
        btnNet.setFocusable(false);
        btnNet.setIconTextGap(5);
        btnNet.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnNetActionPerformed(evt);
            }
        });
        getContentPane().add(btnNet);
        btnNet.setBounds(600, 330, 150, 60);

        btnDir.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        btnDir.setForeground(new java.awt.Color(1, 1, 1));
        btnDir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/imgDirTree.png"))); // NOI18N
        btnDir.setText("Diretórios");
        btnDir.setToolTipText("Gerenciar diretórios e arquivos");
        btnDir.setActionCommand("");
        btnDir.setAlignmentY(0.0F);
        btnDir.setBorder(null);
        btnDir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDir.setFocusable(false);
        btnDir.setIconTextGap(5);
        btnDir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDirActionPerformed(evt);
            }
        });
        getContentPane().add(btnDir);
        btnDir.setBounds(70, 330, 150, 60);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(1, 1, 1));
        jPanel1.setFont(new java.awt.Font("Pagul", 1, 18)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dyuthi", 1, 48)); // NOI18N
        jLabel1.setText("JEMMEL v1.0");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(271, 271, 271))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 50, 830, 70);

        btnUsers.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        btnUsers.setForeground(new java.awt.Color(1, 1, 1));
        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/imgUsers.png"))); // NOI18N
        btnUsers.setText("Utilizadores");
        btnUsers.setToolTipText("Prompt de Comandos Shell");
        btnUsers.setActionCommand("");
        btnUsers.setAlignmentY(0.0F);
        btnUsers.setBorder(null);
        btnUsers.setFocusable(false);
        btnUsers.setIconTextGap(5);
        btnUsers.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUsersActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsers);
        btnUsers.setBounds(340, 200, 150, 60);

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/background.png"))); // NOI18N
        background.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(background);
        background.setBounds(0, 0, 870, 510);

        jMenu1.setText("Ficheiro");

        menuSair.setForeground(new java.awt.Color(1, 1, 1));
        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/imgExit.png"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuSairActionPerformed(evt);
            }
        });
        jMenu1.add(menuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        menuSobre.setForeground(new java.awt.Color(1, 1, 1));
        menuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/imgSobre.png"))); // NOI18N
        menuSobre.setText("Sobre");
        jMenu2.add(menuSobre);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 830, 543);
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnCMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCMDActionPerformed
        new frmTerminal().setVisible(true);
    }//GEN-LAST:event_btnCMDActionPerformed

    
    private void btnNetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNetActionPerformed
        new frmNetwork().setVisible(true);
    }//GEN-LAST:event_btnNetActionPerformed

    
    private void btnDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirActionPerformed
        try {
            new frmDir().setVisible(true);
        }
        catch (IOException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDirActionPerformed

    
    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Tem certeza_", "Saindo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    
    private void btnTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaskActionPerformed
        try {
            new frmTask().setVisible(true);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnTaskActionPerformed

    
    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        new frmUsers().setVisible(true);
    }//GEN-LAST:event_btnUsersActionPerformed

    
    private void btnHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHardActionPerformed
        new frmHardware().setVisible(true);
    }//GEN-LAST:event_btnHardActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnCMD;
    private javax.swing.JButton btnDir;
    private javax.swing.JButton btnHard;
    private javax.swing.JButton btnNet;
    private javax.swing.JButton btnTask;
    private javax.swing.JButton btnUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSobre;
    // End of variables declaration//GEN-END:variables

}
