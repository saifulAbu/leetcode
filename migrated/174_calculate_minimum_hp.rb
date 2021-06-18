# @param {Integer[][]} dungeon
# @return {Integer}
def calculate_minimum_hp(dungeon)
  row = dungeon.size
  col = dungeon[0].size

  # fill up dungeon[row-1][col-1] first
  dungeon[row-1][col-1] = [(1-dungeon[row-1][col-1]), 1].max

  # fill up the last row
  (col-2).downto(0) do
    |c|
    dungeon[row-1][c] = [(dungeon[row-1][c+1] - dungeon[row-1][c]), 1].max
  end
  #fill up the last col
  (row-2).downto(0) do
    |r|
    dungeon[r][col-1] = [(dungeon[r+1][col-1] - dungeon[r][col-1]), 1].max
  end

  (row-2).downto(0) do
    |r|
    (col-2).downto(0) do
      |c|
      #puts "r: #{r}, c:#{c}"
      # going right
      h1 = dungeon[r][c+1] - dungeon[r][c]
      # going right
      h2 = dungeon[r+1][c] - dungeon[r][c]

      dungeon[r][c] = [[h1, h2].min, 1].max
     end
   end
  dungeon[0][0]
end

d =  [[-2,-3,3],
      [-5,-10,1],
      [10,30,-5]]

calculate_minimum_hp(d)