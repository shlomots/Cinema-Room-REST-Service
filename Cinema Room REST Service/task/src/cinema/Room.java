package cinema;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Room {
    private ArrayList<Seats> seats = new ArrayList<>();
    private LinkedHashMap<String, Integer> statistics = new LinkedHashMap<>();
    private ConcurrentHashMap<UUID, Seats> tokenToSeat = new ConcurrentHashMap<>();

    private String super_secret;

    public Room(String password) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                seats.add(new Seats(i, j));
            }
        }
        statistics.put("current_income", 0);
        statistics.put("number_of_available_seats", 81);
        statistics.put("number_of_purchased_tickets", 0);
        super_secret = password;

    }
    public ArrayList<Seats> getSeats() {
        return seats;
    }

    public ArrayList<Seats> getAvailableSeats(){
        ArrayList<Seats> availableSeats = new ArrayList<>();
        for(int i = 0 ; i < seats.size() ; i++){
            if(!seats.get(i).isPurchased()){
                availableSeats.add(seats.get(i));
            }
        }
        return availableSeats;
    }

    public ConcurrentHashMap<UUID, Seats> getTokenToSeat() {
        return tokenToSeat;
    }

    public LinkedHashMap<String, Integer> getStatistics() {
        return statistics;
    }

    public void setSeats(ArrayList<Seats> seats) {
        this.seats = seats;
    }

    public String getSuper_secret() {
        return super_secret;
    }

    public void setSuper_secret(String super_secret) {
        this.super_secret = super_secret;
    }

    public void addToStatistics(Seats seat){
        statistics.put("current_income" , statistics.get("current_income") + seat.getPrice());
        statistics.put("number_of_available_seats" , statistics.get("number_of_available_seats") - 1);
        statistics.put("number_of_purchased_tickets" , statistics.get("number_of_purchased_tickets") + 1);
    }

    public void subtractFromStatistics(Seats seat){
        statistics.put("current_income" , statistics.get("current_income") - seat.getPrice());
        statistics.put("number_of_available_seats" , statistics.get("number_of_available_seats") + 1);
        statistics.put("number_of_purchased_tickets" , statistics.get("number_of_purchased_tickets") - 1);
    }

}
