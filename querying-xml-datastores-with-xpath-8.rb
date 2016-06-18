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
# Write the XPath selector for finding the number of characters (i.e, the string-length) in the description of the second movie in the XML file.
# Fill in the blanks to complete the required XPath selector query
puts doc.elements.each("string-length(collection/movie[2]/description/text())")
