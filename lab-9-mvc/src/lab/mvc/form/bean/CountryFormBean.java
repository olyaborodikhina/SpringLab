package lab.mvc.form.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by omsk17 on 12/12/2016.
 */
public class CountryFormBean {

    public CountryFormBean(){}

    @NotNull(message="{NotNull.countryFormBean.nameCountry}")
    @Size(min = 2, max = 20)
    private String nameCountry;

    @NotNull
    @Size(min = 2, max = 30)
    private String codeCountry;

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
        return "Country [nameCountry=" + nameCountry + ", codeCountry=" + codeCountry + "]";
    }
}
