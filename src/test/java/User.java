import org.testng.annotations.*;

@Test
public class User {
    public String gender;
    private String title;
    private String first;
    private String last;
    public void name(String title, String first, String last){
        this.title = title;
        this.first = first;
        this.last = last;
    }
    public String nat;
}
