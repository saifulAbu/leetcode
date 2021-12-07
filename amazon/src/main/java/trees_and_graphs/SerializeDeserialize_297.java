package trees_and_graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserialize_297 {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    List<String> l = new LinkedList<>();
    serializeHelper(root, l);
    return String.join(",", l);
  }

  private void serializeHelper(TreeNode root, List<String> l) {
    if(root == null) {
      l.add("n");
      return;
    }
    l.add(Integer.toString(root.val));
    serializeHelper(root.left, l);
    serializeHelper(root.right, l);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    List<String> dataList = new LinkedList<String>((Arrays.asList(data.split(","))));

    return deserializeHelper(dataList);
  }

  public TreeNode deserializeHelper(List<String>  data) {
    if(data.isEmpty()) {
      return null;
    }
    String val = data.remove(0);
    if(val.equals("n")) {
      return null;
    }
    TreeNode node = new TreeNode(Integer.parseInt(val));
    node.left = deserializeHelper(data);
    node.right = deserializeHelper(data);
    return node;
  }
}
