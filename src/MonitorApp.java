import mx.Monitor;
import mx.TextFileSource;

import java.io.IOException;

public class MonitorApp {
    public static void main(String[] args) {
        System.setProperty("http.keepAlive", "false");
        long delayInMs = 200;
        String filename = "test.txt";
        if (args.length > 0) {
            try {
                delayInMs = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.print("Argument must be integer");
                System.exit(1);
            }

            if(args.length >= 2){
                filename = args[1];
            }
        }
        System.out.printf("Delay: %dms", delayInMs);

        // prepare source
        TextFileSource tfs = new TextFileSource();
        try {
            tfs.setFilenameAndRead(filename);
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
            System.exit(1);
        }

        // run monitor
        Monitor m = new Monitor();
        m.setSource(tfs);
        m.setDelayInMs(delayInMs);

        try {
            m.observe();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
