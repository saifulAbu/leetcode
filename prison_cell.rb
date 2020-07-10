require 'set'

# @param {Integer[]} cells
# @param {Integer} n
# @return {Integer[]}
def prison_after_n_days(cells, n)
  map = {}
  set = Set.new
  map[0] = cells
  set.add(cells)

  period = 1
  cur_day = cells
 # p cur_day
  while true
    cur_day = next_day(cur_day)
    if set.include? cur_day
      break
    end
    #p cur_day
    map[period] = cur_day
    set.add(cur_day)
    period += 1
  end
  n = n % period
  #p map
  map[n]
end

def next_day(prev_day)
  res = Array.new(8) {0}
  1.upto(6) do
    |i|
    if (prev_day[i-1] == 0 and prev_day[i+1] == 0) or (prev_day[i-1] == 1 and prev_day[i+1] == 1)
      res[i] = 1
    end
  end
  res
end

start = [1,0,0,1,0,0,1,0]
p prison_after_n_days(start, 15)


=begin
size of the cells is fixed, r rows. n can be between 1 to 10 ^ 9
so content of cells will repeat.

def next_day cur

end

day = 0
cur = start_day
set.add cur
map.add(0, start_day)
while true
  day += 1
  cur = next_day cur
  break if set.include? cur
  set.add cur
  map.add(day, cur)
end

rep = day - 1
res_day = n % rep

return map.get(res_day)
=end