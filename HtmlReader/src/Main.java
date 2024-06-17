import java.io.IOException;
import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FileHandler fh = new FileHandler();
        fh.createFile();
        URLConnection urlConnection = getUrlConnection();
        HttpURLConnection con = null;
        if (urlConnection instanceof HttpURLConnection) {
            con = (HttpURLConnection) urlConnection;
        } else {
            System.out.println("Not a HTTP URL");
        }
        try {
            assert con != null;
            fh.writeInFile(con);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static URLConnection getUrlConnection() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter URL:");
        String uriName = sc.next();
        System.out.println("Getting URLConnection");
        URI uri;
        try {
            uri = new URI(uriName);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        URLConnection urlConnection;
        try {
            urlConnection = uri.toURL().openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return urlConnection;
    }
}


