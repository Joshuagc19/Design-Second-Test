import java.util.List;

public class TwoThousandBill extends  BillHandler{
    private int availability;

    public TwoThousandBill(int availability) {
        this.availability = availability;
    }

    @Override
    public void handle(int request, List<int[]> result) {
        int billsNeeded = request % 2000;
        int rest = request - (billsNeeded * 2000);

        if(billsNeeded > availability){
            int restBills = billsNeeded - availability;
            availability = 0;
            rest += restBills * 2000;
        }

        if(next == null){
            if(rest != 0){
                System.out.println("The ATM could not fulfill the requested amount with the available bills.");
            }else{
                if (billsNeeded != 0) result.add(new int[]{2000, billsNeeded});
            }
        }else {
            if (billsNeeded != 0) result.add(new int[]{2000, billsNeeded});
            next.handle(rest, result);
        }
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
