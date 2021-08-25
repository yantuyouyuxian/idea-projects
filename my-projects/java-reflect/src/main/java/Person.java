public class Person {

    public String a;

    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "a='" + a + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void eat(){
        System.out.println("eat()");
    }

    public void eat(String food){
        System.out.println("eat :"+food);
    }

}
