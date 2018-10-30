package trees;

import java.util.*;
import java.util.stream.Collectors;

public class TreePrinter {
    public static List<String> coolPrint(SdaTree node) {
        Integer[] array = saveTreeInArray(node);

        int maxLevel = log(array.length + 2,2) - 1;
        int width = (int) Math.pow(2, maxLevel) * 2 - 1;

        Integer[][] arr = new Integer[maxLevel+1][width];

        for (int i = 0; i < array.length; i++) {
            int levelOfNode = log(i+1,2);
            int indexInLevel = (int) (i - Math.pow(2, levelOfNode) + 1);
            int childLevelCount = maxLevel - levelOfNode;
            int baseOffset = (int) (Math.pow(2, childLevelCount) - 1);
            int betweenNodes = (int) (Math.pow(2, childLevelCount + 1) - 1);
            int x = baseOffset + betweenNodes * indexInLevel + indexInLevel;
            arr[levelOfNode][x] = array[i];
        }

        List<String> withEdges = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            Integer[] currentLevel = arr[i];
            String level = levelToString(width, currentLevel);
            int rowsForEdges = (int) Math.pow(2, maxLevel - i - 1);
            List<String> edges = createEdges(rowsForEdges, currentLevel);
            withEdges.add(level);
            withEdges.addAll(edges);
        }

        return withEdges;
    }

    private static List<String> createEdges(int rowCount, Integer[] level) {
        char[][] edges = new char[rowCount][level.length];
        fillWith(edges, ' ');
        for (int i = 0; i < level.length; i++) {
            if(level[i] != null) {
                addEdges(edges, 0, i-1, i+1);
            }
        }
        return Arrays.stream(edges)
                .map(String::new)
                .collect(Collectors.toList());
    }

    private static void fillWith(char[][] edges, char character) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                edges[i][j] = character;
            }
        }
    }

    private static void addEdges(char[][] edges, int y, int left, int right) {
        if(edges.length == y) {
            return;
        }
        edges[y][left] = '/';
        edges[y][right] = '\\';
        addEdges(edges, y + 1, --left, ++right);
    }

    private static String levelToString(int width, Integer[] integers) {
        StringBuilder level = new StringBuilder();
        for (int j = 0; j < width; j++) {
            if(integers[j] != null) {
                level.append(integers[j]);
            } else {
                level.append(" ");
            }
        }
        return level.toString();
    }

    private static Integer[] saveTreeInArray(SdaTree node) {
        Integer[] array = new Integer[100];
        Queue<LevelNodePair> queue = new ArrayDeque<>();
        queue.offer(new LevelNodePair(node, 0));
        while(!queue.isEmpty()) {
            LevelNodePair pair = queue.poll();
            Optional<SdaTree> optionalCurrentNode = pair.node;
            int index = pair.index;
            if(optionalCurrentNode.isPresent()) {
                SdaTree currentNode = optionalCurrentNode.get();
                array[index] = currentNode.getValue();
                Optional<SdaTree> optionalLeft = currentNode.getLeftChild();
                Optional<SdaTree> optionalRight = currentNode.getRightChild();
                if (optionalLeft.isPresent()) {
                    queue.offer(new LevelNodePair(optionalLeft.get(), 2 * index + 1));
                }
                if (optionalRight.isPresent()) {
                    queue.offer(new LevelNodePair(optionalRight.get(), 2 * index + 2));
                }
            }
        }

        int lastNonEmptyIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null) {
                lastNonEmptyIndex = i;
            }
        }

        Integer[] truncatedArray = Arrays.copyOf(array, lastNonEmptyIndex + 1);

        return truncatedArray;
    }

    private static int log(int x, int base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }
}
