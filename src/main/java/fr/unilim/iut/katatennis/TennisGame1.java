
package fr.unilim.iut.katatennis;

public class TennisGame1 implements TennisGame {

	private int scoreJoueur1 = 0;
	private int scoreJoueur2 = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName.equals( this.player1Name))
			scoreJoueur1 += 1;
		if (playerName.equals( this.player2Name))
			scoreJoueur2 += 1;
	}

	public String getScore() {
		StringBuilder score = new StringBuilder("");

		if (scoreJoueur1 == scoreJoueur2) {
			egalite(score);
		} else if (scoreJoueur1 >= 4 || scoreJoueur2 >= 4) {
			tieBreak(score);
		} else {
			scoreDifferent(score);
		}
		return score.toString();
	}

	private void scoreDifferent(StringBuilder score) {
		int tempScore;
		for (int i = 1; i < 3; i++) {
			if (i == 1)
				tempScore = scoreJoueur1;
			else {
				score.append("-");
				tempScore = scoreJoueur2;
			}
			switch (tempScore) {
			case 0:
				score.append("Love");
				break;
			case 1:
				score.append("Fifteen");
				break;
			case 2:
				score.append("Thirty");
				break;
			case 3:
				score.append("Forty");
				break;
			default:
				score.append("Love");
				break;
			}
		}
	}

	private void egalite(StringBuilder score) {
		switch (scoreJoueur1) {
		case 0:
			score.append("Love-All");
			break;
		case 1:
			score.append("Fifteen-All");
			break;
		case 2:
			score.append("Thirty-All");
			break;
		default:
			score.append("Deuce");
			break;

		}
	}

	private void tieBreak(StringBuilder score) {
		int minusResult = scoreJoueur1 - scoreJoueur2;
		if (minusResult == 1)
			score.append("Advantage player1");
		else if (minusResult == -1)
			score.append("Advantage player2");
		else if (minusResult >= 2)
			score.append("Win for player1");
		else
			score.append("Win for player2");
	}
}