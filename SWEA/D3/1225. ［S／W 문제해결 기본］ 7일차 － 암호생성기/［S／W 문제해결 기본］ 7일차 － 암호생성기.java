
import java.util.LinkedList;

import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        
        for(int test_case=1;test_case<=10;test_case++){
            sc.nextLine();
            String []datas=sc.nextLine().split(" ");
            Queue<Integer> arr=new LinkedList<Integer>();
            
            for(int i=0;i<datas.length;i++){
                arr.add(Integer.parseInt(datas[i]));
            }


            int tmp=0;
            int minusCnt=0;
            // boolean []visted=new boolean[8];

            // for(int i=0; i<10;i++){
            do{
                tmp=arr.poll();
                tmp=tmp-(minusCnt%5+1);
                
                if(tmp<=0)tmp=0;
                    
                arr.add(tmp);
                
                // System.out.println(" "+tmp+" "+(minusCnt%5+1));
                
                minusCnt++;
                

            }while(tmp!=0);


            System.out.printf("#%d ",test_case);
            while(!arr.isEmpty()){
                tmp=arr.poll();
                System.out.print(tmp+" ");
            }
            System.out.println("");

        }

        
    }

}
