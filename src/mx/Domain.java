package mx;

/**
 * Created by masterix on 23.11.2016.
 */
public class Domain {

    protected String url;
    protected Integer status;

    public Domain(String url){
        this.url = url;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public Integer getStatus(){
        return status;
    }


}
