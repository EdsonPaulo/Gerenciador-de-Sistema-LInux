package VisualShell;

/**
 *
 * @author Edson Gregório
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TerminalEmulator
{

    private static final List<String> commandHistory = new ArrayList<>();

    public static Map<String, String> exec(String command)
    {
        /*
         O exec() retorna um Map<String,String> contendo sempre a chave “input” e a chave “error”.
         A chave “input” contém o conteúdo retornado quando a execução for bem-sucedida,
         enquanto a chave “error” retorna o conteúdo de erro, quando houver.
         */
        ArrayList<String> comandos = new ArrayList<>();
        comandos.add("/bin/bash");
        comandos.add("-c");
        comandos.add(command);
        Process proc = null;
        Map<String, String> result = new HashMap<>();
        try {
            final ProcessBuilder p = new ProcessBuilder(comandos);
            proc = p.start();
            result.put("input", inputStreamToString(proc.getInputStream()));
            result.put("error", inputStreamToString(proc.getErrorStream()));
        }
        catch (IOException e) {
            result.put("error", e.getCause().getMessage());
        }
        finally {
            commandHistory.add(command);
        }
        return result;
    }

    private static String inputStreamToString(InputStream isr)
    {
        /* Converte um objeto do tipo InputStream para String. 
         é criado um InputStreamReader e posteriormente um BufferedReader. 
         É com o BufferedReader que fazemos a leitura das linhas através do “readLine()” 
         */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(isr));
            StringBuilder sb = new StringBuilder();
            String s = null;
            while ((s = br.readLine()) != null) {
                sb.append(s).append("\n");
            }
            return sb.toString();
        }
        catch (IOException e) {
            return null;
        }
    }

    public static void clearHistory()
    {
        commandHistory.clear();
    }

    public static List<String> getCommandHistory()
    {
        return commandHistory;
    }
}
