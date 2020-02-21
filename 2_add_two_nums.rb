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
    h1 = l1
    h2 = l2
    if l1.nil? && !l2.nil?
        return l2
    elsif !l1.nil? && l2.nil?
        return l1
    elsif l1.nil? && l2.nil?
        return nil
    end

    res_list = ListNode.new(-1)
    tail = res_list
    carry = 0
    until l1.nil? or l2.nil?
        val1 = h1.val
        val2 = h2.val
        sum = val1 + val2 + carry
        resVal = sum % 10
        carry = sum / 10
        tail = insert_back(tail, resVal)
        l1 = l1.next
        l2 = l2.next
    end
    res_list.next
end

def insert_front(head, value)
    node = ListNode.new(value)
    node.next = head
    return node
end

def insert_back(tail, value)
    node = ListNode.new(value)
    tail.next = node
    return node
end

head = nil
head = insert_front(head, 3)
head = insert_front(head, 4)
head = insert_front(head, 2)
l1 = head

head = nil
head = insert_front(head, 1)
head = insert_front(head, 0)
head = insert_front(head, 2)
l2 = head


p add_two_numbers(l1, l2)


=begin
l1 = head
until l1.nil?
    puts l1.val
    l1 = l1.next
end

head = ListNode.new(3)
prev = ListNode.new(4)
prev.next = head
head = prev
prev = ListNode.new(2)
prev.next = head
head = prev
l1 = head
=end
