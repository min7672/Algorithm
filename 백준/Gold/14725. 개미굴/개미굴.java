import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import java.util.StringTokenizer;


public class Main {
    static class Node{
        public String value;
        public boolean sorted;
        public ArrayList<Node> childes;
        public Node(String value){
            this.value=value;
            this.sorted=false;
            this.childes=new ArrayList<>();
        }
    }
    static ArrayList<String> rootList;
    static HashMap<String, Node> map;
    static void preTrace(Node node,String prefix){
        
        if(!node.sorted){
            node.sorted=true;
            node.childes.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2){
                    return o1.value.compareTo(o2.value);
                }
            });
        }
        for(int i=0;i<node.childes.size();i++){
            System.out.println(prefix+"--"+node.childes.get(i).value);
            preTrace(node.childes.get(i), prefix+"--");
            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        map=new HashMap<String, Node>();
        rootList=new ArrayList<String>();
        StringTokenizer st=null;

        for(int z=0;z<N;z++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            Node preNode=null;

            for(int i=0;i<a;i++){
                String ins_s=st.nextToken();
                if(i==0){
                    if(!map.containsKey(ins_s)){
                        rootList.add(ins_s);
                        Node root=new Node(ins_s);
                        preNode=root;
                        map.put(ins_s, root);
                        
                    }else preNode=map.get(ins_s);
                }else{
                    Node node=new Node(ins_s);
                    boolean addChecker=false;
                    for(int k=0;k<preNode.childes.size();k++){
                        if(preNode.childes.get(k).value.equals(ins_s)){
                            addChecker=true;
                            preNode=preNode.childes.get(k);
                            break;       
                        }
                    }
                    if(!addChecker){
                        preNode.childes.add(node);
                        preNode=node;   
                    }
                }
            }
            
            
        }
        rootList.sort(null);
        for(int i=0;i<rootList.size();i++){
            System.out.println(rootList.get(i) );
            preTrace(map.get(rootList.get(i)),"");               
        }

        
    }  
}