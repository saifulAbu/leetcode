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
  even_head = ListNode.new("dummy")
  even_tail = even_head
  odd_head = ListNode.new("dummy")
  odd_tail = odd_head
  cur_node_number = 1
  cur_head = head

  until cur_head.nil?
    cur_node = cur_head
    cur_head = cur_head.next
    cur_node.next = nil

    if cur_node_number.even?
      even_tail.next = cur_node
      even_tail = cur_node
    else
      odd_tail.next = cur_node
      odd_tail = cur_node
    end

    cur_node_number += 1
  end

  result = odd_head.next
  odd_tail.next = even_head.next
  result
end

head = ListNode.new(6)

5.downto(1) do
  |i|
  head = ListNode.new(i, head)
end

res = odd_even_list head
p res