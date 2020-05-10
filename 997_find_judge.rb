require 'set'
# @param {Integer} n
# @param {Integer[][]} trust
# @return {Integer}
def find_judge(n, trust)
  trustees = Set.new
  trust_count = Array.new(n) {0}

  trust.each do
    |entry|
    trustee = entry[0] - 1
    trusted = entry[1] - 1
    trust_count[trusted] += 1
    trustees.add(trustee)
  end

  max_count = n - 1
  mayor = -1
  trust_count.each_with_index do
    |count, index|
    return -1 if count > max_count
    if count == max_count
      return -1 if mayor != -1
      return -1 if trustees.include? index
      mayor = index + 1
    end
  end

  return mayor
end

n = 2; trust = [[1,2]]
#p find_judge(n, trust)

n = 3; trust = [[1,3],[2,3]]
#p find_judge(n, trust)

n = 3; trust = [[1,3],[2,3],[3,1]]
#p find_judge(n, trust)

n = 3; trust = [[1,2],[2,3]]
#p find_judge(n, trust)

n = 4; trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
#p find_judge(n, trust)

n = 2; trust = [[2,1]]
p find_judge(n, trust)