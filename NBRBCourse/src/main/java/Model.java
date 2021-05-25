import java.util.Objects;

@SuppressWarnings("LossyEncoding")
public class Model {

    private Integer Cur_ID;
    private String Date;
    private String Cur_Abbreviation;
    private Integer Cur_Scale;
    private String Cur_Name;
    private Double Cur_OfficialRate;
    private String currencyName;

    public Model() {
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Integer getCur_ID() {
        return Cur_ID;
    }

    public void setCur_ID(Integer cur_ID) {
        Cur_ID = cur_ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCur_Abbreviation() {
        return Cur_Abbreviation;
    }

    public void setCur_Abbreviation(String cur_Abbreviation) {
        Cur_Abbreviation = cur_Abbreviation;
    }

    public Integer getCur_Scale() {
        return Cur_Scale;
    }

    public void setCur_Scale(Integer cur_Scale) {
        Cur_Scale = cur_Scale;
    }

    public String getCur_Name() {
        return Cur_Name;
    }

    public void setCur_Name(String cur_Name) {
        Cur_Name = cur_Name;
    }

    public Double getCur_OfficialRate() {
        return Cur_OfficialRate;
    }

    public void setCur_OfficialRate(Double cur_OfficialRate) {
        Cur_OfficialRate = cur_OfficialRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(Cur_ID, model.Cur_ID) &&
                Objects.equals(Date, model.Date) &&
                Objects.equals(Cur_Abbreviation, model.Cur_Abbreviation) &&
                Objects.equals(Cur_Scale, model.Cur_Scale) &&
                Objects.equals(Cur_Name, model.Cur_Name) &&
                Objects.equals(Cur_OfficialRate, model.Cur_OfficialRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Cur_ID, Date, Cur_Abbreviation, Cur_Scale, Cur_Name, Cur_OfficialRate);
    }

    @Override
    public String toString() {
        return "Model{" +
                "Cur_ID=" + Cur_ID +
                ", Date='" + Date + '\'' +
                ", Cur_Abbreviation='" + Cur_Abbreviation + '\'' +
                ", Cur_Scale=" + Cur_Scale +
                ", Cur_Name='" + Cur_Name + '\'' +
                ", Cur_OfficialRate=" + Cur_OfficialRate +
                '}';
    }

    public String toStringCourse () {
        return "\nНаименование валюты:  " + getCur_Name() +
                "\nКурс валюты: " + getCur_OfficialRate();
    }
}



