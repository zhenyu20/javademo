package com.azy.leetcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
*
* 测试try with resource语句
* */

public class TryWithResourceTest {
    public void readFile() throws FileNotFoundException {

        try (
                FileReader fr = new FileReader("d:/input.txt");
                BufferedReader br = new BufferedReader(fr)
        ) {
            String s = "";
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                br.close();
//                fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
