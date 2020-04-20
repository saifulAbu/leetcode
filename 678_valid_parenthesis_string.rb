# @param {String} s
# @return {Boolean}
def check_valid_string(s)
  str_len = s.size
  dp = Array.new(str_len) {Array.new(str_len) {0}}
end

p check_valid_string("(*)")