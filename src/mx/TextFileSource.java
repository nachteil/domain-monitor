package mx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by masterix on 23.11.2016.
 */
public class TextFileSource implements ISource {

    protected ArrayList<Domain> domains;

    protected String filename;

    public TextFileSource() {
        domains = new ArrayList<>();
    }

    @Override
    public ArrayList<Domain> getDomainList() {
        return domains;
    }

    /**
     * New filename resets domains' list
     * @param filename
     * @throws IOException
     */
    public void setFilenameAndRead(String filename) throws IOException {
        this.filename = filename;
        domains.clear();
        readDomainsFromCsv();
    }

    protected void readDomainsFromCsv() throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String url = null;
        while ((url = br.readLine()) != null) {
            domains.add(new Domain(url));
        }
        br.close();

    }
}
