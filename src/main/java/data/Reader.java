package data;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Reader {
    private static final String path = "files/";

    public static List<String> Read(String file){
        List<String> list = new ArrayList<String>();
        try {
            URL resource = Reader.class.getClassLoader().getResource(path + file + ".csv");
            if (resource == null) {
                throw new IllegalArgumentException("file not found!");
            }
            File tableFile = new File(resource.toURI());
            Scanner myReader = new Scanner(tableFile);
            while (myReader.hasNextLine()) {
                list.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }
}
