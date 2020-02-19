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

def insert_front(head, value)
    node = ListNode.new(value)
    node.next = head
    return node
end

head = nil
head = insert_front(head, 3)
head = insert_front(head, 4)
head = insert_front(head, 2)

p head

l1 = head

until l1.nil?
    puts l1.val
    l1 = l1.next
end

=begin
head = ListNode.new(3)
prev = ListNode.new(4)
prev.next = head
head = prev
prev = ListNode.new(2)
prev.next = head
head = prev
l1 = head
=end
