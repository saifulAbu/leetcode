class Trie
  class TrieNode
    def initialize()
      @children = {}
      @complete = {}
    end

    def get_children(ch)
      return @children[ch]
    end

    def set_children(ch, node)
      @children[ch] = node
    end

    def is_complete?(ch)
      @complete[ch]
    end

    def set_complete(ch)
      @complete[ch] = true
    end
  end

  def initialize()
    @root = TrieNode.new
  end

  def insert(word)
    node = @root
    word.each_char do
      |ch|
      child = node.get_children(ch)
      if child.nil?
        child = TrieNode.new
        node.set_children(ch, child)
        node = child
      end
    end
    node.set_complete(word[-1])

    p @root
  end

  def search(word)

  end

  def starts_with(prefix)

  end
end

# Your Trie object will be instantiated and called as such:
 word = "word"
 obj = Trie.new()
 obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.starts_with(prefix)