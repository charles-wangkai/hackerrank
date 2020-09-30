def element_at(arr, index)
    return arr[index]
    # return the element of the Array variable `arr` at the position `index`
    # arr.at(index) # or
    # arr[index]
end

def inclusive_range(arr, start_pos, end_pos)
    return arr[start_pos..end_pos]
    # return the elements of the Array variable `arr` between the start_pos and end_pos (both inclusive)
end

def non_inclusive_range(arr, start_pos, end_pos)
    return arr[start_pos...end_pos]
    # return the elements of the Array variable `arr`, start_pos inclusive and end_pos exclusive
end

def start_and_length(arr, start_pos, length)
    return arr[start_pos,length]
    # return `length` elements of the Array variable `arr` starting from `start_pos`
end