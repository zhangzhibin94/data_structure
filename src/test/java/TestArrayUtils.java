import com.zzb.utils.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 98684 on 2019/1/31.
 */
public class TestArrayUtils {
  @Test
    public void testArray(){
        List<Long> testIds = new ArrayUtils<>();
        List<Long> testIds2 = new ArrayList<>(15);
        testIds.add(123L);
        testIds.add(1234L);
        testIds.stream().forEach(id->{
            if(id.equals("123")){

            }
        });
        System.out.println(Arrays.toString(testIds.toArray()));
        String name = "1234567890";
        char[] chars = name.toCharArray();

    }

}
