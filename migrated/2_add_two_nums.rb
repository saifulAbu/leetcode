# Definition for singly-linked list.
#require 'pry'

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
#        binding.pry
        val1 = l1.val
        val2 = l2.val
        sum = val1 + val2 + carry
        resVal = sum % 10
        carry = sum / 10
        tail = insert_back(tail, resVal)
        l1 = l1.next
        l2 = l2.next
    end

    if l1.nil?
        insert_rest_back(l2, tail, carry)
    else
        insert_rest_back(l1, tail, carry)
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

def insert_rest_back(list_rest, result_tail, carry)
    until list_rest.nil?
        val = carry + list_rest.val
        carry = val / 10
        val = val % 10
        result_tail = insert_back(result_tail, val)
        list_rest = list_rest.next
    end

    unless carry == 0
        insert_back(result_tail, carry)
    end
    result_tail
end

head = nil
head = insert_front(head, 3)
head = insert_front(head, 4)
head = insert_front(head, 2)
l1 = head

head = nil
head = insert_front(head, 7)
head = insert_front(head, 5)
head = insert_front(head, 7)
l2 = head


p add_two_numbers(l1, l2)
