/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisualShell;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author edsonpaulo24
 */
public class MetodosEspeciais
{

    static RandomAccessFile Ficheiro;
    static int i = 0;

    static void realTime()
    {
        Thread th;
        th = new Thread(new Runnable()
        { //cria uma thread
            @Override
            public void run()
            {
                while (true) { //roda indefinidamente
                    System.out.println(i++);
                    try {
                        Thread.sleep(1000); //espera 1 segundo para fazer a nova evolução
                    }
                    catch (InterruptedException ex) {
                    }
                }
            }
        });
        th.start();
    }

    static void gravarFicheiro(String nomeFicheiro, String texto) throws IOException
    {
        try {
            Ficheiro = new RandomAccessFile(nomeFicheiro, "rw");
            if (Ficheiro.length() > 0) {
                Ficheiro.seek(Ficheiro.length());
                Ficheiro.writeBytes("\n");
            }
            Ficheiro.writeBytes(texto);
            Ficheiro.close();
        }
        catch (IOException e) {
        }
    }

    static String lerFicheiro_toString(String nomeFicheiro) throws IOException
    {
        File file = new File(nomeFicheiro);
        if (file.exists()) {
            FileReader leitor_ficheiro = new FileReader(file);
            Scanner leitor = new Scanner(leitor_ficheiro);
            if (leitor.hasNext())
                return leitor.nextLine();
            else
                return null;
        }
        else
            return null;
    }

    static List<String> lerFicheiro_toList(String nomeFicheiro) throws IOException
    {
        List<String> resultados = new ArrayList<>();
        File file = new File(nomeFicheiro);
        if (file.exists()) {
            FileReader leitor_ficheiro = new FileReader(file);
            Scanner leitor = new Scanner(leitor_ficheiro);
            while (leitor.hasNext())
                resultados.add(leitor.nextLine());
        }
        else
            return null;
        return resultados;
    }
}
