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
# XPath Selector for listing the popularity of the movies, in the same order as which they occur in the given XML.
# Fill in the blanks to complete the required XPath selector query
puts doc.elements.each("collection/movie/popularity/text()")
