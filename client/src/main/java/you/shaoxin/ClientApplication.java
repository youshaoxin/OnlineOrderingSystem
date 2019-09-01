package you.shaoxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 功能:
 * 创建时间: 2019-08-26 15:43 --游菜花
 */
@SpringBootApplication
@EnableFeignClients   //启动类必须加此注解，feign才有效
@ServletComponentScan //加上此注解拦截器才能生效
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class,args);
    }
}