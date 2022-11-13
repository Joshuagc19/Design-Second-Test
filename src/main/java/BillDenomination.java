import java.util.List;

public interface BillDenomination {
    public void setNext(BillDenomination next);
    public void handle(int request, List<int[]> rest);
}
