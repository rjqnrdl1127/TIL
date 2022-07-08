import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat todaySdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        //한국기준 날짜
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(-1900, 0, 1);
        todaySdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        String todayDate = todaySdf.format(date);
        //오늘 타임스탬프(데이트포맷으로 저장했다고 치고 그걸 타임스탬프로 바꿔보는 작업)
        long todayTimestamp = todaySdf.parse(todayDate).getTime();
        Date date2 = new Date(todayTimestamp);
        String todayDate2 = todaySdf.format(date2);

        //2019년 9월 6일의 타임스탬프
        String differentDate = "0000-01-01";
        long nextdayTimestamp = todaySdf.parse(differentDate).getTime();

        long difference = (todayTimestamp- nextdayTimestamp);
        System.out.println("오늘날짜 => "+todayDate2);
        System.out.println("다른날짜 => "+differentDate);
        System.out.println("differentTimestamp 타임스탬프=> "+todayTimestamp);
        System.out.println("todayTimestamp 타임스탬프=> "+todayTimestamp);
        System.out.println("일수차=> "  +  difference/ (24*60*60*1000));
    }
}
