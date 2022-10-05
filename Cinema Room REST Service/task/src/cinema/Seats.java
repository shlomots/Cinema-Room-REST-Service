package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seats {

    private int row;
    int column;
    private int price;
    @JsonIgnore
    boolean purchased = false;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isPurchased(){
        return purchased;
    }

    public void setPurchased(){
        if (!purchased){
            purchased = true;
        }else{
            purchased = false;
        }

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Seats(int row, int column) {
        this.row = row;
        this.column = column;
        if(row <= 4){
            setPrice(10);
        }else setPrice(8);
    }


}
