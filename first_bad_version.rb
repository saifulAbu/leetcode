# The is_bad_version API is already defined for you.
# @param {Integer} version
# @return {boolean} whether the version is bad
def is_bad_version(version)
  @@versions[version-1]
end

# @param {Integer} n
# @return {Integer}
def first_bad_version(n)
  return -1 if is_bad_version(n) == false #all of them are good versions
  return 1 if is_bad_version(1) == true
  start_version = 1
  end_version = n
  while start_version < end_version
    mid_version = (start_version + end_version) / 2
    if is_bad_version(mid_version)
      end_version = mid_version
    else
      start_version = mid_version + 1
    end
  end
  start_version
end

@@versions = [true]
p first_bad_version 8