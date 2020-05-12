# @param {Integer[][]} image
# @param {Integer} sr
# @param {Integer} sc
# @param {Integer} new_color
# @return {Integer[][]}
def flood_fill(image, sr, sc, new_color)
  old_color = image[sr][sc]
  return image if old_color == new_color
  @max_row = image.length
  @max_col = image[0].length
  flood_fill_helper(image, sr, sc, new_color)
  return image
end

def flood_fill_helper(image, sr, sc, new_color)
  old_color = image[sr][sc]
  image[sr][sc] = new_color

  #neighbor row and col
  nr = sr - 1
  nc = sc
  if nr >= 0 and image[nr][nc] == old_color
    flood_fill_helper(image, nr, nc, new_color)
  end
  nr = sr + 1
  if nr < @max_row and image[nr][nc] == old_color
    flood_fill_helper(image, nr, nc, new_color)
  end

  nr = sr
  nc = sc - 1
  if nc >= 0 and image[nr][nc] == old_color
    flood_fill_helper(image, nr, nc, new_color)
  end

  nr = sr
  nc = sc + 1
  if sc < @max_col and image[nr][nc] == old_color
    flood_fill_helper(image, nr, nc, new_color)
  end
end

image = [[1,1,1],[1,1,1],[1,1,1]]
sr = 2
sc = 2
new_color = 2

p flood_fill(image, sr, sc, new_color)