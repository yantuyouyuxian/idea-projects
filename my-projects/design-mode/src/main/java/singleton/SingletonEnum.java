package singleton;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/3 20:54
 * @ Description    枚举类实现单例模式
 */
public enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("doSomething()");
    }

    public static void main(String[] args) {
        SingletonEnum.INSTANCE.doSomething();
    }
}
