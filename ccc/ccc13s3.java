import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
 
public class ccc13s3 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList<String> map = new LinkedList<String>();
        map.add("12");   //0
        map.add("13");   //1
        map.add("14");   //2
        map.add("23");
        map.add("24");
        map.add("34");
       
       
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //Your favorite team
        int N = sc.nextInt();
       
        char[] game = new char[6];
        Arrays.fill(game, ' ');
        for (int i=0; i<N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int scoreA = sc.nextInt();
            int scoreB = sc.nextInt();
            int index = map.indexOf(""+a+b);
            if (scoreA>scoreB) {
                game[index] = 'W';
            } else if (scoreA<scoreB) {
                game[index] = 'L';
            } else {
                game[index] = 'T';
            }
        }
        String S = "";
        for (int i=0; i<6; i++) {
            S+=game[i];
        }
        LinkedList<String> queue = new LinkedList<String>();
        queue.add(S);
       
        while (true) {
            int index = queue.peek().indexOf(" ");
            if (index==-1) {
                break;
            } else {
                S = queue.poll();
                queue.add(S.substring(0,index)+"W"+S.substring(index+1));
                queue.add(S.substring(0,index)+"T"+S.substring(index+1));
                queue.add(S.substring(0,index)+"L"+S.substring(index+1));
            }
        }
       
        int[] point = new int[4];
        int count = 0;
        while (!queue.isEmpty()) {
            Arrays.fill(point, 0);
            S = queue.poll();
            for (int i=0; i<6; i++) {
                int a = map.get(i).charAt(0)-'1';
                int b = map.get(i).charAt(1)-'1';
                if (S.charAt(i)=='W') {
                    point[a]+=3;
                } else if (S.charAt(i)=='L') {
                    point[b]+=3;
                } else {
                    point[a]++;
                    point[b]++;
                }
            }
           
            int favor = point[T-1];
            Arrays.sort(point);
            if (favor==point[3] && favor!=point[2]) {
                count++;
            }
           
        }
 
        System.out.println(count);
       
    }
}