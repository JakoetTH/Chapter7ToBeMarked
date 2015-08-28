package Airline.conf;

import Airline.domain.Pilot;
/**
 * Created by student on 2015/04/26.
 */
public class PilotFactory {

    public static Pilot createPilot(String firstName,
                                            String lastName,
                                            String address,
                                            String contact,
                                            String rank)
    {
        Pilot pilot = new Pilot
                .Builder(firstName)
                .lastName(lastName)
                .address(address)
                .contact(contact)
                .rank(rank)
                .build();
        return pilot;
    }
}
