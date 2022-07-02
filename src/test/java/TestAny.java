import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestAny {

    @Test
    public void testTimestamp() {
        long time = new Date().getTime();
        System.out.println("time = " + time);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date(time));
        System.out.println("format = " + format);
    }

}
