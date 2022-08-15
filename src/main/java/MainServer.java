import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import com.aaa.MainServerTest;

public class MainServer {
    public MainServer() throws LifecycleException {
        //创建tomcat对象
        Tomcat tomcat = new Tomcat();
        //设置启动端口
        tomcat.setPort(8089);
        //引导Http引擎
        tomcat.getConnector();

        //创建上下文
        Context context = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(context, "testServlet", new TestServlet());//注册Servlet
        servlet.setLoadOnStartup(1);//容器启动初始化Sevlet
        servlet.addMapping("/test");//配置Servlet的访问路径
        //启动tomcat
        tomcat.start();
    }


    public static void main(String[] args) throws LifecycleException {
        new MainServer();
        new MainServerTest();
    }
}
