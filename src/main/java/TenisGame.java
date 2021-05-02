import java.util.HashMap;
import java.util.Map;



public class TenisGame {
    String player1Scores;
    String player2Scores;
    HashMap<Number, String> scorePlay;

    public TenisGame() {
        this.scorePlay = new HashMap<Number, String>();
        this.scorePlay.put(0,"Love");
        this.scorePlay.put(1,"Fifteen");
        this.scorePlay.put(2,"Thirty");
        this.scorePlay.put(3,"Forty");
        this.scorePlay.put(4,"Game");
        this.player1Scores = this.scorePlay.get(0);
        this.player2Scores = this.scorePlay.get(0);;
    }

    public String score() {
        if (sameScore()) {
            if(this.player1Scores == scorePlay.get(3)){
                return "Deuce";
            }

            return "love - all";
        }

        String player1Scores1 = getScore();
        if (player1Scores1 != null) return player1Scores1;
        switch (this.player2Scores) {
            case "Advantage Player2":
                return this.player2Scores;
            case "Game":
                return  this.player2Scores+ " Player2";
        }

        return this.player1Scores+" - "+this.player2Scores;
    }

    private String getScore() {
        switch (this.player1Scores) {
            case "Advantage Player1":
                return this.player1Scores;
            case "Game":
                return  this.player1Scores+" Player1";
        }
        return null;
    }

    private boolean sameScore() {
        return this.player1Scores == this.player2Scores;
    }

    public void  player1Scores() {
        if(this.player1Scores == scorePlay.get(3) && this.player2Scores == scorePlay.get(3)){
            this.player1Scores = "Advantage Player1";
        }
        else if (this.player2Scores.equals("Advantage Player2")){
            this.player2Scores = this.scorePlay.get(3);
        }
        else if (this.player1Scores.equals("Advantage Player1")){
            this.player1Scores = this.scorePlay.get(4);
        }
        else {
            this.player1Scores = this.scorePlay.get(getKey(this.player1Scores)+1);

        }
    }

    public void player2Scores() {
        if(this.player2Scores == scorePlay.get(3) && this.player1Scores == scorePlay.get(3)){
            this.player2Scores = "Advantage Player2";
        }
        else if (this.player1Scores.equals("Advantage Player1")){
            this.player1Scores = this.scorePlay.get(3);
        }
        else if (this.player2Scores.equals("Advantage Player2")){
            this.player2Scores = this.scorePlay.get(4);
        }
        else {
            this.player2Scores = this.scorePlay.get(getKey(this.player2Scores)+1);
        }
           }

    private int getKey(String p) {
        return (int) getKey(this.scorePlay, p);
    }


    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        return map.entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

}
