class Solution
=begin
    :type w: Integer[]
=end
  def initialize(w)
    @range_bucket = Array.new(w.size)
    total_sum = 0.0

    for weight in w
      total_sum += weight
    end

    lower_bound = 0.0
    upper_bound = 0.0
    for i in (0..(w.size-1)) do
      @range_bucket[i] = [lower_bound, upper_bound]
      lower_bound = upper_bound
    end
    p @range_bucket
  end
=begin
    :rtype: Integer
=end
  def pick_index()
    rand_num = rand
    index = 0
    s = 0
    e = @range_bucket.size - 1
    while(s <= e)
      m = s + (e - s) / 2
     # puts "s: #{s}, m:#{m}, e:#{e}"
      cur_bound = @range_bucket[m]
      if(rand_num >= cur_bound[0] and rand_num <= cur_bound[1])
        index = m
        break
      elseif (rand_num < cur_bound[0])
        e = m - 1
      else
        s = m + 1
      end
    end
    puts index
    return index
  end
end

# Your Solution object will be instantiated and called as such:
w = [1, 2, 3]
obj = Solution.new(w)
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
param_1 = obj.pick_index()
