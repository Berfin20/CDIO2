import java.util.ArrayList;

public class Felt {

    private String name;
    private int influenceOnBalance;
    private boolean extraTurn;
    private int position;
    private int id;


    public Felt(int id, String name, int influenceOnBalance, boolean extraTurn, int position){
        this.id = id;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
