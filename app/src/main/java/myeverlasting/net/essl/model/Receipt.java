package myeverlasting.net.essl.model;

/**
 * Created by babafemi on 10/11/2017.
 */

public class Receipt {
    private String title,intro,date,amount;

    public Receipt(String title, String intro, String date, String amount) {
        this.title = title;
        this.intro = intro;
        this.date = date;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
