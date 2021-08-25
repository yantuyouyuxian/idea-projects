import java.lang.annotation.*;

/**
 * 元注解
 */

@Target(value = {ElementType.TYPE,ElementType.METHOD})//表示作用于TYPE和METHOD类型上，详细进ElementType定义看
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno3 {

}
