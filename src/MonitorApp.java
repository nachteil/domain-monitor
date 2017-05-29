import mx.*;

import java.util.ArrayList;

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
        System.out.printf("Delay: %dms\r\n", delayInMs);

        // prepare source
        ArrayList<Domain> domainList = new ArrayList<>();
        try{
            TextFileSource textFileSource = new TextFileSource(filename);
            domainList = textFileSource.getDomainList();
        } catch (SourceNotFoundException ex){
            System.out.println(ex.getLocalizedMessage());
            System.exit(1);
        }

        try {
            Monitor domainMonitor = new Monitor(domainList, delayInMs);
            domainList = domainMonitor.getDomainListWithStatuses();
        } catch(HostException e) {
            e.printStackTrace();
        }

        for(Domain d: domainList){
            System.out.println("Response code for domain " + d.getUrl() + " is: " + d.getStatus());
        }
    }
}
