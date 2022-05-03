package dataFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public static class Reader {
    private static String path = "../../../files/";

    public static List<String> Read(String file){
        List<String> list = new ArrayList<String>();
        try {
            File tableFile = new File(path + file + ".csv");
            Scanner myReader = new Scanner(tableFile);
            while (myReader.hasNextLine()) {
                list.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }
}
