package trees;

import java.util.Optional;

public class LevelNodePair {
    public final Optional<SdaTree> node;
    public final int index;

    public LevelNodePair(SdaTree node, int index) {
        this.node = Optional.ofNullable(node);
        this.index = index;
    }
}
