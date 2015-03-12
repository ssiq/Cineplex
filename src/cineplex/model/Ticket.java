package cineplex.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wlw on 15-3-12.
 */
@Entity
@Table
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "paymentableGenerator", strategy = "native")
    private Integer ticketId;

    @ManyToOne(targetEntity=User.class, cascade= CascadeType.ALL, optional=false)
    private User user;

    @ManyToOne(targetEntity=ScreeningProgram.class, cascade= CascadeType.ALL, optional=false)
    private ScreeningProgram screeningProgram;

    Integer seatNumber;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ScreeningProgram getScreeningProgram() {
        return screeningProgram;
    }

    public void setScreeningProgram(ScreeningProgram screeningProgram) {
        this.screeningProgram = screeningProgram;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}
