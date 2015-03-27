package cineplex.timerTask;

/**
 * Created by wlw on 15-3-15.
 */
public class Percent {

    private String name;
    private Integer number;

    public Percent(String name,Integer number)
    {
        this.name=name;
        this.number=number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+":"+number;
    }
}
