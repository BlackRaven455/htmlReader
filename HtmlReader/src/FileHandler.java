import java.io.*;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {
    Path path;
    String fileName = "html.txt";

    public void createFile() {

        path = Path.of("src");
        boolean exists = Files.exists(path);
        path = path.resolve(fileName);
        path = path.toAbsolutePath();
//        System.out.println(path.toString());
        if (!exists) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void writeInFile(HttpURLConnection con) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()));
        int i = br.read();
        while (i != -1) {
            char ch = (char) i;
            bufferedWriter.write(ch);
            i = br.read();
        }
        bufferedWriter.close();
        br.close();


    }
}
