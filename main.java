//import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

class Attempt_to_escape { 

    
    public static void main(String[] args){
        System.out.println("Attempt to escape");
        System.out.println("Input: ");
        List<String> castle = new ArrayList<String>();
        String file = "input.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
            for(String line: lines){
                System.out.println(line);
                castle.add(line);
            }
        }catch(IOException e){}
        String[] m_n = castle.get(0).split(" ");castle.remove(0);
        int m = Integer.parseInt(m_n[0]);//row
        int n = Integer.parseInt(m_n[1]);//coll

        int[] prisoner = {m,0};
        int[] exit = {0,n};
        System.out.println("Prisoner: "+prisoner[0]+"x"+prisoner[1]);
        System.out.println("Exit: "+exit[0]+"x"+exit[1]);

        /*
                    
            23456
            10305
            01234

            2  3 4  5 -2
            1 -1 5 -1 9
            0 -1 6  7 8
        */
    }
}