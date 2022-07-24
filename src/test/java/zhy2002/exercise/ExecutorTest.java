package zhy2002.exercise;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {


   public static void main(String[] args) throws InterruptedException {
      ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);
      executor.scheduleAtFixedRate(
              () -> {
                 System.out.println("Start time: " + new Date());
                 throw new RuntimeException("not good");
              }, 0, 10, TimeUnit.SECONDS);

      executor.awaitTermination(100, TimeUnit.SECONDS);
   }
}
