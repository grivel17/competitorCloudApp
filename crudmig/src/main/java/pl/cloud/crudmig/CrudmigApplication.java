package pl.cloud.crudmig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class CrudmigApplication {
    private static final Logger loggerInfo = LoggerFactory.getLogger(CrudmigApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrudmigApplication.class, args);
        serverRunInfo();

    }
    private static void serverRunInfo() {
        loggerInfo.info("Server run and ready");
    }
}
