package main.greedy;

public class CheckSurviceOnIsland {

    private static boolean isSurvive(int maxUnitPerDay , int surviveDay , int unitFood){
        int sunday = surviveDay/7;
        int weekDay = surviveDay - sunday ;
        int totalUnitReq = surviveDay * unitFood ;
        int daysReq = totalUnitReq /maxUnitPerDay;
        if( totalUnitReq % maxUnitPerDay != 0)
            daysReq++;
        if(daysReq <= weekDay )
            return true;
        return false;
        }

    public static void main(String[] args) {
        System.out.println("Is Survivable : "+CheckSurviceOnIsland.isSurvive(16,10,2));
        System.out.println("Is Survivable : "+CheckSurviceOnIsland.isSurvive(20,10,30));

    }
}
