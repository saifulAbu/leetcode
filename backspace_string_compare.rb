require 'pry'
require 'pry-nav'

class DoublyListNode
   attr_accessor :val, :next, :prev
   def initialize(val)
       @val = val
       @next = nil
       @prev = nil
   end

   def add(val)
    node = DoublyListNode.new val

    node.next = @next
    node.prev = self

    node.next.prev = node unless node.next.nil?
    @next = node
   end
end

# @param {String} s
# @param {String} t
# @return {Boolean}
def backspace_compare(s, t)
  str_s = process_string s
  str_t = process_string t
  str_s == str_t
end

def process_string(s)
  head = DoublyListNode.new(Float::INFINITY)
  reversed = s.reverse
  reversed.each_char do
    |char|
    head.add char
  end

  cur = head.next
  #binding.pry
  until cur.nil?
    if cur.val == "#"
      prev = cur.prev
      if prev != head
        prev = prev.prev
      end

      prev.next = cur.next
      prev.next.prev = prev unless prev.next.nil?
    end

    cur = cur.next
  end

  str = ""
  cur = head.next
  until cur.nil?
    str =  str + cur.val
    cur = cur.next
  end
  str
end

puts backspace_compare "ab##c", "ad#c"