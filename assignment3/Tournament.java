import java.util.*;

class Team {
    private String name;
    private int matchesPlayed, wins, losses, points;

    public Team(String name) {
        this.name = name;
    }

    public void recordMatch(boolean win) {
        matchesPlayed++;
        if (win) {
            wins++;
            points += 2;
        } else {
            losses++;
        }
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return name + " | Matches: " + matchesPlayed + " | Wins: " + wins +
               " | Losses: " + losses + " | Points: " + points;
    }
}

public class Tournament {
    public static void main(String[] args) {
        List<Team> teams = new ArrayList<>();

        Team t1 = new Team("Team A");
        Team t2 = new Team("Team B");
        Team t3 = new Team("Team C");

        t1.recordMatch(true);
        t1.recordMatch(false);
        t2.recordMatch(true);
        t3.recordMatch(false);

        teams.add(t1);
        teams.add(t2);
        teams.add(t3);

        teams.sort((a, b) -> b.getPoints() - a.getPoints());

        for (Team t : teams) {
            System.out.println(t);
        }
    }
}