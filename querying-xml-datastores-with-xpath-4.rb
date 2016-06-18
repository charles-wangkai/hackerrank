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
#XPath selector for picking up the popularity of the movie with the title "Trigun"
puts doc.elements["collection/movie[@title = 'Trigun']/popularity/text()"]
