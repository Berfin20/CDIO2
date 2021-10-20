public class Felt {

    private String name;
    private int influenceOnBalance;
    private boolean extraTurn;
    private int position;

    public Felt(String name, int influenceOnBalance, boolean extraTurn, int position){
        this.name = name;
        this.influenceOnBalance = influenceOnBalance;
        this.extraTurn = extraTurn;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInfluenceOnBalance() {
        return influenceOnBalance;
    }

    public void setInfluenceOnBalance(int influenceOnBalance) {
        this.influenceOnBalance = influenceOnBalance;
    }

    public boolean getExtraTurn() {
        return extraTurn;
    }

    public void setExtraTurn(boolean extraTurn) {
        this.extraTurn = extraTurn;
    }


}
