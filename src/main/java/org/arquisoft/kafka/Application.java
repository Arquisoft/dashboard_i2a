package org.arquisoft.kafka;

import org.apache.commons.lang.SystemUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
}

@Component
class StartUp implements ApplicationListener<ContextRefreshedEvent> {
    private boolean initialized = false;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!initialized) {
            try {
                initialized=true;
                if (SystemUtils.IS_OS_WINDOWS) {
                    Runtime.getRuntime().exec("cmd.exe /c start kafkaWindows.bat");
                    Thread.sleep(35000);
//                } else if (SystemUtils.IS_OS_LINUX) {
//                    Runtime.getRuntime().exec("chmod +x kafkaLinux.sh");
//                    new ProcessBuilder("./kafkaLinux.sh").start();
                } else
                    System.err.println("OS is not compatible");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}