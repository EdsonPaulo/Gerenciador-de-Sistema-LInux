package VisualShell;

/**
 *
 * @author Edson Gregório
 *
 */
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonalShell
{

    private static final Logger log = Logger.getLogger(PersonalShell.class.getName());
    List<String> results;
    ArrayList<String> comandos;

    /*  Método: executeCommand
     Função: Executa diretamente no sistema um comando (string) passado como argumento.
     Devolve: a lista de resultados da execucao do comando (saida)
     */
    public List<String> executeCommand(String comando)
    {
        try {
            results = new ArrayList<>();
            comandos = new ArrayList<>();
            comandos.add("/bin/bash");
            comandos.add("-c");
            comandos.add(comando);
            //comandos.add("2>&1");
            BufferedReader br = null;

            try {
                final ProcessBuilder p = new ProcessBuilder(comandos);
                final Process process = p.start();
                final InputStream is = process.getInputStream();
                final InputStreamReader isr = new InputStreamReader(is);
                br = new BufferedReader(isr);

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("Retorno do comando = [" + line + "]");
                    results.add(line);
                }
                br.close();
                is.close();
                isr.close();

            }
            catch (IOException ioe) {
                log.severe("Erro ao executar comando shell" + ioe.getMessage());
                throw ioe;
            }
            finally {
                secureClose(br);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public String executeCommandB(String comando)
    {
        String line, output = "";
        try {
            comandos = new ArrayList<>();
            comandos.add("/bin/bash");
            comandos.add("-c");
            comandos.add(comando);
            BufferedReader br = null;

            try {
                final ProcessBuilder p = new ProcessBuilder(comandos);
                final Process process = p.start();
                final InputStream is = process.getInputStream();
                final InputStreamReader isr = new InputStreamReader(is);
                br = new BufferedReader(isr);

                while ((line = br.readLine()) != null) {
                    System.out.println("Retorno do comando = [" + line + "]");
                    output += line;
                }
            }
            catch (IOException ioe) {
                log.log(Level.SEVERE, "Erro ao executar comando shell{0}", ioe.getMessage());
                throw ioe;
            }
            finally {
                secureClose(br);
            }
        }
        catch (IOException e) {
        }
        return output;
    }

    private void secureClose(final Closeable resource)
    {
        try {
            if (resource != null)
                resource.close();
        }
        catch (IOException ex) {
            log.severe("Erro = " + ex.getMessage());
        }
    }
}
