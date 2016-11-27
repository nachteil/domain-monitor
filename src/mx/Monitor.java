package mx;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by masterix on 08.10.2016.
 */
public class Monitor {
    protected ISource source;
    private long delayInMs;

    public void setSource(ISource s){
        source = s;
    }

    public void setDelayInMs(long delay){
        delayInMs = delay;
    }

    public void observe() throws InterruptedException, IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("http://google.com").openConnection();
        connection.setInstanceFollowRedirects(true);
        System.out.println("Response code:" + connection.getResponseCode());
        connection.disconnect();
        /*while (true){
            Thread.sleep(delayInMs);
        }*/
    }
}
