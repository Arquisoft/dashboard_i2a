package dashboard;

import org.apache.commons.lang.SystemUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Dax on 04-Apr-17.
 */
@Component
public class StartUp implements ApplicationListener<ContextRefreshedEvent>{
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
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
