package com.azy.stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IOStreamTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);

            int data;
            while((data =  fileReader.read())!= -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileReader!=null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
