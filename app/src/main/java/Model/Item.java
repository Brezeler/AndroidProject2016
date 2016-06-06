package Model;

import java.util.Date;

/**
 * Created by Brezeler on 06/05/2016.
 */
public class Item {

    private String link;
    private String title;
    private Date pubDate;
    private String id;
    private String source;
    private String description;

    public Item(String link, String title, Date pubDate, String id, String source, String description) {
        this.link = link;
        this.title = title;
        this.pubDate = pubDate;
        this.id = id;
        this.source = source;
        this.description = description;
    }

    public Item() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
