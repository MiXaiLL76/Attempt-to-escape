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
                System.out.println("    "+line);
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

        String[][] new_castle = new String[m][n];
        
        for(int i=0;i<m;i++){
            for(int w=0;w<n;w++){
                new_castle[i][w] = String.valueOf(castle.get(i).replace("0","#").replace("1","?").charAt(w));
            }            
        }
        new_castle[m-1][0] = "0";//Prisoner add  
        new_castle[0][n-1] = "E";//Exit add
        int next = 0;
        while(next < n*m)
        {            
            int chard = 0;
            for(int i=0;i<m;i++){
                for(int w=0;w<n;w++){
                    if(new_castle[i][w].charAt(0) == Character.forDigit(next,10)){
                        if(i+1<m && new_castle[i+1][w].charAt(0) == '?'){
                            new_castle[i+1][w] = String.valueOf(next+1);
                        }
                        if(i-1>=0 && new_castle[i-1][w].charAt(0) == '?'){
                            new_castle[i-1][w] = String.valueOf(next+1);
                        }
                        if(w+1<n && new_castle[i][w+1].charAt(0) == '?'){
                            new_castle[i][w+1] = String.valueOf(next+1);
                        }
                        if(w-1>=0 && new_castle[i][w-1].charAt(0) == '?'){
                            new_castle[i][w-1] = String.valueOf(next+1);
                        }
                    }
                    
                    if(new_castle[i][w].charAt(0) == '?')chard+=1;
                    
                }       
            }
            if(chard == 0)break;
            next++;
        }
        
        System.out.println();
        System.out.println(Character.forDigit(next,10));
        System.out.println();
        for(int i=0;i<m;i++){
            for(int w=0;w<n;w++){
                System.out.print(new_castle[i][w]+" ");
            }    
            System.out.println();       
        }
        
        

        /*
                    
            23456
            10305
            01234

            2  3 4  5 -2
            1 -1 5 -1 9
            0 -1 6  7 8
            4 5 6 7 8 9 10 E 
            3 4 5 6 7 8  # ? 
            2 3 # # # 9 10 # 
            1 # 3 4 5 #  9 # 
            0 1 2 # 6 7  8 # 

        */
    }
}