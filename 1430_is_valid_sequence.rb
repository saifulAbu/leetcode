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
# @param {Integer[]} arr
# @return {Boolean}
def is_valid_sequence(root, arr)
  return false if root.nil? or root.val != arr[0]
  return is_valid_sequence_c(root, arr, 0, arr.size - 1)
end

def is_valid_sequence_c(root, arr, cur_index, max_index)
  is_leaf = false
  is_leaf = true if root.left.nil? and root.right.nil?
  return false if ((cur_index < max_index and is_leaf) or (cur_index == max_index and !is_leaf))
  return true if (cur_index == max_index and is_leaf)

  next_val = arr[cur_index + 1]
  if !root.left.nil? and root.left.val == next_val
     return true if is_valid_sequence_c(root.left, arr, cur_index + 1, max_index)
  end
  if !root.right.nil? and root.right.val == next_val
    return true is_valid_sequence_c(root.right, arr, cur_index + 1, max_index)
  end

  return false
end

root = TreeNode.new 1
arr = [1]

p is_valid_sequence(root, arr)