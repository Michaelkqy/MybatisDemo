package com.mybatis.curd.util;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils extends PropertyEditorSupport {
    // 各种时间格式
    public static final SimpleDateFormat date_sdf_y = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat date_sdf_m = new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat date_sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat date_sdf_h = new SimpleDateFormat("yyyy-MM-dd HH");
    public static final SimpleDateFormat time_sdf_hm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat time_sdf_hms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final String FORMAT_TIME_HMS="yyyy-MM-dd HH:mm:ss";

    // 指定模式的时间格式
    private static SimpleDateFormat getSDFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    public static String date2string(Date date, String formatStr) {
        String strDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        strDate = sdf.format(date);
        return strDate;
    }

    /**
     * 参数可为数字gettime得到的long
     * 字符串转为日期格式为yyyy-MM-dd HH:mm:ss的字符串
     * @param str
     * @return
     */
    public String strFormat(String str){
        if(null == str || "".equals(str)){
            return "";
        }
        Date date = null;
        try {
            if (str.length() == 4) {
                date = str2Date(str, date_sdf_y);
            } else if (str.length() == 7&&str.indexOf("-")!=-1) {
                date =  str2Date(str, date_sdf_m);
            } else if(str.length() == 10&&str.indexOf("-")!=-1){
                date =  str2Date(str, date_sdf);
            } else if(str.length() == 13&&str.indexOf("-")!=-1){
                date =  str2Date(str, date_sdf_h);
            } else if(str.length() == 16&&str.indexOf("-")!=-1){
                date =  str2Date(str, time_sdf_hm);
            } else if(str.length() == 19&&str.indexOf("-")!=-1){
                date =  str2Date(str, time_sdf_hms);
            }else{
                Long millis = Long.parseLong(str);
                date = new Date(millis);
            }
            if(date!=null){
                return DateToString(date);
            }
        }catch(Exception e){
            return "";
        }
        return "";
    }


    /**
     * 参数可为数字gettime得到的long
     * 字符串转为日期格式为yyyy-MM-dd HH:mm:ss的字符串
     * @param str
     * @return
     */
    public String strFormat(String str,SimpleDateFormat sdf){
        if(null == str || "".equals(str)){
            return "";
        }
        Date date = null;
        try {
            if (str.length() == 4) {
                date = str2Date(str, date_sdf_y);
            } else if (str.length() == 7&&str.indexOf("-")!=-1) {
                date =  str2Date(str, date_sdf_m);
            } else if(str.length() == 10&&str.indexOf("-")!=-1){
                date =  str2Date(str, sdf);
            } else if(str.length() == 13&&str.indexOf("-")!=-1){
                date =  str2Date(str, sdf);
            } else if(str.length() == 16&&str.indexOf("-")!=-1){
                date =  str2Date(str, sdf);
            } else if(str.length() == 19&&str.indexOf("-")!=-1){
                date =  str2Date(str, sdf);
            }else{
                Long millis = Long.parseLong(str);
                date = new Date(millis);
            }
            if(date!=null){
                return DateToString(date,sdf);
            }
        }catch(Exception e){
            return "";
        }
        return "";
    }

    /**
     * 字符串转换成日期
     * @param str
     * @param sdf
     * @return
     */
    public Date str2Date(String str, SimpleDateFormat sdf) {
        if (null == str || "".equals(str)) {
            return null;
        }
        Date date = null;
        try {
            date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
        }
        return null;
    }

    /**
     * @description 将日期转化为字符串,字符串格式("yyyy-MM-dd HH:mm:ss")，小时、分、秒被忽略
     * @date 2015-5-21
     * @param date 日期
     * @return 带格式的字符串
     */
    public String DateToString(Date date) {
        SimpleDateFormat formater = time_sdf_hms;
        String strDateTime = formater.format(date);
        return strDateTime;
    }

    public String DateToString(Date date,SimpleDateFormat formater) {
        SimpleDateFormat formater_ = formater;
        String strDateTime = formater_.format(date);
        return strDateTime;
    }

    /**
     * 指定毫秒数表示的日期
     * @param millis
     *            毫秒数
     * @return 指定毫秒数表示的日期
     */
    public Date getDate(long millis) {
        return new Date(millis);
    }



    public Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    public long stringToLong(String strTime, String formatType)
            throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    public long dateToLong(Date date) {
        return date.getTime();
    }

    public static String getPerFirstDayOfMonth(String stdDate) {
        Date date = null;
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            date = date_sdf_m.parse(stdDate);
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time_sdf_hms.format(calendar.getTime());

    }

    /**
     * 得到
     * 0 上旬 1 中旬 2 下旬
     */
    public String getTenByTime(Date date){
        if(date==null){
            return "";
        }
        //计算是否为当前旬
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int xun = day/10;
        int yu = day%10;
        if(yu==0&&xun>0&&xun!=3){
            xun-=1;
        }
        if(xun==3){
            xun=2;
        }
        return xun+"";
    }
    /**
     * 得到
     * 0 上旬 1 中旬 2 下旬
     */
    public String get2XunLastDay(Date date){
        //DateUtils du = new DateUtils();
        //String ym = du.DateToString(date,DateUtils.date_sdf_m);
        String day = "";
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        String month = (c.get(Calendar.MONTH)+1)+"";
        if("1".equals(month)||"3".equals(month)||"5".equals(month)||"7".equals(month)||"8".equals(month)||"10".equals(month)||"12".equals(month)){
            day = "31";
        }else if("2".equals(month)){
            if(year%4 == 0 && year%100 != 0 || year%400 == 0){
                day = "29";
            }else{
                day = "28";
            }
        }else{
            day = "30";
        }
        return day;
    }
    public int getMonth(String currentdate){
        Date date = null;
        date = this.str2Date(currentdate,date_sdf);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH)+1;
    }

    public int getDay(String currentdate){
        Date date = null;
        date = this.str2Date(currentdate,date_sdf);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static String[] parseTimeStringArr(String bgtm, String endtm){
        DateUtils du = new DateUtils();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(du.str2Date(endtm, date_sdf));
        long betweenDays=(du.str2Date(endtm, date_sdf).getTime()-du.str2Date(bgtm, date_sdf).getTime())/(1000*3600*24);
        String[] res = null;
        if(betweenDays>0){
            Integer l = 0;
            try{
                l = Integer.parseInt((betweenDays-1)+"");
            }catch (Exception e){
                return null;
            }
            res = new String[l];
            for(int i=0;i<l;i++){
                calendar.add(Calendar.DAY_OF_MONTH, -1);
                System.out.print(calendar.getTime());
                res[i] = du.strFormat(calendar.getTime().getTime()+"",du.date_sdf);
            }
        }else{
            return null;
        }
        return res;
    }


    /**
     * 两时间间隔多少天
     * @param
     */
    public Integer getDaysCountFromBgtmToEndtm(String bgTm,String endTm){
        Integer res = null;
        try {
            if (bgTm == null || "".equals(bgTm) || endTm == null || "".equals(endTm)) {
                return null;
            }else{
                Long fr = this.str2Date(bgTm, DateUtils.date_sdf).getTime();
                Long to = this.str2Date(endTm, DateUtils.date_sdf).getTime();
                long result = (to - fr) / (24*60*60*1000);
                res = Integer.parseInt(result + "");
            }
        }catch (Exception e){
            return null;
        }
        return res;
    }



    public static void main(String[] args) throws ParseException {
        DateUtils du = new DateUtils();
        String day = du.getTenByTime(du.str2Date("2016-07-30",DateUtils.date_sdf));
        System.out.print(day);
    }


}