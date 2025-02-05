package pl.cloud.crudmig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudmigApplication {
    private static final Logger loggerInfo = LoggerFactory.getLogger(CrudmigApplication.class);
    private static final String MY_PASSWORD = "tom";

    public static void main(String[] args) {
        SpringApplication.run(CrudmigApplication.class, args);
        serverRunInfo();

    }
    private static void serverRunInfo() {
        loggerInfo.info("Password correct. Server run and ready");
    }
}
