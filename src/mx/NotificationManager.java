package mx;

import java.util.ArrayList;

/**
 * Created by masterix on 28.05.2017.
 */
public class NotificationManager {

    private ArrayList<NotificationSenderInterface> senders;

    public NotificationManager(){
        senders = new ArrayList<>();
    }

    public void addSender(NotificationSenderInterface sender){
        senders.add(sender);
    }

    public void removeSender(NotificationSenderInterface sender){
        senders.remove(sender);
    }

}
