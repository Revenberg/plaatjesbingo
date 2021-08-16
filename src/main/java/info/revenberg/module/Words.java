package info.revenberg.module;

import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Words {

    private static ArrayList<String> list = null;
    private static String fileName = "bingo.txt";

    public static ArrayList<String> getList() {
        if (Words.list == null) {
            load();
        }
        return Words.list;
    }

    public static void load() {
        Words.list = new ArrayList<String>();

        FileInputStream fstream;
        try {
            fstream = new FileInputStream(Words.fileName);

            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                Words.list.add(strLine);
            }

            fstream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.shuffle(Words.list);
    }
}
