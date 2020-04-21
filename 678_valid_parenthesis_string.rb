# @param {String} s
# @return {Boolean}
def check_valid_string(s)
  return true if s.empty?
  str_len = s.size
  dp = Array.new(str_len) {Array.new(str_len) {0}}
  #initialize size 1 and size 2 cells
  for i in (0..(str_len - 1)) do
    if s[i] == "*"
      dp[i][i] = 1
    end
    if  (i < str_len - 1) and (s[i] == "*" or s[i] == "(") and (s[i+1] == "*" or s[i+1] == ")")
        dp[i][i+1] = 1
    end
  end

  for end_offset in (2..(str_len - 1)) do
    for i in (0..(str_len - end_offset - 1)) do
      j = i + end_offset
      if s[j] == "*" and dp[i][j-1] == 1
          dp[i][j] = 1
      elsif s[j] == "*" or s[j] == ")"
        if ((s[i] == "*" or s[i] == "(") and (dp[i+1][j-1] == 1)) or ((s[j-1] == "*" or s[j-1] == "(") and (dp[i][j-2] == 1))
          dp[i][j] = 1
        else
          for k in ((i+1)..(j-2)) do
            if (s[k] == "*" or s[k] == "(")
              if (dp[i][k-1] == 1 and dp[k+1][j-1] == 1)
                dp[i][j] == 1
              end
            end
          end
        end
      else
        dp[i][j] = 0
      end
    end
  end
  #p dp
  dp[0][str_len-1] == 1
end

p check_valid_string "()(())"