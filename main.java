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

        int[][] new_castle = new int[m][n];
        int[][] save = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int w=0;w<n;w++){
                new_castle[i][w] = Character.digit(castle.get(i).charAt(w),10);
                save[i][w] = 0;
            }            
        }
        save[m-1][0]=1;

        for(int i=1; i<n; i++)
            if(new_castle[m-1][i]==1)
                save[m-1][i]=save[m-1][i-1];
            else
                save[m-1][i]=0;

        for(int i=m-2; i>=0; i--)
            if(new_castle[i][0]==1)
                save[i][0]=save[i+1][0];
            else
                save[i][0]=0;

        for(int i=m-2; i>=0; i--)
            for(int j=1; j<n; j++)
                if(new_castle[i][j]==1)
                    save[i][j]=save[i+1][j]+save[i][j-1];
                else
                    save[i][j]=0;

        System.out.println("Output: ");
        System.out.print("    ");
        if(save[0][n-1]>0)
            System.out.println(save[0][n-1]); 
        else
            System.out.println("impossible");        
    }
}