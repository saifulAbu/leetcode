# @param {String} s
# @return {Integer}
def balanced_string_split(s)
  count = 0
  balance = 0
  s.each_char do
    |ch|
    if ch == "R"
      balance += 1
    else
      balance -= 1
    end
    count += 1 if balance == 0
  end
  count
end

s = "RLRRLLRLRL"
p balanced_string_split(s)