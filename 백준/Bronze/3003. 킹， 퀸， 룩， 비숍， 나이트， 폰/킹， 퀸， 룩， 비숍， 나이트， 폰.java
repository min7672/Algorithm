import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //king, queen, Rook, Bishop, knight, pawn
        // 1 ,  1,    2,       2,     ,2    8
        int result[]={1,1,2,2,2,8};
        Scanner sc=new Scanner(System.in);
        String pieces[]=sc.nextLine().split(" ");
        for(int i=0;i<pieces.length;i++){
            System.out.print((result[i]-Integer.parseInt(pieces[i]))+" ");

        }

    }    
}
