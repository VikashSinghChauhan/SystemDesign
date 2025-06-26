public class IdleState implements MachineState{
    @Override
    public void selectItem(VendingMachine context, String itemCode) {
        System.out.println("Item selected: " + itemCode);
        context
    }

    @Override
    public void insertCoin(VendingMachine context, double amount) {

    }

    @Override
    public void dispenseItem(VendingMachine context) {

    }
}
