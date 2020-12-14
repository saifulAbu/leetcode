require 'set'

# design a data structure that returns the first unique number of its list

class FirstUnique

=begin
    :type nums: Integer[]
=end
    def initialize(nums)
      @uniq = Set.new
      @non_uniq = Set.new
      nums.each do
        |elem|
        next if @non_uniq.include? elem
        if @uniq.include? elem
          @uniq.delete elem
          @non_uniq.add elem
        else
          @uniq.add elem
        end
      end
    end


=begin
    :rtype: Integer
=end
    def show_first_unique()
      return -1 if @uniq.empty?
      @uniq.first
    end


=begin
    :type value: Integer
    :rtype: Void
=end
    def add(elem)
      return if @non_uniq.include? elem
      if @uniq.include? elem
        @uniq.delete elem
        @non_uniq.add elem
      else
        @uniq.add elem
      end
    end
end

# Your FirstUnique object will be instantiated and called as such:
nums = [2,3,5]
obj = FirstUnique.new(nums)
puts obj.show_first_unique()
obj.add(5)
puts obj.show_first_unique()
obj.add(2)
puts obj.show_first_unique()
obj.add(3)
puts obj.show_first_unique()

