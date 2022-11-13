import java.util.List;

abstract public class BillHandler implements BillDenomination{
    protected BillDenomination next;

    public BillHandler() {
    }

    public void setNext(BillDenomination next){
        this.next = next;
    }

    abstract public void handle(int request, List<int[]> rest) ;

}
