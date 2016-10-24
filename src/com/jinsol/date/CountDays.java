package com.jinsol.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by jaejo on 9/1/16.
 *
 * with Java 7 or 8 when java.util.concurrent was added
 * 윤달 (leap month) 포함해서
 */
public class CountDays {

    public static void main(String[] args) {

        // incorrect due to deprecated ctor, new Date(2016, 1, 1)
//        System.out.println( getDaysDiff(new Date(2016, 1, 1), new Date(2016, 1, 20)) + 1 );
//        System.out.println( getDaysDiff(new Date(2016, 1, 1), new Date(2016, 12, 31)) + 1 );
//        System.out.println( getDaysDiff(new Date(2016, 1, 1), new Date(2016, 2, 1)) + 1 );
//        System.out.println( getDaysDiff(new Date(2016, 1, 1), new Date(2016, 3, 1)) + 1 );
//        System.out.println( getDaysDiff(new Date(2016, 1, 1), new Date(2016, 4, 1)) + 1 );
//
//        System.out.println("");
//        System.out.println( getMyDaysDiff(new Date(2016, 1, 1), new Date(2016, 1, 20)) + 1 );
//        System.out.println( getMyDaysDiff(new Date(2016, 1, 1), new Date(2016, 12, 31)) + 1 );
//        System.out.println( getMyDaysDiff(new Date(2016, 1, 1), new Date(2016, 2, 1)) + 1 );
//        System.out.println( getMyDaysDiff(new Date(2016, 1, 1), new Date(2016, 3, 1)) + 1 );
//        System.out.println( getMyDaysDiff(new Date(2016, 1, 1), new Date(2016, 4, 1)) + 1 );


        SimpleDateFormat dates = new SimpleDateFormat("yyyy/MM/dd");
        try {
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/01/20")) ); //20
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/01/31")) ); //31
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/02/01")) ); //32
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/03/01")) ); // 31+29+1= 61, leap month
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/03/02")) ); // 62

            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/03/13")) ); // 73
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/03/14")) ); // 74, but 73

            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/03/21")) ); // 81, but 80
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/03/31")) ); // 91, but 90

            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/04/01")) ); // 31+29+31+1=92 but 91
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/05/01")) ); // 91+30+1= 122 but 121
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/06/01")) ); // 121+31+1= 153 but 152
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/07/01")) ); // 152+30+1= 183 but 182
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/08/01")) ); // 182+31+1= 214 but 213
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/09/01")) ); // 213+31+1= 245 but 244
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/10/01")) ); // 244+30+1= 275 but 274
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/11/01")) ); // 274+31+1= 306 but 305
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/12/01")) ); // 305+30+1= 337 but 336
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/12/11")) ); // 305+30+1= 337 but 346
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/12/21")) ); // 305+30+1= 337 but 356

            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/12/31")) ); //366 due to leap month
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/01/01")) ); //1
            System.out.println( getDaysDiff(dates.parse("2015/01/01"), dates.parse("2015/03/01")) ); // 60, no leap month, i.e. Feb 28th
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/04/01")) ); // 31+29+31+1=92
            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/05/01")) ); // 91+30+1= 122

            System.out.println( getDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/08/15")) ); // ?


            System.out.println("");
//            System.out.println( getMyDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/01/20")) );
//            System.out.println( getMyDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/12/31")) );
//            System.out.println( getMyDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/01/01")) );
//            System.out.println( getMyDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/02/01")) );
//            System.out.println( getMyDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/03/01")) );
//            System.out.println( getMyDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/04/01")) );
            System.out.println( getMyDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/03/13")) );
            System.out.println( getMyDaysDiff(dates.parse("2016/01/01"), dates.parse("2016/03/14")) );

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    // d2 is later than d1
    static long getDaysDiff(Date d1, Date d2) {

        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;

//        return ChronoUnit.DAYS.between(d1, d2) + 1;
    }

    static int getMyDaysDiff(Date d1, Date d2) {

        long diff = d2.getTime() - d1.getTime();
        long daysDiff = diff / (24 * 60 * 60 * 1000) + 1;
        return (int) daysDiff;
    }


}
