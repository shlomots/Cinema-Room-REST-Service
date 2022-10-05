package cinema;
import cinema.Exceptions.*;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


@RestController
public class TaskController {
    Room room = new Room("super_secret");
    @GetMapping("/seats")
    public HashMap<String, Object> returnOne() {
        HashMap<String, Object> output = new HashMap<>();
        output.put("total_rows", 9);
        output.put("total_columns" , 9);
        output.put("available_seats",room.getAvailableSeats());
        return output;
    }

    @PostMapping("/stats")
    public LinkedHashMap<String, Integer> getStatistics(@RequestParam Optional<String> password){
        if(!password.isPresent()){
            throw new WrongPasswordException("The password is wrong!");
        }
        if(!(room.getSuper_secret().equals(password.get()))){
            throw new WrongPasswordException("The password is wrong!");
        }
        return room.getStatistics();
    }

    @PostMapping("/purchase")
    public LinkedHashMap<String, Object> purchaseSeat(@RequestBody PurchaseInfo purchaseInfo){
        LinkedHashMap<String, Object> output = new LinkedHashMap<>();//helps to maintain order
        if(purchaseInfo.getRow() < 0 || 9 < purchaseInfo.getRow() || purchaseInfo.getColumn() < 0 || purchaseInfo.getColumn() > 9){
            throw new SeatOutOfBoundsException("The number of a row or a column is out of bounds!");
        }
        for(int i = 0 ; i < room.getSeats().size(); i++ ){
            Seats seat = room.getSeats().get(i);
            if(seat.getRow() == purchaseInfo.row && seat.getColumn() == purchaseInfo.column){
                if(!seat.isPurchased()){
                    seat.setPurchased();
                    room.addToStatistics(seat);
                    UUID token = UUID.randomUUID();
                    room.getTokenToSeat().put(token, seat);
                    output.put("token", token);
                    output.put("ticket" , seat);
                    return output;
                }else{
                    throw new ThisSeatIsAllreadyBoughtException("The ticket has been already purchased!");
                }
            }

        }
        return null;
    }

    @PostMapping("/return")
    public LinkedHashMap<String, Object> returnSeat(@RequestBody Token token){
        LinkedHashMap<String, Object> output = new LinkedHashMap<>();
        Seats seat = room.getTokenToSeat().remove(token.getToken());
        if(seat==null){
            throw new WrongTokenException("Wrong token!");
        }
        seat.setPurchased();
        room.subtractFromStatistics(seat);
        output.put("returned_ticket", seat);
        return output;
    }



    }





