import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author by 张志斌 .
 * @Date 14:49 2019/9/6
 */
public class BeanFactoryTest {
    @Test
    public void testSimpleLoad(){
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        TestBean testBean = (TestBean)beanFactory.getBean("testBean");
        testBean.say();
//        FileSystemXmlApplicationContext
    }

    public static void main(String[] args) {
        int[][] arr ={{1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        boolean b = searchMatrix(arr, 3);
        System.out.println(b);


    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int lengthA = matrix.length;
        if(lengthA == 0){
            return false;
        }
        int lengthB = matrix[0].length;
        int pointA = 0;
        int pointB = lengthB - 1;
        while(pointA < lengthA && pointB < lengthB){
            if(target == matrix[pointA][pointB]){
                return true;
            }
            if(matrix[pointA][pointB] > target){
                pointB--;
            }else{
                pointA++;
            }
        }
        return false;
    }
}
