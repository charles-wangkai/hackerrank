def neg_pos(arr, index)
  # return the element of the array at the position `index` from the end of the list
  arr[-index]
end

def first_element(arr)
  # return the first element of the array
  arr.first
end

def last_element(arr)
  # return the last element of the array
  arr.last
end

def first_n(arr, n)
  # return the first n elements of the array
  arr.take(n)
end

def drop_n(arr, n)
  # drop the first n elements of the array and return the rest
  arr.drop(n)
end
