package pojo;

public class Results
{
    private String nat;

    private String gender;

    private Name name;

    Results() {}

    public Results(String nat, String gender, Name name) {
        this.nat = nat;
        this.gender = gender;
        this.name = name;
    }

    public String getNat ()
    {
        return nat;
    }

    public void setNat (String nat)
    {
        this.nat = nat;
    }

    public String getGender ()
    {
        return gender;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }

    public Name getName ()
    {
        return name;
    }

    public void setName (Name name)
    {
        this.name = name;
    }

}
