require 'set'

# @param {Integer[]} cells
# @param {Integer} n
# @return {Integer[]}
def prison_after_n_days(cells, n)
  map = {}
  cell_day_map = {}
  set = Set.new
  map[0] = cells
  cell_day_map[cells] = 0
  set.add(cells)
  cur_day = 0
  period = 0
  day_rep_began = 0
  cur_cell = cells
  while true
    cur_day += 1
    cur_cell = next_day(cur_cell)
    #p cur_cell
    if set.include? cur_cell
      day_rep_began = cell_day_map[cur_cell]
      period = cur_day - day_rep_began
      break
    end
    #p cur_day
    map[cur_day] = cur_cell
    cell_day_map[cur_cell] = cur_day
    set.add(cur_cell)
  end
  final_index = (n - day_rep_began) % period + day_rep_began
  #p map
  map[final_index]
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
p prison_after_n_days(start, 1000000000)


=begin
note for sat july 11
make a reverse map of cell => day
figure out which day the repetition began

if repetition
 period_len = cur_day - map[cur_day]
end

final_index = (N - day_rep_began) % period_len + day_rep_began

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