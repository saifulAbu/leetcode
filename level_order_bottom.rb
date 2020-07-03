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
# @return {Integer[][]}
def level_order_bottom(root)
 # binding.pry
  return [] if root.nil?
  map = Hash.new() {|k| []}
  traverse_and_build(0, map, root)
  map.values.reverse
end

def traverse_and_build(level, map, root)
  map[level] = map[level] << root.val
  unless root.left.nil?
     traverse_and_build(level+1, map, root.left)
  end

  unless root.right.nil?
     traverse_and_build(level+1, map, root.right)
  end
end

one = TreeNode.new(1)
two = TreeNode.new(2)
three = TreeNode.new(3)
four = TreeNode.new(4)
five = TreeNode.new(5)
six = TreeNode.new(6)

one.left = two
one.right = three
two.left = four
two.right = five
three.left = six

puts one
p level_order_bottom(one)