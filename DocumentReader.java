import java.util.*;
import java.io.*;
public  class DocumentReader {

    public String readFile(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append(" ");
        }

        br.close();
        return sb.toString().toLowerCase();
    }
}