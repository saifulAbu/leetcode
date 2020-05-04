# @param {Integer} num
# @return {Integer}
def find_complement(num)
  binary = to_binary(num)
  complement = get_complement(binary)
  decimal = to_decimal(complement)
end

def to_binary(num)
  return [0] if num == 0
  result = []
  cur = num
  while cur > 0
    bit = cur % 2
    cur = cur / 2
    result.insert(0, bit)
  end
  result
end

def to_decimal(binary_arr)
  result = 0
  binary_arr.each do
    |bit|
    result = result * 2 + bit
  end
  result
end

def get_complement(binary_arr)
  result = Array.new(binary_arr.size)
  for i in (0..(binary_arr.size - 1))do
    if binary_arr[i] == 0
      result[i] = 1
    else
      result[i] = 0
    end
  end
  result
end

#p find_complement(5)
#find_complement(2)
#p find_complement(0)
p find_complement(1)
#b = complement([0, 1, 0])
#p b