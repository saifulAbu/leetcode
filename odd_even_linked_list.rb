# Definition for singly-linked list.
 class ListNode
     attr_accessor :val, :next
     def initialize(val = 0, _next = nil)
         @val = val
         @next = _next
     end
 end

# @param {ListNode} head
# @return {ListNode}
def odd_even_list(head)

end

head = ListNode.new(6)

5.downto(1) do
  |i|
  head = ListNode.new(i, head)
end

p head
#res = odd_even_list