package trees;

import java.util.Optional;

public class LevelNodePair {
    public final Optional<SdaTree> node;
    public final int level;

    public LevelNodePair(SdaTree node, int level) {
        this.node = Optional.ofNullable(node);
        this.level = level;
    }
}
