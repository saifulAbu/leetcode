# @param {Integer[]} nums
   # @return {Integer}
   def single_number(nums)
     num_map = Hash.new false
     sum = 0
     nums.each do
       |num|
       if num_map[num]
         sum -= num
       else
         num_map[num] = true
         sum += num
       end
     end
     sum
   end

puts single_number [4,1,2,1,2]