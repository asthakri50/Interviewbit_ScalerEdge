import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Subject {
    String name;
    String startTime;
    String endTime;

    Subject(String name, String startTime, String endTime){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
public class MainTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String days = br.readLine();
        Integer t = Integer.parseInt(days);
        while(t>0){
            List<Subject> subjects = new ArrayList<>();
            String numSub = br.readLine();
            Integer n = Integer.parseInt(numSub);
            for(int i=0;i<n;i++){
                String line = br.readLine();
                String[] inp = line.split(" ");
                Subject s = new Subject(inp[0],inp[1], inp[2]);
                subjects.add(s);
            }
            subjects.sort(Comparator.comparing(s -> s.endTime));
            System.out.println(getMaxSubject(subjects));
            t--;
        }
    }
    static Integer getMaxSubject(List<Subject> subjects){
        int i = 0, j;
        int count = 1;
        for (j = 1; j < subjects.size(); j++)
        {
            if (subjects.get(j).startTime.compareTo(subjects.get(i).endTime)>=0)
            {
               count++;
                i = j;
            }
        }
        return count;
    }
}