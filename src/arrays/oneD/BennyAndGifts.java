package arrays.oneD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BennyAndGifts {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int x = 0;
        int y =0;
        HashMap<String,Boolean> path = new HashMap<>();
        path.put(x+","+y,true);
        int icySteps = 0;
        for (char step : input.toCharArray()) {
            x = processX(step,x);
            y = processY(step,y);
            String key = x+","+y;
            icySteps += path.getOrDefault(key,false) ? 1 : 0;
            path.put(key,true);
        }

        System.out.println(icySteps);

    }

    public static int processX(char step,int x) {

        if (step == 'U') {
            return  x-1;
        } else if (step == 'D') {
            return  x+1;
        }
        return x;

    }

    public static int processY(char step,int y) {

        if (step == 'L') {
            return  y-1;
        } else if (step == 'R') {
            return  y+1;
        }
        return y;

    }

}
