# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end
# @param {TreeNode} root
# @return {Integer}
def count_nodes(root)
  return 0 if root.nil?
  count = 1
  if !root.left.nil?
    count += count_nodes(root.left)
  end

  if !root.right.nil?
    count += count_nodes(root.right)
  end

  return count
end

