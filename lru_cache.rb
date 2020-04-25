class LRUCache
  attr_accessor :list, :map

  class Node
    attr_accessor :next, :prev, :key, :value

    def initialize(key, val)
      @key = key
      @value = val
      @next = nil
      @prev = nil
    end
  end

  class DList
    attr_accessor :head

    def initialize()
      @head = Node.new("dummy-key", "dummy-val")
      @tail = @head
    end

    def add_front(node)
      if @head.next.nil?
        @tail = node
        @head.next = node
        node.prev = @head
      else
        node.next = @head.next
        node.next.prev = node
        node.prev = @head
        @head.next = node
      end
    end

    def remove_last()
      return nil if @head == @tail
      node = @tail
      @tail = @tail.prev
      @tail.next = nil
      node.prev = nil
      node
    end

    def remove_node(node)
      if node != @tail
        prev = node.prev
        next_node = node.next
        prev.next = next_node
        next_node.prev = prev
        node.next = nil
        node.prev = nil
        node
      else
        remove_last
      end
    end
  end

=begin
    :type capacity: Integer
=end
    def initialize(capacity)
      @size = 0
      @capacity = capacity
      @list = DList.new
      @map = {}
    end


=begin
    :type key: Integer
    :rtype: Integer
=end
    def get(key)
      node = @map[key]
      return -1 if node.nil?
      @list.remove_node(node)
      @list.add_front(node)
      return node.value
    end


=begin
    :type key: Integer
    :type value: Integer
    :rtype: Void
=end
    def put(key, value)
      node = @map[key]
      if node.nil?
        if @size == @capacity
          node = @list.remove_last()
          @map.delete(node.key)
          node.key = key
          node.value = value
          @list.add_front(node)
          @map[key] = node
        else
          node = Node.new(key, value)
          @list.add_front(node)
          @map[key] = node
          @size += 1
        end
      else
        @list.remove_node(node)
        node.value = value
        @list.add_front(node)
      end
    end

    def print
      head = list.head.next
      until head.nil?
        printf "[#{head.key}:#{head.value}]->"
        head = head.next
      end
      printf "nil"
      puts

      #print map values
      @map.keys.each do
        |key|
        printf "[#{key}:#{@map[key].value}] "
      end
      puts
    end
end

# Your LRUCache object will be instantiated and called as such:
cache = LRUCache.new(2)

cache.put(1, 1);
cache.put(2, 2);
puts cache.get(1);       # returns 1
cache.put(3, 3);    # evicts key 2
puts cache.get(2);       # returns -1 (not found)
cache.put(4, 4);    # evicts key 1
puts cache.get(1);       # returns -1 (not found)
puts cache.get(3);       # returns 3
puts cache.get(4);       # returns 4