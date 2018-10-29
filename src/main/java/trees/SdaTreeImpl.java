package trees;

import trees.SdaTree;

import java.util.Objects;
import java.util.Optional;

public class SdaTreeImpl implements SdaTree {

    private final Integer value;
    private SdaTree left;
    private SdaTree right;

    public SdaTreeImpl(Integer value, SdaTree left, SdaTree right) {
        this.value = Objects.requireNonNull(value, "value must not be null");
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Optional<SdaTree> getLeftChild() {
        return Optional.ofNullable(left);
    }

    @Override
    public Optional<SdaTree> getRightChild() {
        return Optional.ofNullable(right);
    }

    @Override
    public void setLeftChild(SdaTree value) {
        this.left = value;
    }

    @Override
    public void setRightChild(SdaTree value) {
        this.right = value;
    }
}