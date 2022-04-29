package dataFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Reader {
    private static String path = "../../../files/";

    public static List<String> read(String file, int amount, int col, int intVal, String stingVal){
        List<String> list = new ArrayList<String>();
        try {
            File tableFile = new File(path + file + ".csv");
            Scanner myReader = new Scanner(tableFile);
            int count = 1;
            while (myReader.hasNextLine() && amount != 0) {
                String data = myReader.nextLine();
                if(intVal > 0){
                    String[] cols = data.split(";");
                    if(Integer.parseInt(cols[col]) == intVal) {
                        list.add(data + ";" + count);
                        amount--;
                    }
                } else if(stingVal != null){
                    String[] cols = data.split(";");
                    if(cols[col].equals(stingVal)){
                        list.add(data);
                        amount--;
                    }
                } else {
                    list.add(data);
                    amount--;
                }
                count++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }
}
