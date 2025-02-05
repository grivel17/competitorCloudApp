package pl.cloud.crudmig;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CompetitorViewDTO {
    private long id;
    private String name;
    private String surname;
    private String clubName;

    public CompetitorViewDTO() {
    }

    public CompetitorViewDTO(long id, String name, String surname, String clubName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.clubName = clubName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getClubName() {
        return clubName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitorViewDTO that = (CompetitorViewDTO) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(clubName, that.clubName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, clubName);
    }
}
