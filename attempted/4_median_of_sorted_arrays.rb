def find_median_sorted_arrays(nums1, nums2)
  if nums1.empty?
    return find_median_sorted_array(nums2)
  elsif nums2.empty?
    return find_median_sorted_array(nums1)
  end

  size1 = nums1.size
  size2 = nums2.size
  size_is_odd = ((size1 + size2) % 2 == 1)

  val1 = 0
  val2 = 0

  median1_index = ((size1 + size2) / 2.0).ceil - 1
  median2_index = median1_index + 1

  result_index = find_index_of_rank(nums1, nums2, median1_index)
  if result_index != -1
    val1 = nums1[result_index]
  else
    result_index = find_index_of_rank(nums2, nums1, median1_index)
    val1 = nums2[result_index]
  end

  return val1 / 1.0 if size_is_odd

  result_index = find_index_of_rank(nums1, nums2, median2_index)
  if result_index != -1
    val2 = nums1[result_index]
  else
    result_index = find_index_of_rank(nums2, nums1, median2_index)
    val2 = nums2[result_index]
  end

  return (val1 + val2) / 2.0
end

def find_median_sorted_array(arr)
  size = arr.size
  size_is_odd = ((size % 2) == 1)

  val1 = 0
  val2 = 0

  median1_index = ((size) / 2.0).ceil - 1
  median2_index = median1_index + 1

  val1 = arr[median1_index]
  return val1 / 1.0 if size_is_odd

  val2 = arr[median2_index]
  return (val1 + val2) / 2.0
end

def find_index_of_rank(arr1, arr2, rank)
  size1 = arr1.size
  size2 = arr2.size

  start_index = 0
  end_index = size1 - 1

  while start_index <= end_index
    mid_index = (start_index + end_index) / 2
    mid_rank = mid_index + find_rank(arr2, arr1[mid_index])
    if mid_rank == rank
      return mid_index
    elsif mid_rank > rank
      end_index = mid_index - 1
    else
      start_index = mid_index + 1
    end
  end
  return -1
end

# arr cannot be null
def find_rank(arr, val)
  size = arr.size
  return 0 if val < arr[0]
  return size if val > arr[size-1]

  start = 0
  end_i = size - 1
  mid = 0
  while start < end_i
    mid = (start + end_i) / 2
    if val > arr[mid]
      start = mid + 1
    else
      end_i = mid - 1
    end
  end
  return (start + 1) if arr[start] < val
  return start
end


arr1 = [1,2]
arr2 = [1,2]

puts find_index_of_rank(arr1, arr2, 2)
puts find_index_of_rank(arr2, arr1, 1)

puts find_median_sorted_arrays arr1, arr2