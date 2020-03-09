# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @return {Float}
def find_median_sorted_arrays(nums1, nums2)

end

=begin
solution idea
=====================
num1 = [1,6,8,9,10,11]
num2 = [2,4,5,6,9]

similar to idea of binary search
num1 has size m
num2 has size n
find the element that will be on index
  (m + n) / 2 - 1 if both the sorted arrays are combined when m+n is odd
  (m + n) / 2 -1 and (m+n)/2 when m+n is even


find()
=end

=begin
  possibilities
   when total size is odd
      median is in num1
      median is not in num1
   when total size even
      median1, median2 in num1
      median1 in num1
      median not in num1

  in num1 do binary search with start_index = 0, end_index = num1.size - 1
  find the rank of mid_index = (start_index + end_index) / 2
    if rank == median return the median
    if rank > median_rank search left portion of num1
    if rank < median_rank search right portion of num1
    stop when start_index = end_index
    check the rank of the element where start_index = end_index, this is the final_index, final_rank

    if total_number == odd
      if final_rank == median_rank, median is found in num1
      else search for median_rank on num2
    if total_number == even
      if final_rank == median_rank_1
        rank_of_nex_elem = rank_of num1[final_index+1]
        if rank_of_nex_elem = median_rank_2
          median found on num1
        else search for rank2 on num2
      else if final_rank == median_rank2
        rank_of_prev_elem = rank_of num1[final_index-1]
        if rank_of_prev_elem == median_rank_1
          median found on num1
        else search for rank1 on num2
      else
        both median on num2
        median_index_1 = search for median_rank_1 on num2
        median_index_2 = median_index_1 + 1
        median found on num2
     end
=end