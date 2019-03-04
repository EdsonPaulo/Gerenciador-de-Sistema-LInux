/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisualShell;

import VisualShell.*;
import static VisualShell.MetodosEspeciais.i;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edson Gregório
 */
public class frmTask extends javax.swing.JFrame
{

    private DefaultListModel lista = new DefaultListModel();
    private PersonalShell shell = new PersonalShell();
    private final String procSistema = "ps -aux | sort -r -n --key=4 | awk ' $4 > 2 { print $1}'";
    private final String procUsuarios = "ps -u name,pid,%mem,user,nice";
    private List<String> pid_PU, pid_PS, comm, ni, cpu, mem, user;

    //ps -eo pid,comm,ni,%cpu,%mem,user| sort -r -n --key=4 | awk ' $5 > 0.0'
    //ps -eo fname,pid,%mem,user,nice (listar processos)
    //renice -20 PID (aumentar prioridade)   renice +19 PID (diminuir prioridade)
    //Descobrindo que processo está consumindo mais memória: ps aux | sort -k 4 -r | head -n 2 
    //listar processos a  consumirem mais de 5*100 de RAM
    //ps aux|awk '$4 > '5' {print "\n Processo: "$11 " - A consumir: "$4  E}'
    //ps -u | sort -r -n --key=4 | awk ' $4 > 0 { print "User: " $1 " - PID " $2 " - %CPU " $3 " - %MEM " $4 " - PROCESSO " $11}'
    
    public frmTask() throws IOException
    {
        initComponents();

        Thread th;
        th = new Thread(new Runnable()
        { //cria uma thread
            @Override
            public void run()
            {
                while (true) { //roda indefinidamente
                    listUserProcess();
                    listSysProcess();
                    try {
                        Thread.sleep(1000); //espera 1 segundo para fazer a nova evolução
                    }
                    catch (InterruptedException ex) {
                    }
                }
            }
        });
        th.start();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public int parametrizar_MAX(float maxMB)
    {
        return (int) (maxMB / 100);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userProcJTBL = new javax.swing.JTable();
        btnTerminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sysProcJTBL = new javax.swing.JTable();
        btnTerminar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Processos");
        setPreferredSize(new java.awt.Dimension(733, 570));
        setResizable(false);

        jPanel3.setPreferredSize(new java.awt.Dimension(740, 590));

        jPanel1.setMaximumSize(new java.awt.Dimension(707, 557));

        userProcJTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " PID", "NAME", "NI", " CPU%", " MEM%", " USER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userProcJTBL.setRowHeight(20);
        jScrollPane1.setViewportView(userProcJTBL);

        btnTerminar.setText("Terminar Processo");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(538, Short.MAX_VALUE)
                .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTerminar))
        );

        jTabbedPane1.addTab("Processos do Usuário", jPanel1);

        sysProcJTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " PID", "NAME", " CPU%", " MEM%", " USER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sysProcJTBL.setRowHeight(20);
        jScrollPane2.setViewportView(sysProcJTBL);

        btnTerminar1.setText("Terminar Processo");
        btnTerminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTerminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTerminar1))
        );

        jTabbedPane1.addTab("Processos do Sistema", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        int pid = userProcJTBL.getSelectedRow();
        if (pid >= 0) {
            String selectedPID = pid_PU.get(pid);
            shell.executeCommand("kill -9 " + selectedPID);
            listUserProcess();
            listSysProcess();
        }
        else
            JOptionPane.showMessageDialog(null, "Selecione o processo a terminar...");
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnTerminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminar1ActionPerformed
        int pid = sysProcJTBL.getSelectedRow();
        if (pid >= 0) {
            String selectedPID = pid_PS.get(pid);
            shell.executeCommand("kill -9 " + selectedPID);
            listSysProcess();
            listUserProcess();
        }
        else
            JOptionPane.showMessageDialog(null, "Selecione o processo a terminar...");
    }//GEN-LAST:event_btnTerminar1ActionPerformed

    private void listUserProcess()
    {
        DefaultTableModel model = (DefaultTableModel) userProcJTBL.getModel();
        if (pid_PU != null) {
            for (int i = 0; i < model.getRowCount(); i++)
                model.removeRow(i);
            pid_PU.clear();
        }
        pid_PU = shell.executeCommand("ps -eo pid,comm,ni,%cpu,%mem,user| sort -r -n --key=5 | awk ' $5 > 0.0 { print $1}'");
        comm = shell.executeCommand("ps -eo pid,comm,ni,%cpu,%mem,user| sort -r -n --key=5 | awk ' $5 > 0.0 { print $2}'");
        ni = shell.executeCommand("ps -eo pid,comm,ni,%cpu,%mem,user| sort -r -n --key=5 | awk ' $5 > 0.0 { print $3}'");
        cpu = shell.executeCommand("ps -eo pid,comm,ni,%cpu,%mem,user| sort -r -n --key=5 | awk ' $5 > 0.0 { print $4}'");
        mem = shell.executeCommand("ps -eo pid,comm,ni,%cpu,%mem,user| sort -r -n --key=5 | awk ' $5 > 0.0 { print $5}'");
        user = shell.executeCommand("ps -eo pid,comm,ni,%cpu,%mem,user| sort -r -n --key=5 | awk ' $5 > 0.0 { print $6}'");

        for (int i = 0; i < pid_PU.size(); i++)
            model.addRow(new Object[]{pid_PU.get(i), comm.get(i), ni.get(i), cpu.get(i), mem.get(i), user.get(i)});
        userProcJTBL.repaint();
    }

    private void listSysProcess()
    {
        DefaultTableModel model = (DefaultTableModel) sysProcJTBL.getModel();

        if (pid_PS != null) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
                System.out.println(i);
            }
            pid_PS.clear();
        }
        pid_PS = shell.executeCommand("ps -aux | sort -r -n --key=4 | awk ' $4 >= 0.0 { print $2}'");
        comm = shell.executeCommand("ps -aux | sort -r -n --key=4 | awk ' $4 >= 0.0 { print $11}'");
        cpu = shell.executeCommand("ps -aux | sort -r -n --key=4 | awk ' $4 >= 0.0 { print $3}'");
        mem = shell.executeCommand("ps -aux | sort -r -n --key=4 | awk ' $4 >= 0.0 { print $4}'");
        user = shell.executeCommand("ps -aux | sort -r -n --key=4 | awk ' $4 >= 0.0 { print $1}'");

        for (int i = 0; i < pid_PS.size(); i++)
            model.addRow(new Object[]{pid_PS.get(i), comm.get(i), cpu.get(i), mem.get(i), user.get(i)});
        sysProcJTBL.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton btnTerminar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable sysProcJTBL;
    private javax.swing.JTable userProcJTBL;
    // End of variables declaration//GEN-END:variables

}
