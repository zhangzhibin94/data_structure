/**
 * Created by 98684 on 2019/2/12.
 */
public class Demo {
    public static void main(String[] args)
    {
        int num = 10;
        shopping.shopCart();
    }

}

class Student
{
    private static String name;
    private int age;

    public int getAge(){
        return this.age;
    }
    public void setAge(){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
}
class shopping{
    public static void shopCart(){
        System.out.println("我是一个静态方法");
    }
}

