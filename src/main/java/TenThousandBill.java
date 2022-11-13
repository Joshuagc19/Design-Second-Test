import java.util.List;

public class TenThousandBill extends BillHandler{
    private int availability;

    public TenThousandBill(int availability) {
        this.availability = availability;
    }

    @Override
    public void handle(int request, List<int[]> result) {
        int billsNeeded = request % 10000;
        int rest = request - (billsNeeded * 10000);

        if(billsNeeded > availability){
            int restBills = billsNeeded - availability;
            availability = 0;
            rest += restBills * 10000;
        }

        if(next == null){
            if(rest != 0){
                System.out.println("The ATM could not fulfill the requested amount with the available bills.");
            }else{
                if (billsNeeded != 0) result.add(new int[]{10000, billsNeeded});
            }
        }else {
            if (billsNeeded != 0) result.add(new int[]{10000, billsNeeded});
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
