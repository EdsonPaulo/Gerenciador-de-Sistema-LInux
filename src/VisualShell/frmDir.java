/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisualShell;

import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Edson Gregório
 */
public class frmDir extends javax.swing.JFrame
{

    private final DefaultListModel lista = new DefaultListModel();
    PersonalShell shell = new PersonalShell();
    final static String FILE_EXTENT = "data/extentions.dat";
    final static String BLOQUEAR = " chattr +i ";
    final static String DESBLOQUEAR = " chattr -i ";
    final static String LSATTR = "lsattr -l ";
    String arquivosSuspeitos = "";
    Thread th;
    boolean bloqueado;
    Path path;

    public frmDir() throws IOException
    {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        carregarExt();
    }

    private void carregarExt()
    {
        try {
            List<String> extensoes = MetodosEspeciais.lerFicheiro_toList(FILE_EXTENT);
            extJC.removeAllItems();
            if (extensoes != null)
                for (String extensao : extensoes)
                    extJC.addItem(extensao);
        }
        catch (IOException ex) {
        }
    }

    private void bloq(String operacao) throws IOException
    {
        if (path != null) {
            String out = shell.executeCommandB("sh data/bloquear " + operacao + " " + path.toString() + " " + frmSplash.PASSWORD);
            JOptionPane.showMessageDialog(null, "" + out.replace(path.toString(), path.getFileName().toString()));
        }
        else
            JOptionPane.showMessageDialog(null, "Selecione um diretório ou ficheiro!");
    }

    void verificarBloqueio()
    {
        if (path != null) {
            //comando para listar os ficheiros com determinado nome e com atributo "Immutable" dentro da pasta onde esta contido 
            String output = shell.executeCommandB(LSATTR + path.toString().replace(path.getFileName().toString(), "") + " |grep 'Immutable'|grep " + "'" + path.getFileName().toString() + "'");
            if (output.equals("")) { //retorna vazio (nao encontrado)
                bloqueado = false;
                imgState.setIcon(new ImageIcon("src/VisualShell/images/imgUnlock.png"));
                btnBloq.setText("Bloquear");
            }
            else {//ou encontra um ficheiro Imutable com o nome
                bloqueado = true;
                imgState.setIcon(new ImageIcon("src/VisualShell/images/imgLock.png"));
                btnBloq.setText("Desbloquear");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        imgState = new javax.swing.JLabel();
        btnDir = new javax.swing.JButton();
        btnArq = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBloq = new javax.swing.JButton();
        txtPath = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        extJC = new javax.swing.JComboBox();
        extJT = new javax.swing.JTextField();
        registarExtJB = new javax.swing.JButton();
        monitorarJB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSuspeitos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 153));
        jTabbedPane1.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        imgState.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        imgState.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/imgUnlock.png"))); // NOI18N

        btnDir.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnDir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/imgDir.png"))); // NOI18N
        btnDir.setText("Diretório");
        btnDir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDirActionPerformed(evt);
            }
        });

        btnArq.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnArq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VisualShell/images/imgFile.png"))); // NOI18N
        btnArq.setText("Arquivo");
        btnArq.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnArqActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Diretório/Arquivo:");

        btnBloq.setText("Bloquear");
        btnBloq.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBloqActionPerformed(evt);
            }
        });

        txtPath.setEditable(false);
        txtPath.setMinimumSize(new java.awt.Dimension(10, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158)
                        .addComponent(imgState, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnArq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnBloq, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnDir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnArq, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imgState, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBloq)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modificar Acesso", jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jLabel3.setText("Extensões Registadas:");

        registarExtJB.setText("Registar Extensão");
        registarExtJB.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                registarExtJBActionPerformed(evt);
            }
        });

        monitorarJB.setText("Ativar Monitoramento de Arquivos");
        monitorarJB.setToolTipText("Ativa alerta de arquivos suspeitos");
        monitorarJB.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                monitorarJBActionPerformed(evt);
            }
        });

        txtSuspeitos.setColumns(20);
        txtSuspeitos.setRows(5);
        jScrollPane1.setViewportView(txtSuspeitos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(extJT, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(registarExtJB))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(extJC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monitorarJB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(monitorarJB)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extJC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(extJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registarExtJB))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Arquivos Suspeitos", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Modificar Acesso");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registarExtJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registarExtJBActionPerformed
        if (!"".equals(extJT.getText())) {
            try {
                MetodosEspeciais.gravarFicheiro(FILE_EXTENT, "." + extJT.getText());
                JOptionPane.showMessageDialog(null, "Extensão cadastrada com sucesso!");
                extJT.setText("");
            }
            catch (IOException ex) {
            }
            carregarExt();
        }
    }//GEN-LAST:event_registarExtJBActionPerformed

    /* for (int i = 0; i < 3; i++) {
     Toolkit.getDefaultToolkit().beep();
     try { sleep(1000); } 
     catch (InterruptedException ex) {         }
     }
     */
    void monitorarArquivos() throws IOException
    {
        final List<String> extensoes = MetodosEspeciais.lerFicheiro_toList(FILE_EXTENT);
        th = new Thread(new Runnable()
        { //cria uma thread
            @Override
            public void run()
            {
                while (true) {
                    if (extensoes != null)
                        for (final String extensao : extensoes) {//roda indefinidamente
                            arquivosSuspeitos = shell.executeCommandB("echo " + frmSplash.PASSWORD + " | sudo -S -u root -s find / -iname '*" + extensao + "'");
                            if (!"".equals(arquivosSuspeitos) && arquivosSuspeitos != null)
                                if (!txtSuspeitos.getText().contains(arquivosSuspeitos)) {
                                    int ocorrencia = arquivosSuspeitos.indexOf(extensao, 0) + extensao.length();
                                    String supeitos = arquivosSuspeitos.substring(0, ocorrencia);
                                    supeitos += "\n" + arquivosSuspeitos.substring(ocorrencia);
                                    txtSuspeitos.setText(txtSuspeitos.getText() + "\n" + supeitos);
                                    for (int i = 0; i < 6; i++)
                                        Toolkit.getDefaultToolkit().beep();
                                    JOptionPane.showMessageDialog(null, "Os seguintes arquivos são proibidos: \n" + supeitos, "Arquivos Suspeitos Encontrados", JOptionPane.WARNING_MESSAGE);
                                }
                        }
                    else {
                        JOptionPane.showMessageDialog(null, "Cadastre algumas extensoes!");
                        th.stop();
                        break;
                    }
                    try {
                        Thread.sleep(2000); //espera 1 segundo para fazer a nova evolução
                    }
                    catch (InterruptedException ex) {
                    }
                }
            }
        });
        th.start();
    }

    private void monitorarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitorarJBActionPerformed

        if (monitorarJB.getText().equals("Ativar Monitoramento de Arquivos"))
            try {
                monitorarJB.setText("Desativar Monitoramento de Arquivos");
                monitorarArquivos();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        else {
            monitorarJB.setText("Ativar Monitoramento de Arquivos");
            th.stop();
        }
    }//GEN-LAST:event_monitorarJBActionPerformed

    private void btnBloqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloqActionPerformed
        if (!txtPath.equals(""))
            if (bloqueado)
                try {
                    bloq("-l");
                    bloqueado = false;
                    btnBloq.setText("Bloquear");
                    txtPath.setText("");
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            else
                try {
                    bloq("-b");
                    bloqueado = true;
                    btnBloq.setText("Bloquear");
                    txtPath.setText("");

                }
                catch (IOException ex) {
                    Logger.getLogger(frmDir.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
        else
            JOptionPane.showMessageDialog(null, "Selecione um diretório/arquivo!");
    }//GEN-LAST:event_btnBloqActionPerformed

    private void selectFile(int fileType)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(fileType);
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().toPath();
            txtPath.setText(path.toString());
            verificarBloqueio();
        }
    }

    private void btnArqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArqActionPerformed
        selectFile(JFileChooser.FILES_ONLY);
    }//GEN-LAST:event_btnArqActionPerformed

    private void btnDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirActionPerformed
        selectFile(JFileChooser.DIRECTORIES_ONLY);
    }//GEN-LAST:event_btnDirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArq;
    private javax.swing.JButton btnBloq;
    private javax.swing.JButton btnDir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox extJC;
    private javax.swing.JTextField extJT;
    private javax.swing.JLabel imgState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton monitorarJB;
    private javax.swing.JButton registarExtJB;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextArea txtSuspeitos;
    // End of variables declaration//GEN-END:variables
}
