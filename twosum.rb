# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
    val_map = {}
    nums.each_with_index do
        |v, i|
        val_map[v] = i
    end
    
    res = []
    a = nums.each_with_index do
        |v, i|
        num2 = target - v
        puts "#{v}, #{num2}"
        if !val_map[num2].nil?
            i2 = val_map[num2]
            res = [i, i2]
            return
        end
    end
end
