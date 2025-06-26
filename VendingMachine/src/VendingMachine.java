public class VendingMachine {

    private MachineState currentState;
    private String selectedItem;
    private double insertedAmount;

    public VendingMachine(){
        this.currentState = new IdleState(); //Initial state
    }

    public void setCurrentState(MachineState currentState) {
        this.currentState = currentState;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void setInsertedAmount(double insertedAmount) {
        this.insertedAmount = insertedAmount;
    }

    public void selectIteam(String itemCode)
    {
        currentState.selectItem(this, itemCode);
    }

    public void insertCoin(double amount)
    {
        currentState.insertCoin(this, amount);
    }

    public void dispenseItem(){
        currentState.dispenseItem(this);
    }

    public void reset(){
        this.selectedItem="";
        this.insertedAmount= 0.0;
        this.currentState = new IdleState();
    }
}
