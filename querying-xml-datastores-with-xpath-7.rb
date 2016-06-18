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
# XPath Selector for computing the average popularity of the movies in the given XML fragment.
# Fill in the blanks to complete the required XPath selector query
puts XPath.match(doc,"sum(collection/movie/popularity) div count(collection/movie/popularity)")
