package data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class Writer {
    private static final String path = "files/";

    public static void Write(String file, List<String> stringList){
        try {
            URL resource = Reader.class.getClassLoader().getResource(path + file + ".csv");
            if (resource == null) {
                throw new IllegalArgumentException("file not found!");
            }
            File tableFile = new File(resource.toURI());
            FileWriter tableWriter = new FileWriter(tableFile, false);
            for (String s : stringList) {
                tableWriter.write(s + "\n");
            }
            tableWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
