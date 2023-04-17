import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public void changeHamletToLeon(){
        Pattern pat = Pattern.compile("Hamlet");
        Matcher mat = pat.matcher(hamletData);
        StringBuffer sb = new StringBuffer();
        String replace = "Leon";
        while (mat.find()) {
            mat.appendReplacement(sb, replace);
        }
        mat.appendTail(sb);
        hamletData = sb.toString();

        pat = Pattern.compile("HAMLET");
        mat = pat.matcher(hamletData);
        sb = new StringBuffer();
        String replace2 = "LEON";
        while (mat.find()) {
            mat.appendReplacement(sb, replace2);
        }
        mat.appendTail(sb);
        hamletData = sb.toString();
    }

    public void changeHoratioToTariq(){
        Pattern pat = Pattern.compile("Horatio");
        Matcher mat = pat.matcher(hamletData);
        StringBuffer sb = new StringBuffer();
        String replace = "Tariq";
        while (mat.find()) {
            mat.appendReplacement(sb, replace);
        }
        mat.appendTail(sb);
        hamletData = sb.toString();

        pat = Pattern.compile("HORRATIO");
        mat = pat.matcher(hamletData);
        sb = new StringBuffer();
        String replace2 = "TARIQ";
        while (mat.find()) {
            mat.appendReplacement(sb, replace2);
        }
        mat.appendTail(sb);
        hamletData = sb.toString();
    }
    public int findHamlet(){
        Pattern pat = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(hamletData);
        return (int) mat.results().count();
    }
    public int findHoratio(){
        Pattern pat = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(hamletData);
        return (int) mat.results().count();
    }



}
