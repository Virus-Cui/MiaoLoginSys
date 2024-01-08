package cn.mrcsh.miaologinsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MiaoLoginSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiaoLoginSysApplication.class, args);
    }

}