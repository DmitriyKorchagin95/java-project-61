package hexlet.code.games;

import hexlet.code.util.Round;

public interface Game {

    String getRule();
    Round nextRound();
}
