import org.springframework.beans.factory.annotation.Required;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @Author by 张志斌 .
 * @Date 15:00 2019/9/23
 */
public class TestBean {
    private String name;
    public void say(){
        System.out.println("my name is :" + name);
    }

    public void sayAfter(){
        System.out.println("say after my name is :" + name);
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        InputSource inputSource = new InputSource();
        documentBuilder.parse(inputSource);
    }
}
