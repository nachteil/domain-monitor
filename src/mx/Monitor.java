package mx;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Monitor {
    private ArrayList<Domain> domainList;
    private long delayInMs;

    public Monitor(ArrayList<Domain> domainList, long delayInMs) {
        this.domainList = domainList;
        this.delayInMs = delayInMs;
    }

    public ArrayList<Domain> getDomainListWithStatuses() throws HostException
    {
        try{
            observe();
        } catch (InterruptedException | IOException e){
            throw new HostException("Wystąpił błąd z pobraniem statusu dla domen");
        }
        return domainList;
    }

    private void observe() throws InterruptedException, IOException {

        for (Domain domain : domainList) {
            HttpURLConnection connection = (HttpURLConnection) new URL(domain.getUrl()).openConnection();
            connection.setInstanceFollowRedirects(true);
            domain.setStatus(connection.getResponseCode());
            connection.disconnect();
            Thread.sleep(delayInMs);

        }
    }
}
