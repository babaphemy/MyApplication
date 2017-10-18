package myeverlasting.net.essl.model;

/**
 * Created by babafemi on 10/8/2017.
 */

public class Product {
    private String pdtid;
    private String title;
    private String cost;
    private String description;
    private String intro;
    private int image;

    public Product(String pdtid, String title, String cost, String description, String intro, int image) {
        this.pdtid = pdtid;
        this.title = title;
        this.cost = cost;
        this.description = description;
        this.intro = intro;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPdtid() {
        return pdtid;
    }

    public void setPdtid(String pdtid) {
        this.pdtid = pdtid;
    }
}
