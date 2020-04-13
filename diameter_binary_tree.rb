require 'pry'
require 'pry-nav'

# Definition for a binary tree node.
 class TreeNode
     attr_accessor :val, :left, :right
     def initialize(val)
         @val = val
         @left, @right = nil, nil
     end
 end

# @param {TreeNode} root
# @return {Integer}
def diameter_of_binary_tree(root)
  return 0 if root.nil?
  max_path_len_so_far, max_path_len_through = get_max root
  max_path_len_so_far
end

def get_max(root)
  return [0, 0] if (root.left.nil? and root.right.nil?)

  max_path_len_through = 0
  max_path_len_so_far = 0

  left_max = 0
  right_max = 0

  unless root.left.nil?
    max_path_len_so_far, left_max = get_max(root.left)
    left_max += 1
  end

  unless root.right.nil?
    temp_max_path_len_so_far, right_max = get_max(root.right)
    right_max += 1
    max_path_len_so_far = temp_max_path_len_so_far if temp_max_path_len_so_far > max_path_len_so_far
  end

  max_path_len_through = left_max + right_max

  max_path_len_so_far = max_path_len_through if max_path_len_through > max_path_len_so_far
 # puts "#{root.val} : #{max_path_len_through}"
  return [max_path_len_so_far, [left_max, right_max].max]
end

node1 = TreeNode.new 1
node2 = TreeNode.new 2
node3 = TreeNode.new 3
node4 = TreeNode.new 4
node5 = TreeNode.new 5

node1.left = node2
node1.right = node3
node2.left = node4
node2.right = node5

puts diameter_of_binary_tree node1