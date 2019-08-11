package src.Olivia;


//NO 1154
public class dayOfYear {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));
        int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int res = 0;
        //corner case
        if(month==1) return day;
        for(int i=0;i<month-1;i++){
            res += days[i];
        }
        res += day;
        //about the double year!
        if(((year%4 == 0 && year%100 != 0) || (year %400 == 0))&&(month>2)) res++;
        return res;
    }
}
