import java.io.IOException;
import java.time.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        LocalDate date=LocalDate.now();
        System.out.println(date.getYear());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfMonth());
    }
}