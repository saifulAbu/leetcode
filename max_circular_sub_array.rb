# @param {Integer[]} a
# @return {Integer}
def max_subarray_sum_circular(a)

end


=begin
a = [0, 1, 2]
c = [0, 1, 2, 0, 1, 2, 0, 1, 2....]
c[i] = a[(i + a.len) % a.len]

a valid sub subarray, s cannot contain same a[i] twice
[0, 1, 2], [1, 2, 0], [2, 0, 1] are valid sub array of length 3

s = c[i], c[i+1], ... such that c[i] = a[j] does not appear twice


=end
