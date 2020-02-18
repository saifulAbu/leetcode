# Definition for singly-linked list.
class ListNode
   attr_accessor :val, :next
   def initialize(val)
       @val = val
       @next = nil
   end
end

# @param {ListNode} l1
# @param {ListNode} l2
# @return {ListNode}
def add_two_numbers(l1, l2)

end


head = ListNode.new(3)
prev = ListNode.new(4)
prev.next = head
head = prev
prev = ListNode.new(2)
prev.next = head
head = prev
l1 = head

