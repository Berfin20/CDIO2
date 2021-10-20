public class Terning {
   private int faceValue;
   private int faceValueSum;

    @Override
    public String toString() {
        return "Terningeslaget er:" + faceValue;

    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public int getFaceValueSum() {
        return faceValueSum;
    }

    public void setFaceValueSum(int faceValueSum) {
        this.faceValueSum = faceValueSum;
    }
    public TerningePar diceRoll (){
        Terning terning1 = new Terning();
        Terning terning2 = new Terning();

        terning1.setFaceValue((int)(Math.random()*6)+1);
        terning2.setFaceValue ((int)(Math.random()*6)+1);

        setFaceValueSum(terning1.getFaceValue()+terning2.getFaceValue());
        return new TerningePar (terning1.getFaceValue(), terning2.getFaceValue());




    }

    private static class TerningePar {

        private int t1;
        private int t2;

        @Override
        public String toString() {
            return t1+ " og "+t2;
        }

        public TerningePar (int t1, int t2){

            this.t1=t1;
            this.t2=t2;

            
        }
    }
}
