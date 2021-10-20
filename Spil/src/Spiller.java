public class Spiller {
    private String name;
    private int position;
    Konto konto = new Konto();
    Terning terninger = new Terning();

    public Spiller (String name, int balance, int position) {
        this.name = name;
        this.konto.setBalance(balance);
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int updatePosition(int facevalues, int currentPosition){
        int newPosition;
        newPosition = facevalues+currentPosition;
        setPosition(newPosition);

        return position;
    }
}
