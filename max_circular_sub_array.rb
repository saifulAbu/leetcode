# @param {Integer[]} a
# @return {Integer}
def max_subarray_sum_circular(a)
  max_elem = a.max
  return max_elem if max_elem < 0
  kadane_result = max_sub_array_kadane(a)
  w_result = wrapped_result(a)
  return [kadane_result, w_result].max
end

def wrapped_result(a)
  arr_sum = a.sum
  for i in (0..(a.size-1))
    a[i] = a[i] * -1
  end
  kadane_result = max_sub_array_kadane(a)
  arr_sum + kadane_result
end



def max_sub_array_kadane(arr)
  max_sum = arr.max
  cur_sum = 0
  arr.each do
    |e|
    cur_sum = cur_sum + e
    if cur_sum < 0
      cur_sum = 0
    end
    if cur_sum > max_sum
      max_sum = cur_sum
    end
  end
  max_sum
end

=begin
a = [0, 1, 2]
c = [0, 1, 2, 0, 1, 2, 0, 1, 2....]
c[i] = a[(i + a.len) % a.len]

a valid sub subarray, s cannot contain same a[i] twice
[0, 1, 2], [1, 2, 0], [2, 0, 1] are valid sub array of length 3

s = c[i], c[i+1], ... such that c[i] = a[j] does not appear twice

day 1: little clue
=end

a = [3, -20, 3, -5, 6, 4]

p max_subarray_sum_circular a