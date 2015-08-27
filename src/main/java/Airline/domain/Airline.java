package Airline.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Airline implements AirlineDetails, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String name;
    private String nationality;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="airline_id")
    private List<Aircraft> aircrafts;

    private Airline()
    {

    }

    public Airline(Builder builder)
    {
        this.ID=builder.ID;
        this.name=builder.name;
        this.nationality=builder.nationality;
        this.aircrafts = builder.aircrafts;
    }
    @Override
    public Long getID()
    {
        return this.ID;
    }
    @Override
    public String getAirlineName()
    {
        return this.name;
    }
    @Override
    public String getNationality()
    {
        return this.nationality;
    }
    @Override
    public List<Aircraft> getAircrafts()
    {
        return this.aircrafts;
    }

    public static class Builder
    {
        private Long ID;
        private String name;
        private String nationality;
        private List<Aircraft> aircrafts;

        public Builder(String name)
        {
            this.name=name;
        }

        public Builder ID(Long ID)
        {
            this.ID=ID;
            return this;
        }

        public Builder nationality(String nationality)
        {
            this.nationality=nationality;
            return this;
        }

        public Builder aircraft(List<Aircraft> aircrafts)
        {
            this.aircrafts = aircrafts;
            return this;
        }

        public Builder copy(Airline airline)
        {
            this.ID=airline.getID();
            this.name=airline.getAirlineName();
            this.nationality=airline.getNationality();
            this.aircrafts=airline.getAircrafts();
            return this;
        }

        public Airline build()
        {
            return new Airline(this);
        }
    }
}
