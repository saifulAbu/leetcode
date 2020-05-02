require 'pry'
require 'pry-nav'

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
# @return {Integer}
def max_path_sum(root)
  max_through, max_so_far = max_path_sum_helper(root)
  max_so_far
end

def max_path_sum_helper(root)
  left = 0
  right = 0
  max_known_to_child = -Float::INFINITY
  unless root.left.nil?
    left, max_known_to_child = max_path_sum_helper(root.left)
  end

  unless root.right.nil?
    right, max_child_know = max_path_sum_helper(root.right)
    #binding.pry
    max_known_to_child = max_child_know if max_known_to_child < max_child_know
  end

  max_incomplete_through_root = [left, right].max + root.val
  max_complete_through_root = left +  right + root.val

  [[max_incomplete_through_root, root.val].max, [max_incomplete_through_root, max_complete_through_root, max_known_to_child, root.val].max]
end

n1 = TreeNode.new(2)
n2 = TreeNode.new(-1)
n3 = TreeNode.new(-2)
n1.left = n2
n1.right = n3

p max_path_sum n1