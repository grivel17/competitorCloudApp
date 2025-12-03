package pl.cloud.crudmig;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "competitor")
public class Competitor extends BaseEntity {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "status")
    private String status;

    @Column(name = "competitorClubId")
    private Long competitorClubId;

    public Competitor() {
    }

    public Competitor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = CompetitorStatus.NEW.toString();
        this.competitorClubId = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCompetitorClubId() {
        return competitorClubId;
    }

    public void setCompetitorClubId(Long competitorClubId) {
        this.competitorClubId = competitorClubId;
    }
}
