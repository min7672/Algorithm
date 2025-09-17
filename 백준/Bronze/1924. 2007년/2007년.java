import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String date[]=br.readLine().split(" ");
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate time=LocalDate.parse(String.format("2007-%02d-%02d", Integer.parseInt(date[0]),Integer.parseInt(date[1])),dt);
        
        System.out.println(time.getDayOfWeek().toString().substring(0, 3));
    }
}
