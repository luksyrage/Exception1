package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {
       private Integer roomNumber;
       private Date checkIn;
       private Date checkOut;
       
       private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }
    
    public Date getCheckOut() {
        return checkOut;
    }
    
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public String updateDates (Date chackIn, Date checkOut){
        Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)){
                return "must be in future";
            } if (!checkOut.after(checkIn)){
                return "must be after";
            }
        this.checkIn = chackIn;
        this.checkOut = checkOut;
        return null;
    }
    
    @Override
    public String toString(){
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights.";
            
    }
}
