import java.util.Calendar;

/**
 * jdk自带注解
 */

public class AnnotationDemo02 {

    public static void main(String[] args) {
        AnnotationDemo02 an=new AnnotationDemo02();
        an.test();
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Deprecated
    public void show1(){

    }
    @SuppressWarnings("all")
    public void show2(){

    }


    public void test(){
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getCalendarType());
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeZone());

    }
}
