# @param {Integer} num
# @return {Boolean}
def is_perfect_square(num)
  return true if num == 1 or num == 0

  start_boundary = 1
  end_boundary = num / 2

  begin
    mid = (start_boundary + end_boundary ) / 2
    sqr = mid * mid

    if sqr > num
      end_boundary = mid - 1
    elsif sqr < num
      start_boundary = mid + 1
    else
      return true
    end
  end while start_boundary <= end_boundary

  return false
end

p is_perfect_square 8