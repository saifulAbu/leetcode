# @param {String} word1
# @param {String} word2
# @return {Integer}
def min_distance(word1, word2)

end

def min_distance_recursive(src, dest)
  if(src.empty? and dest.empty?)
    return 0
  end

  if(src.empty?)
    return dest.size
  end

  if(dest.empty?)
    return src.size
  end

  if(src[-1] == dest[-1])
    return min_distance_recursive(src.chop, dest.chop)
  else
    delete = min_distance_recursive(src.chop, dest)
    insert = min_distance_recursive(src, dest.chop)
    replace = min_distance_recursive(src.chop, dest.chop)
    return [delete, insert, replace].min + 1
  end
end

p min_distance("dinitrophenylhydrazine", "benzalphenylhydrazone")