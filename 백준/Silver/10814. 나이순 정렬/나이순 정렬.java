import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class Main {
    public static class Person{
        public int num;
        public int age;
        public String name;
        Person(int num,int age, String name){
            this.num=num;
            this.age=age;
            this.name=name;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        ArrayList<Person>  list=new ArrayList<>();
        String line[]=new String[2];
        for(int i=0;i<N;i++){
            line=br.readLine().split(" ");
            int a=Integer.parseInt(line[0]);
            
            list.add(new Person(i, a, line[1]));
        }
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2){
                int result=o1.age-o2.age;
                if(result==0){
                    result=o1.num-o2.num;
                }
                return result;
            }
        });
        for(int i=0;i<N; i++){
            System.out.printf("%d %s\n",list.get(i).age,list.get(i).name);
        }
      
    }
}
