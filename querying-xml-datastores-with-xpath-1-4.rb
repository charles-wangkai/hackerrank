# Standard ruby library for XML parsing
require 'rexml/document'
include REXML

# Enter your code here. Read input from STDIN. Print output to STDOUT
xmlText = "" 

# Read the input XML Fragment
while line = gets()
   xmlText += line
end

doc = Document.new xmlText


# XPath selector for picking up the shelf of the movie named 'Transformers'
# Fill in the blanks to complete the required XPath selector query
# Assume there is only ONE such movie.
puts doc.elements["collection/movie[@title = 'Transformers']/@shelf"]
