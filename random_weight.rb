class Solution
=begin
    :type w: Integer[]
=end
  def initialize(w)
    @prob = Array.new(w.size)
    total_sum = 0.0

    for weight in w
      total_sum += weight
    end

    for i in (0..(w.size-1)) do
      @prob[i] = (w[i] / total_sum)
    end
  end
=begin
    :rtype: Integer
=end
  def pick_index()
    rand_num = rand
    cum_prob = 0
    i = 0
    while(i < @prob.size)
      cum_prob += @prob[i]
      break if cum_prob > rand_num
      i += 1
    end
    puts i
    return i
  end
end

# Your Solution object will be instantiated and called as such:
w = [4, 1]
obj = Solution.new(w)
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
