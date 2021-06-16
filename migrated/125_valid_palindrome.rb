# @param {String} s
# @return {Boolean}
def is_palindrome(s)
  regex = /[0-9a-zA-Z]/
  size = s.size

  front = 0
  back = size - 1

  begin
    front += 1 until front >= back or s[front] =~ regex
    break if front >= back

    back -= 1 until front >= back or s[back] =~ regex
    break if front >= back

    return false unless s[front].casecmp?(s[back])

    front += 1
    back -= 1

  end while front < back

  return true
end

s = "race A e c    a ;;; r"
p is_palindrome s