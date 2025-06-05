import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        char []word=sc.nextLine().toCharArray();
        int cnt=0;
        
        for(int i=0;i<word.length;i++){
            
            if("cdlsnz".indexOf(word[i])>=0){
                if(i+1<word.length){
                    if("=-".indexOf(word[i+1])>=0 ||("ln".indexOf(word[i])>=0 && word[i+1]=='j')){
                        i++;                      
                    }else if(word[i]=='d'&& word[i+1]=='z'){
                        if(i+2<word.length)
                            if(word[i+2]=='=')
                                i+=2;                                
                    }
                }
            }
            cnt++;
            
        }
        System.out.println(cnt);
        

        

    }
}