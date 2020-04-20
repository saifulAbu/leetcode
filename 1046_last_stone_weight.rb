# @param {Integer[]} stones
# @return {Integer}
def last_stone_weight(stones)
  stones = stones.sort {|x, y| y <=> x}
  size = stones.size
  until size == 1
    val1 = stones[0]
    val2 = stones[1]
    stones.shift(2)
    insert(stones, val1 - val2)
    size -= 1
  end
  return stones[0]
end

def insert(stones, val)
  if stones.empty?
    stones << val
    return
  end

  index = 0
  loop do
    if val < stones[index]
      index += 1
    else
      break
    end
    break if index > stones.size - 1
  end
  stones.insert(index, val)
end

p last_stone_weight [1, 1, 1]

