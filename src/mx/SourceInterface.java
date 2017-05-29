package mx;

import java.util.ArrayList;

public interface SourceInterface {
    ArrayList<Domain> getDomainList() throws SourceNotFoundException;
}
