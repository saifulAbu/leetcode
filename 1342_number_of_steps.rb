# @param {Integer} num
# @return {Integer}
def number_of_steps (num)
  steps = 0
  until num == 0
    if num.even?
      num /= 2
    else
      num -= 1
    end
    steps += 1
  end
  steps
end

p number_of_steps 8