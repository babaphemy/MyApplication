package myeverlasting.net.essl.model;

/**
 * Created by babafemi on 10/16/2017.
 * for contact us messagee
 */

public class Support {
    private String name;
    private String title;
    private String message;
    private String email;
    private String issue;
    private String file;
    private String contactmeans; // phone number

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getContactmeans() {
        return contactmeans;
    }

    public void setContactmeans(String contactmeans) {
        this.contactmeans = contactmeans;
    }
}
