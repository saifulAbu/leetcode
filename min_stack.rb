class MinStack
  def initialize()
    @val = []
    @min = []
  end

  def push(x)
    @val.push x
    cur_min = @min.last
    cur_min = Float::INFINITY if cur_min.nil?
    if x < cur_min
      cur_min = x
    end
    @min.push cur_min
  end

  def pop()
    @min.pop
    @val.pop
  end

  def top()
    @val.last
  end

  def get_min()
    @min.last
  end
end

# Your MinStack object will be instantiated and called as such:
obj = MinStack.new()

obj.push(-2)
obj.push(0)
obj.push(-3)

puts obj.get_min
puts obj.pop
puts obj.top
puts obj.get_min
