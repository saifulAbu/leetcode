# Definition for singly-linked list.
class ListNode
  attr_accessor :val, :next
  def initialize(val)
    @val = val
    @next = nil
  end
end

# @param {ListNode} node
# @return {Void} Do not return anything, modify node in-place instead.
def delete_node_inefficient(node)
  front = node
  back = node.next
  until back.next.nil?
    #puts back.val
    front.val = back.val
    front = back
    back = back.next
  end
  front.val = back.val
  front.next = nil
  node
end

def delete_node(node)
  node.val = node.next.val
  node.next = node.next.next
end

n1 = ListNode.new(1)
n2 = ListNode.new(2)
n3 = ListNode.new(3)

n1.next = n2
n2.next = n3

p delete_node n2