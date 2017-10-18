package myeverlasting.net.essl.model;

/**
 * Created by babafemi on 10/7/2017.
 */

public class CardviewData {
    private String mtext1;
    private String mtext2;

    public CardviewData(String one,String two){
        mtext1 = one;
        mtext2 = two;
    }

    public String getMtext1() {
        return mtext1;
    }

    public void setMtext1(String mtext1) {
        this.mtext1 = mtext1;
    }

    public String getMtext2() {
        return mtext2;
    }

    public void setMtext2(String mtext2) {
        this.mtext2 = mtext2;
    }
}
