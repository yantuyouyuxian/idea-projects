import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2021/11/24 15:45
 * @ Description
 */
public class Comparator {
    @Test
    public void test01() {

        Person p1 = new Person("张三", 18, "男");
        Person p6 = new Person("张三", 18, "男");
        Person p2 = new Person("李四", 18, "女");
        Person p3 = new Person("张东", 18, "男");
        Person p4 = new Person("李明", 18, "女");
        Person p5 = new Person("王五", 18, "男");

        List<Person> personList = Arrays.asList(p1, p2, p3, p4, p5, p6);

        personList.sort((a, b) -> {
            if (a.name.startsWith("张")) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println(personList);

    }

    class Person {

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + "'" +
                    '}';
        }

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        String name;
        int age;
        String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
}
