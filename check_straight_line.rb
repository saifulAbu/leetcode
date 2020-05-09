# @param {Integer[][]} coordinates
# @return {Boolean}
def check_straight_line(coordinates)
  first = coordinates[0]
  second = coordinates[1]
  d_x = (second[0] - first[0])
  d_y = (second[1] - first[1])
  if d_x == 0
    #check all d_x are zero
    for i in (2..(coordinates.size-1)) do
      first = coordinates[i]
      second = coordinates[i-1]
      d_x = (second[0] - first[0])
      return false if d_x != 0
    end
  else
    slope = d_y / d_x
    for i in (2..(coordinates.size-1)) do
      first = coordinates[i]
      second = coordinates[i-1]
      d_x = (second[0] - first[0])
      d_y = (second[1] - first[1])
      return false if d_x == 0
      cur_slope = d_y / d_x
      return false if cur_slope != slope
    end
  end
  return true
end

#coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
#coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
#coordinates = [[2,1],[2,2],[2,3],[2,4],[2,5],[2,0]]
coordinates = [[1,7],[2,7],[3,7],[4,7],[5,7]]
coordinates = [[1,7],[2,7]]

p check_straight_line coordinates