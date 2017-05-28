package mx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileSource implements SourceInterface {

    protected ArrayList<Domain> domains;

    protected String filename;

    public TextFileSource(String inputFilename) {
        domains = new ArrayList<>();
        filename = inputFilename;
    }

    @Override
    /**
     * @throws SourceNotFoundException
     */
    public ArrayList<Domain> getDomainList() throws SourceNotFoundException {
        domains.clear();
        try{
            readDomainsFromFile();
        }
        catch(IOException ex){
            throw new SourceNotFoundException(ex.getMessage());
        }

        return domains;
    }

    private void readDomainsFromFile() throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String url;
        while ((url = br.readLine()) != null) {
            domains.add(new Domain(url));
        }
        br.close();

    }
}
