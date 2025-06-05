import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int arr[]=new int[N];
        Set<Integer> sortedArr=new HashSet<>();
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());

            sortedArr.add(arr[i]);    
        }
        List<Integer> sortedList = new ArrayList<>(sortedArr);
        Collections.sort(sortedList);
        HashMap<Integer, Integer> data = new HashMap<>();

        for(int i=0;i<sortedList.size();i++){
            data.put(sortedList.get(i), i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(data.get(arr[i])).append(" ");
        }

        System.out.println(sb);

        
    }
}