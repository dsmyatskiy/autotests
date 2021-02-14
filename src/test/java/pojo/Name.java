package pojo;

public class Name
{
    private String last;

    private String title;

    private String first;

    public Name(String last, String title, String first) {
        this.last = last;
        this.title = title;
        this.first = first;
    }

    Name() {}

    public String getLast ()
    {
        return last;
    }

    public void setLast (String last)
    {
        this.last = last;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getFirst ()
    {
        return first;
    }

    public void setFirst (String first)
    {
        this.first = first;
    }

}
