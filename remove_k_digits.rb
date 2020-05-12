# @param {String} num
# @param {Integer} k
# @return {String}
def remove_kdigits(num, k)
  k.times do
    if num.size <= 1
      num = ""
    else
      if num[0] > num[1]
        num.slice!(0)
      else
        num.slice!(1)
      end
    end
  end

  num.slice!(0) while num[0] == "0"
  return "0" if num.empty?
  num
end

p remove_kdigits("1234", 4)