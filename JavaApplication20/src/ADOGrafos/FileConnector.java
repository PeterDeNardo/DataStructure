/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADOGrafos;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

/**
 *
 * @author Fofolho
 */
public class FileConnector {
    
    public static String[] reader(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        Stream<String> textStream = buffRead.lines();
        String[] textArray = textStream.toArray(String[]::new);
        buffRead.close();
        return textArray;
    }
    
    public static void writer(String path, String mensage) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        buffWrite.append(mensage + "\n");
        buffWrite.close();
    }

}
