import java.time.LocalDateTime;
import java.time.Duration;

public class PerformanceTest {
    public void timeTakenByString() {
        LocalDateTime startTime = LocalDateTime.now();
        String testStr = "";
        for (int i = 0; i < 10000; i++) {
            testStr = testStr + i;
        }
        Duration diff = Duration.between(startTime, LocalDateTime.now());
        System.out.println("Milli Seconds ellapsed for string concatenation: " + diff.toMillis());
    }
    
    public void timeTakenByStringBuilder() {
        LocalDateTime startTime = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
        }
        Duration diff = Duration.between(startTime, LocalDateTime.now());
        System.out.println("Milli Seconds ellapsed for concatenation via string builder: " + diff.toMillis());
    }
    
    public static void main(String args[]) {
        PerformanceTest pt = new PerformanceTest();
        pt.timeTakenByString();
        pt.timeTakenByStringBuilder();
    }
}
