package main.array;

public class CountingValleys {
   static int countingValleys(int n, String s) {

       int v = 0;     // # of valleys
       int lvl = 0;   // current level
       for(char c : s.toCharArray()){
           if(c == 'U') ++lvl;
           if(c == 'D') --lvl;

           // if we just came UP to sea level
           if(lvl == 0 && c == 'U')
               ++v;
       }
       System.out.println(v);
       return  v;
       /*int level =0;
       int levelUp =0;
       int levelDown =0;
        for(char c : s.toCharArray()){
            if('U'==c){
                level++;
                levelUp++;
            }
            if('D'==c){
                level--;
                levelDown++;
            }

        }

        return Math.abs(level);*/
    }

    public static void main(String[] args) {
        System.out.println(CountingValleys.countingValleys(8,"UDDDUDUUDU"));

    }
}
