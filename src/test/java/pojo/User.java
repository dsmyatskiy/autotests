package pojo;

public class User
{
    private Results[] results;

    public User(Results[] results) {
        this.results = results;
    }

    User() {}

    public Results[] getResults ()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

}
