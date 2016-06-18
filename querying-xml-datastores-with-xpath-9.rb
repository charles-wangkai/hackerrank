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
# Write the XPath selector for listing the title of the second movie for which the marked shelf = "B".
# Fill in the blanks to complete the required XPath selector query
puts doc.elements.each("collection/movie[@shelf = 'B'][2]/@title")
