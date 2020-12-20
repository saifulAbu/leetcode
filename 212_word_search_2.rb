require 'pry'
require 'pry-nav'

class TrieNode
  attr_accessor :child, :word
  def initialize
    @child = {}
    @word = {}
  end
end

def insert_word(words)
  root = TrieNode.new
  for word in words
    current = root
    for i in (0..(word.size-1))
      ch = word[i]
      if i == word.size-1
          current.word[ch] = word
      end
      if current.child[ch].nil?
        current.child[ch] = TrieNode.new
      end
      current = current.child[ch]
    end
  end
  return root
end

def dfs_search(board, visited, r, c, trie, result)
  #binding.pry
  ch = board[r][c]
  return if trie.child[ch].nil?
  unless trie.word[ch].nil?
    result << trie.word[ch]
  #  puts "putting word #{trie.word[ch]}"
    trie.word[ch] = nil
  end

  trie = trie.child[ch]
  return if trie.nil?

  visited[r][c] = true
  if (r < board.size - 1) and (!visited[r+1][c])
    next_ch = board[r+1][c]
    unless trie.child[next_ch].nil?
      dfs_search(board, visited, r+1, c, trie, result)
    end
  end

  if (r > 0) and (!visited[r-1][c])
    next_ch = board[r-1][c]
    unless trie.child[next_ch].nil?
      dfs_search(board, visited, r-1, c, trie, result)
    end
  end

  if (c < board[0].size - 1) and (!visited[r][c+1])
    next_ch = board[r][c+1]
    unless trie.child[next_ch].nil?
      dfs_search(board, visited, r, c+1, trie, result)
    end
  end

  if (c > 0) and (!visited[r][c-1])
    next_ch = board[r][c-1]
    unless trie.child[next_ch].nil?
      dfs_search(board, visited, r, c-1, trie, result)
    end
  end
  visited[r][c] = false
end

# @param {Character[][]} board
# @param {String[]} words
# @return {String[]}
def find_words(board, words)
  root = insert_word(words)
  visited = Array.new(board.size) { Array.new(board[0].size) {false} }
  result = []
  for r in (0..board.size - 1)
    for c in (0..board[0].size - 1)
      ch = board[r][c]
      unless root.child[ch].nil?
        dfs_search(board, visited, r, c, root, result)
      end
    end
  end
  return result
end



words = ["oath","pea","eat","rain"]
#words = ["abc", "acb", "abc"]
board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
#words = ["bcb", "bab", "bac"]
#board = ["abc".chars, "bab".chars]
p find_words(board, words)