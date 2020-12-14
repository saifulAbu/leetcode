class Trie
  class TrieNode
    def initialize()
      @children = {}
      @complete = Hash.new() {false}
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
      end
      node = child
    end
    node.set_complete(word[-1])
  end

  def get_last_node(word)
    node = @root
    word.each_char do
      |ch|
      node = node.get_children(ch)
      return nil if node.nil?
    end
    return node
  end

  def search(word)
    last_node = get_last_node(word)
    return false if last_node.nil?
    return true if last_node.is_complete?(word[-1])
    return false
  end

  def starts_with(prefix)
    last_node = get_last_node(prefix)
    return false if last_node.nil?
    return true
  end
end

# Your Trie object will be instantiated and called as such:
 word = "word"
 obj = Trie.new()
 #obj.insert("saif")
 #obj.insert("sai")
 #obj.insert("sa")
p param_2 = obj.search("s")
#p param_3 = obj.starts_with("z")