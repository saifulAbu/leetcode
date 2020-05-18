# favorite
# @param {String} num
# @param {Integer} k
# @return {String}
def remove_kdigits(num, k)
  q = num.chars
  s = ["0"]
  until q.empty? or k == 0
    if s.last > q.first
      s.pop
      k -= 1
    else
      s << q.shift
    end
  end

  until k == 0
    s.pop
    k -= 1
  end

  s.delete_at(0)
  res = s + q
  res.join

  while res.first == "0"
    res.shift
  end

  res = "0" if res = ""

  res
end

p remove_kdigits("112", 2)