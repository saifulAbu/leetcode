package trees;

import java.util.ArrayList;
import java.util.Arrays;

public class SerializeAndDeserializeBST_449 {


  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {

    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    serializerHelper(root, sb);
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }

  private void serializerHelper(TreeNode root, StringBuilder sb) {
    sb.append(root.val);
    sb.append(',');
    if (root.left != null) {
      serializerHelper(root.left, sb);
    }
    if (root.right != null) {
      serializerHelper(root.right, sb);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.isEmpty()) {
      return null;
    }
    ArrayList<String> ser = new ArrayList<>(Arrays.asList(data.split(",")));

    return deserializeHelper(ser, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private TreeNode deserializeHelper(ArrayList<String> ser, int minValue, int maxValue) {
    if (ser.isEmpty()) {
      return null;
    }
    int curVal = Integer.parseInt(ser.get(0));
    if (curVal < minValue || curVal > maxValue) {
      return null;
    }
    ser.remove(0);
    TreeNode r = new TreeNode(curVal);
    r.left = deserializeHelper(ser, minValue, curVal);
    r.right = deserializeHelper(ser, curVal, maxValue);
    return r;
  }

  public static void main(String args[]) {
    TreeNode n5 = new TreeNode(5);
    TreeNode n3 = new TreeNode(3);
    TreeNode n6 = new TreeNode(6);
    TreeNode n2 = new TreeNode(2);
    TreeNode n4 = new TreeNode(4);
    TreeNode n9 = new TreeNode(9);
    n5.left = n3;
    n5.right = n6;

    n3.left = n2;
    n3.right = n4;
    n6.right = n9;

    SerializeAndDeserializeBST_449 sd = new SerializeAndDeserializeBST_449();
    String ser = sd.serialize(null);
    System.out.println(ser);
    TreeNode tt = sd.deserialize(ser);
    ser = sd.serialize(tt);
    System.out.println(ser);

  }

}
