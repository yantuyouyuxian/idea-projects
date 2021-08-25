/**
 * 接口中可以定义的注解均可以定义
 */
public @interface MyAnno {
    int value();
    String name() default "zh";
    Person per();
    MyAnno2 anno2();
    String[] strs();
}
