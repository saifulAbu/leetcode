# Definition for singly-linked list.
class ListNode
   attr_accessor :val, :next
   def initialize(val)
       @val = val
       @next = nil
   end

   def add(val)
    node = ListNode.new val
    node.next = @next
    @next = node
   end
end

# @param {ListNode} head
# @return {ListNode}
def middle_node(head)
  size = 0
  cur = head
  until cur.nil?
    cur = cur.next
    size += 1
  end

  middle = (size / 2)
  result = head

  1.upto(middle) do
    result = result.next
  end
  result
end

head = ListNode.new(-1)

5.downto(1) do
  |val|
  head.add val
end

p middle_node head.next

