package lab.domain;

/**
 * Created by omsk17 on 12/12/2016.
 */
public class Country {

    private int id;

    private String nameCountry;

    private String codeCountry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }

    @Override
    public String toString() {
        return "Country [id=" + id + ", nameCountry=" + nameCountry + ", codeCountry="
                + codeCountry + "]";
    }
}
