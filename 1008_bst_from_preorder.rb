# Definition for a binary tree node.
class TreeNode
     attr_accessor :val, :left, :right
     def initialize(val)
         @val = val
         @left, @right = nil, nil
     end
 end

# @param {Integer[]} preorder
# @return {TreeNode}
def bst_from_preorder(preorder)
  return nil if preorder.empty?
  val = preorder.shift

  left = []
  right = []
  preorder.each do
    |elem|
    if elem < val
      left << elem
    else
      right << elem
    end
  end

  node = TreeNode.new(val)
  node.left = bst_from_preorder(left)
  node.right = bst_from_preorder(right)
  return node
end

p bst_from_preorder([])
p bst_from_preorder([8,5,1,7,10,12])

//afads

## freaking more dummy
# more
# some more
# hellp
# move
# peace
# peace
# patience
# help
# ok
# ok
