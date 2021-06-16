# @param {Integer[]} nums
# @return {Integer}
def remove_duplicates(arr)
  return 0 if arr.empty?

  back_ptr = 0
  for front_ptr in 0..(arr.size-1) do
    if arr[back_ptr] != arr[front_ptr]
      back_ptr += 1
      arr[back_ptr] = arr[front_ptr]
    end
  end
  return back_ptr + 1
end

nums = [0,0,1,1,1,2,2,3,3,4]
nums = [0, 1, 2, 3, 4, 5]

p remove_duplicates []
