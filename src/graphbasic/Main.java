package graphbasic;

import java.util.ArrayList;

public class Main{
    public static int city[][] = { {1,1,1,1}, {1,1,1,0}, {1,1,1,1}, {1,0,1,1} };
    //public static int city[][] = { {1,0,1,0}, {1,1,0,0}, {0,1,1,0}, {1,0,1,1} };
    public static boolean check(int cityFrom, int cityTo){
        return city[cityFrom][cityTo] == 1;
    }
    public static boolean isAnyWay(int fromCity, int toCity){
        if(check(fromCity, toCity)){
            return true;
        }
        else{
            for(int cityCode : allConnections(fromCity)){
                isAnyWay(cityCode, toCity);
            }
        }
        return false;
    }
    public static ArrayList<Integer> allConnections(int cityFrom){
        int i = 0;
        ArrayList<Integer> citylist = new ArrayList<>();
        for(int connected : city[cityFrom]){
            if(connected == 1)
                citylist.add(i);
            i++;
        }
        return citylist;
    }
    public static void main(String[] args) {
        System.out.println(isAnyWay(2, 3));
        /*for(int n : allConnections(0)){
            System.out.println(n);
        }*/
        //System.out.println(check(2, 3));
    }
}