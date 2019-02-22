package lab2.election;

public class Bulletin {
    private String[] candidates = new String[]{
            "Poroshenko", "Tymoshenko", "Lashko", "Tigipko"
    };

    public void display(){
        System.out.println("Candidates: " + candidates);
    }

    public void displayVote(String cand, int numCand){
        System.out.println("Votes for candidate " + cand +": " + numCand);
    }
}
