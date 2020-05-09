require "ostruct"

# Definition for a binary tree node.
class TreeNode
  attr_accessor :val, :left, :right
  def initialize(val = 0, left = nil, right = nil)
    @val = val
    @left = left
    @right = right
  end
end
# @param {TreeNode} root
# @param {Integer} x
# @param {Integer} y
# @return {Boolean}
def is_cousins(root, x, y)
  return false if root.nil?
  return false if root.val == x or root.val == y
  return false if root.left.nil? or root.right.nil?

  x_info = find_val(root, nil, 0, x)
  return false if x_info.nil?
  y_info = find_val(root, nil, 0, y)
  return false if y_info.nil?

  return false if x_info.parent == y_info.parent
  return false if x_info.depth != y_info.depth

  return true
end

def find_val(cur_node, parent, depth, search_val)
  cur_val = cur_node.val
  return OpenStruct.new(:parent => parent, :depth => depth) if cur_val == search_val

  if cur_node.left != nil
    res = find_val(cur_node.left, cur_val, depth + 1, search_val)
    return res if res != nil
  end

  if cur_node.right != nil
    res = find_val(cur_node.right, cur_val, depth + 1, search_val)
    return res
  end

  return nil
end

n1 = TreeNode.new(1)
n2 = TreeNode.new(2)
n3 = TreeNode.new(3)
n4 = TreeNode.new(4)
n5 = TreeNode.new(5)

n1.left = n2
n1.right = n3
n2.right = n4
n3.right = n5

p is_cousins(n1, 5, 4)