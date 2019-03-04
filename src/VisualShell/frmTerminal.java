/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisualShell;

import java.awt.Color;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Edson Gregório
 */
public class frmTerminal extends javax.swing.JFrame
{

    PersonalShell shell = new PersonalShell();

    public frmTerminal()
    {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void exec()
    {
        String command = txtInput.getText().trim();
        if (command == null || command.equals(""))
            JOptionPane.showMessageDialog(this, "Escreva um comando!");
        else {
            Map<String, String> result = TerminalEmulator.exec(command);

            if (result.get("error") != null && !result.get("error").equals(""))
                writeOutput(result.get("error"), true); //se a chave error tiver um valor, vai escrever o erro na saida
            else if (result.get("input") != null && !result.get("input").equals(""))
                writeOutput(result.get("input"), false); //se a chave error tiver um resultado aceite, escreve na saida
        }
    }

    private void clearOutput()
    {
        txtOutput.setText("");
    } //limpa a saida 

    private void paintOutput(boolean error)
    { //se existir erro, muda a font da saida para Red
        if (error)
            txtOutput.setForeground(Color.RED);
        else
            txtOutput.setForeground(Color.GREEN);
    }

    private void writeOutput(String text, boolean error)
    {
        clearOutput();
        paintOutput(error);
        txtOutput.setText(text);
    }

   // "cat password.txt | sudo -S dmidecode -t 1"

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        btnHistory = new javax.swing.JButton();
        txtInput = new javax.swing.JTextField();
        btnExec = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Terminal Emulator");
        setResizable(false);

        txtOutput.setEditable(false);
        txtOutput.setBackground(new java.awt.Color(21, 21, 21));
        txtOutput.setColumns(20);
        txtOutput.setFont(new java.awt.Font("AnjaliOldLipi", 0, 14)); // NOI18N
        txtOutput.setForeground(new java.awt.Color(4, 177, 82));
        txtOutput.setRows(5);
        txtOutput.setText(" ");
        jScrollPane1.setViewportView(txtOutput);

        btnHistory.setText("Histórico");
        btnHistory.setToolTipText("");
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        txtInput.setBackground(new java.awt.Color(241, 239, 239));
        txtInput.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        txtInput.setForeground(new java.awt.Color(1, 1, 1));
        txtInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtInputKeyPressed(evt);
            }
        });

        btnExec.setText("Executar Comando");
        btnExec.setToolTipText("");
        btnExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtInput)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecActionPerformed
        String output = "";
        int i = 0;
        for (String saida : shell.executeCommand(txtInput.getText())) {
            if (i > 5)
                output += "\n" + saida.replaceAll("Manufacturer", "Fabricante");
            i++;
        }
        txtOutput.setText(output);
    }//GEN-LAST:event_btnExecActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        DialogHistory dHistory = new DialogHistory(this, true);
        dHistory.show();
        String command = dHistory.getSelectedCommand(); //recebe o item selecionado no dialog history
        if (command != null)
            txtInput.setText(command);
    }//GEN-LAST:event_btnHistoryActionPerformed
    private void txtInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) //se apertar enter vai executar          
        
            exec();
    }//GEN-LAST:event_txtInputKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExec;
    private javax.swing.JButton btnHistory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables

}
