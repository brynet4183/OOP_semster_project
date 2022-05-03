package data;

import Models.Team;

public interface Where<V> {
    Boolean run(V model);
}
