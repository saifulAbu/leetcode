# @param {String} address
# @return {String}
def defang_i_paddr(address)
  address.gsub(/\./,'[.]')
end

address = "255.100.50.0"
p defang_i_paddr(address)