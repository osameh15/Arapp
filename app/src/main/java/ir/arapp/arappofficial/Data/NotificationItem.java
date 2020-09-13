package ir.arapp.arappofficial.Data;

public class NotificationItem
{
    //Variables
    private int image;
    private String title;
    private String subtitle;
    private String text;

    //Constructor
    public NotificationItem(int image, String title, String subtitle, String text)
    {
        this.image = image;
        this.title = title;
        this.subtitle = subtitle;
        this.text = text;
    }

    //Getter functions
    public int getImage()
    {
        return image;
    }
    public String getTitle()
    {
        return title;
    }
    public String getSubtitle()
    {
        return subtitle;
    }
    public String getText()
    {
        return text;
    }
}
